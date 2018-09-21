package com.jewel.driverexam;

import android.view.View;
import android.widget.ExpandableListView;

import com.bigkoo.quicksidebar.QuickSideBarTipsView;
import com.bigkoo.quicksidebar.QuickSideBarView;
import com.bigkoo.quicksidebar.listener.OnQuickSideBarTouchListener;
import com.jewel.SnackBarUtils;
import com.jewel.core.BaseActivity;
import com.jewel.http.business.CarRequest;
import com.jewel.http.core.IHttpCallback;
import com.jewel.model.CarBrandSon;
import com.jewel.model.CarBrands;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CarCategoryActivity extends BaseActivity implements IHttpCallback<List<CarBrands>>, ExpandableListView.OnChildClickListener, OnQuickSideBarTouchListener {

    @BindView(R.id.expand_list)
    ExpandableListView expandList;
    CarBrandsAdapter carBrandsAdapter;

    @BindView(R.id.quickSideBarView)
    QuickSideBarView quickSideBarView;
    @BindView(R.id.quickSideBarTipsView)
    QuickSideBarTipsView quickSideBarTipsView;

    HashMap<String, Integer> letters = new HashMap<>();
    CarRequest request = new CarRequest();

    @Override
    protected int getContentLayout() {
        return R.layout.activity_car_brands;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getResources().getString(R.string.menu_car));
        }

        carBrandsAdapter = new CarBrandsAdapter();
        expandList.setOnChildClickListener(this);
        expandList.setAdapter(carBrandsAdapter);
        expandList.setGroupIndicator(null);

        quickSideBarView.setVisibility(View.GONE);
        quickSideBarTipsView.setVisibility(View.GONE);
        //设置监听
        quickSideBarView.setOnQuickSideBarTouchListener(this);
    }

    @Override
    protected void getData() {
        super.getData();
        request.getCarBrands(this);
    }

    @Override
    public void onStart(int what) {
        showLoading();
    }

    @Override
    public void onSuccess(int what, List<CarBrands> data) {
        carBrandsAdapter.setData(data);

        if(data != null && !data.isEmpty()) {
            for (int i = 0; i < data.size(); i++) {
                String letter = data.get(i).getFirstLetter();
                //如果没有这个key则加入并把位置也加入
                if (!letters.containsKey(letter)) {
                    letters.put(letter, i);
                }
            }
            quickSideBarView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onFail(int what, String msg) {
        SnackBarUtils.showIndefinite(expandList, msg);
    }

    @Override
    public void onError(int what, Throwable e) {
        SnackBarUtils.showAction(expandList, e.getMessage());
    }

    @Override
    public void onFinish(int what) {
        dismissLoading();
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        CarBrandSon data = carBrandsAdapter.getChild(groupPosition, childPosition);

        return true;
    }

    @Override
    public void onLetterChanged(String letter, int position, float y) {
        quickSideBarTipsView.setText(letter, position, y);
        //有此key则获取位置并滚动到该位置
        if (letters.containsKey(letter)) {
            int lastPosition = letters.get(letter);
            expandList.smoothScrollToPositionFromTop(lastPosition, 0);
        }
    }

    @Override
    public void onLetterTouching(boolean touching) {
        //可以自己加入动画效果渐显渐隐
        quickSideBarTipsView.setVisibility(touching ? View.VISIBLE : View.GONE);
    }
}
