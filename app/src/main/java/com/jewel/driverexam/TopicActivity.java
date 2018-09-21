package com.jewel.driverexam;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.AppCompatRadioButton;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.jewel.SnackBarUtils;
import com.jewel.core.BaseActivity;
import com.jewel.http.business.ExamRequest;
import com.jewel.http.core.IHttpCallback;
import com.jewel.model.ExamData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class TopicActivity extends BaseActivity implements IHttpCallback<List<ExamData>> {

    @BindView(R.id.tv_next)
    TextView tvNext;
    @BindView(R.id.tv_question_title)
    TextView tvQuestionTitle;
    @BindView(R.id.iv_question_file)
    ImageView ivQuestionFile;
    @BindView(R.id.tv_answer_a)
    AppCompatRadioButton tvAnswerA;
    @BindView(R.id.tv_answer_b)
    AppCompatRadioButton tvAnswerB;
    @BindView(R.id.tv_answer_c)
    AppCompatRadioButton tvAnswerC;
    @BindView(R.id.tv_answer_d)
    AppCompatRadioButton tvAnswerD;
    @BindView(R.id.group_answer)
    RadioGroup groupAnswer;

    private ExamRequest request = new ExamRequest();

    private final static String KEY_CID = "cid";
    private final static String KEY_TYPE = "type";
    private final static String KEY_CATEGORY_NAME = "categoryName";
    public final static int TYPE_ONE = 1;
    public final static int TYPE_FOUR = 2;
    public final static int TYPE_CATEGORY_DETAIL = 3;

    private static final String TYPE_JUDGE = "judge";
    private static final String TYPE_SELECT = "select";

    private String title;
    private String cid;
    private int type = TYPE_ONE;
    private int page = 1;
    private int total = -1;
    private boolean isNextRequest = true;
    private String currentExplain;// 当前题目解释
    private String currentAnswer; // 当前题目答案
    private String currentTopicType;  // 当前题目类型：1

    public static void startActivity(Context context, int type, String title, String cid) {
        Intent intent = new Intent(context, TopicActivity.class);
        intent.putExtra(KEY_TYPE, type);
        if (!TextUtils.isEmpty(cid)) {
            intent.putExtra(KEY_CID, cid);
        }
        if (!TextUtils.isEmpty(title)) {
            intent.putExtra(KEY_CATEGORY_NAME, title);
        }
        context.startActivity(intent);
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_topic;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        Intent intent = getIntent();
        if (intent != null) {
            type = intent.getIntExtra(KEY_TYPE, type);
            cid = intent.getStringExtra(KEY_CID);
            String categoryTitle = intent.getStringExtra(KEY_CATEGORY_NAME);
            if (type == TYPE_ONE) {
                title = "科目一[%s/%s]";
            } else if (type == TYPE_FOUR) {
                title = "科目四[%s/%s]";
            } else if (type == TYPE_CATEGORY_DETAIL) {
                if (!TextUtils.isEmpty(categoryTitle) && categoryTitle.length() > 5) {
                    categoryTitle = categoryTitle.substring(0, 5) + "...";
                }
                title = categoryTitle + "[%s/%s]";
            } else {
                title = "驾考题[%s/%s]";
            }
        }
        setDoubleClick2Exit(false);

        setTitle();
    }

    private void setTitle() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(String.format(title, page, total));
        }
    }

    @OnCheckedChanged(R.id.tv_answer_a)
    public void checkedA(boolean checked) {
        disableCheckedView();
        if (checked) {
            setCheckedRight(tvAnswerA, "1");
        }
    }

    @OnCheckedChanged(R.id.tv_answer_b)
    public void checkedB(boolean checked) {
        disableCheckedView();
        if (checked) {
            setCheckedRight(tvAnswerB, TextUtils.equals(TYPE_SELECT, currentTopicType) ? "2" : "0");
        }
    }

    @OnCheckedChanged(R.id.tv_answer_c)
    public void checkedC(boolean checked) {
        disableCheckedView();
        if (checked) {
            setCheckedRight(tvAnswerC, "3");
        }
    }

    @OnCheckedChanged(R.id.tv_answer_d)
    public void checkedD(boolean checked) {
        disableCheckedView();
        if (checked) {
            setCheckedRight(tvAnswerD, "4");
        }
    }

    // 判断答案是否正确
    private void setCheckedRight(CompoundButton view, String answer) {
        if (TextUtils.equals(answer, currentAnswer)) {
            checkedCorrect(view, true);
        } else {
            checkedCorrect(view, false);
            getAnswerBySelectTopic();
        }
    }

    // 更改不同状态下的字体颜色和右侧图标
    private void checkedCorrect(CompoundButton view, boolean isCorrect) {
        view.setTextColor(getResources().getColor(isCorrect ? android.R.color.holo_green_dark : R.color.colorAccent));
        changeCheckedViewStyle(view, isCorrect);
    }

    // 更改右侧图标
    private void changeCheckedViewStyle(CompoundButton view, boolean isCorrect) {
        int drawable = isCorrect ? R.mipmap.icon_right : R.mipmap.icon_false;
        view.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawable, 0);
    }

    private void enableCheckedView() {
        tvAnswerA.setEnabled(true);
        tvAnswerB.setEnabled(true);
        tvAnswerC.setEnabled(true);
        tvAnswerD.setEnabled(true);
    }

    private void disableCheckedView() {
        tvAnswerA.setEnabled(false);
        tvAnswerB.setEnabled(false);
        tvAnswerC.setEnabled(false);
        tvAnswerD.setEnabled(false);
    }

    // 获取正确答案
    private void getAnswerBySelectTopic() {
        switch (currentAnswer) {
            case "1":
                checkedCorrect(tvAnswerA, true);
                break;
            case "0":
                checkedCorrect(tvAnswerB, true);
                break;
            case "2":
                checkedCorrect(tvAnswerB, true);
                break;
            case "3":
                checkedCorrect(tvAnswerC, true);
                break;
            case "4":
                checkedCorrect(tvAnswerD, true);
                break;
        }
    }

    @Override
    protected void getData() {
        clearCheckedStatus();
        if (type == TYPE_ONE) {
            request.getQuestion1(page, this);
        } else if (type == TYPE_FOUR) {
            request.getQuestion4(page, this);
        } else if (type == TYPE_CATEGORY_DETAIL) {
            request.getCategoryDetail(cid, page, this);
        }
    }

    @Override
    public void onStart(int what) {
        showLoading();
    }

    @Override
    public void onSuccess(int what, List<ExamData> data) {
        if (data != null && !data.isEmpty()) {
            ExamData examData = data.get(0);
            if (examData != null) {

                total = examData.getTotal();
                currentExplain = examData.getExplainText();
                currentAnswer = examData.getVal();
                currentTopicType = examData.getTikuType();

                setImage(ivQuestionFile, examData.getFile());
                setText(tvQuestionTitle, examData.getTitle());

                boolean isJudge = TextUtils.equals(TYPE_JUDGE, currentTopicType);
                setText(tvAnswerA, isJudge ? "正确" : examData.getA());
                setText(tvAnswerB, isJudge ? "错误" : examData.getB());
                setText(tvAnswerC, examData.getC());
                setText(tvAnswerD, examData.getD());


                setTitle();
            }
        }
    }

    @Override
    public void onFail(int what, String msg) {
        tvNext.performClick();
    }

    @Override
    public void onError(int what, Throwable e) {
        tvQuestionTitle.setText("数据异常，请刷新页面");
        if (isNextRequest) {
            page--;
        } else {
            page++;
        }
    }

    @Override
    public void onFinish(int what) {
        dismissLoading();
    }

    private void setText(TextView view, String text) {
        if (!TextUtils.isEmpty(text)) {
            view.setVisibility(View.VISIBLE);
            view.setText(text);
        } else {
            view.setVisibility(View.GONE);
        }
    }

    private void setImage(ImageView view, String url) {
        if (TextUtils.isEmpty(url)) {
            view.setVisibility(View.GONE);
        } else {
            view.setVisibility(View.VISIBLE);
            GlideApp.with(view.getContext()).load(url).placeholder(R.drawable.ic_collections_image_24dp)
                    .error(R.drawable.ic_broken_image_24dp).fitCenter().into(view);
        }
    }

    @OnClick({R.id.tv_pre, R.id.tv_help, R.id.tv_next, R.id.tv_refresh})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_pre:
                if (page > 1) {
                    isNextRequest = false;
                    page--;
                    getData();
                } else {
                    ToastUtils.showShort("这就是第一题");
                }
                break;
            case R.id.tv_help:
                SnackBarUtils.showAction(tvNext, currentExplain);
                break;
            case R.id.tv_refresh:
                getData();
                break;
            case R.id.tv_next:
                if (page < total) {
                    isNextRequest = true;
                    page++;
                    getData();
                } else {
                    ToastUtils.showShort("这是最后一题啦");
                }
                break;
        }
    }

    // 清除单选按钮的状态，还原为初始值
    private void clearCheckedStatus() {
        groupAnswer.clearCheck();
        enableCheckedView();
        clearCheckedViewStyle(tvAnswerA);
        clearCheckedViewStyle(tvAnswerB);
        clearCheckedViewStyle(tvAnswerC);
        clearCheckedViewStyle(tvAnswerD);
    }

    // 还原单选按钮字体颜色和右侧图标
    private void clearCheckedViewStyle(CompoundButton view) {
        view.setTextColor(getResources().getColor(R.color.selector_checked));
        view.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
}
