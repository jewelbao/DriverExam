package com.jewel.driverexam;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jewel.model.ICategoryData;

import java.util.List;
import java.util.Random;

public class CategoryAdapter extends BaseQuickAdapter<ICategoryData, BaseViewHolder> {

//    private Random random = new Random(255);

    public CategoryAdapter(@Nullable List<ICategoryData> data) {
        super(R.layout.item_category, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ICategoryData item) {
//        CardView cardView = helper.getView(R.id.card);
//        cardView.setCardBackgroundColor(Color.argb(255, random.nextInt(), random.nextInt(), random.nextInt()));
        helper.setText(R.id.tv_data, item.getData());
//                .setTextColor(R.id.tv_data, Color.argb(255, random.nextInt(), random.nextInt(), random.nextInt()));
    }
}
