package com.jewel.driverexam;

import android.content.Intent;
import android.view.View;

import com.jewel.core.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    @Override
    protected int getContentLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        setDoubleClick2Exit(true);
    }

    @OnClick({R.id.btn_topic_one, R.id.btn_topic_four, R.id.btn_topic_category, R.id.btn_car, R.id.btn_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_topic_one:
                TopicActivity.startActivity(this, TopicActivity.TYPE_ONE, null, null);
                break;
            case R.id.btn_topic_four:
                TopicActivity.startActivity(this, TopicActivity.TYPE_FOUR, null, null);
                break;
            case R.id.btn_topic_category:
                startActivity(new Intent(this, CategoryActivity.class));
                break;
            case R.id.btn_car:
                startActivity(new Intent(this, CarCategoryActivity.class));
                break;
        }
    }
}
