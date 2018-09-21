package com.jewel.driverexam;

import android.animation.LayoutTransition;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jewel.SnackBarUtils;
import com.jewel.core.BaseActivity;
import com.jewel.http.business.ExamRequest;
import com.jewel.http.core.IHttpCallback;
import com.jewel.model.ExamCategories;
import com.jewel.model.ExamCategory;
import com.jewel.recyclerView.RecyclerViewUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryActivity extends BaseActivity implements IHttpCallback<List<ExamCategories>>, BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.rv_category)
    RecyclerView rvCategory;
    @BindView(R.id.rv_category_sub)
    RecyclerView rvCategorySub;
    @BindView(R.id.layout_parent)
    LinearLayout layoutParent;

    private CategoryAdapter categoryAdapter;
    private CategoryAdapter subCategoryAdapter;

    private LayoutTransition layoutTransition;

    private ExamRequest request = new ExamRequest();

    @Override
    protected int getContentLayout() {
        return R.layout.activity_category;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);

        layoutTransition = new LayoutTransition();
        layoutTransition.enableTransitionType(LayoutTransition.CHANGE_APPEARING);
        layoutParent.setLayoutTransition(layoutTransition);
        rvCategorySub.setVisibility(View.GONE);

        categoryAdapter = new CategoryAdapter(null);
        categoryAdapter.setOnItemClickListener(this);
        RecyclerViewUtil.setupListView(rvCategory, categoryAdapter, false, android.R.color.transparent, 15);

        subCategoryAdapter = new CategoryAdapter(null);
        subCategoryAdapter.setOnItemClickListener(this);
        subCategoryAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);
        RecyclerViewUtil.setupListView(rvCategorySub, subCategoryAdapter, android.R.color.transparent);
    }

    @Override
    protected void getData() {
        super.getData();
        request.getCategory(this);
    }

    @Override
    public void onStart(int what) {
        showLoading();
    }

    @Override
    public void onSuccess(int what, List<ExamCategories> data) {
        categoryAdapter.setNewData(new ArrayList<>(data));
    }

    @Override
    public void onFail(int what, String msg) {
        SnackBarUtils.showLong(getWindow().getDecorView(), msg);
    }

    @Override
    public void onError(int what, Throwable e) {
        SnackBarUtils.showLong(getWindow().getDecorView(), e.getMessage());
    }

    @Override
    public void onFinish(int what) {
        dismissLoading();
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        if (adapter == categoryAdapter) {
            ExamCategories categories = (ExamCategories) categoryAdapter.getItem(position);
            if (categories != null) {
                List<ExamCategory> subCategory = categories.getCategories();
                subCategoryAdapter.setNewData(new ArrayList<>(subCategory));
                rvCategorySub.setVisibility(View.VISIBLE);
            }
        } else if (adapter == subCategoryAdapter) {
            ExamCategory examCategory = (ExamCategory) subCategoryAdapter.getItem(position);
            if(examCategory != null) {
                TopicActivity.startActivity(this, TopicActivity.TYPE_CATEGORY_DETAIL, examCategory.getTitle(), examCategory.getCid());
            }
        }
    }
}
