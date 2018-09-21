package com.jewel.driverexam;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jewel.model.CarBrandSon;
import com.jewel.model.CarBrands;

import java.util.ArrayList;
import java.util.List;

public class CarBrandsAdapter extends BaseExpandableListAdapter {

    private List<CarBrands> data;

    public void setData(List<CarBrands> data) {
        if (data == null) {
            data = new ArrayList<>();
        }
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getGroupCount() {
        if (data == null || data.isEmpty())
            return 0;
        return data.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if (data == null || data.isEmpty())
            return 0;
        if (data.get(groupPosition) == null || data.get(groupPosition).getSon() == null || data.get(groupPosition).getSon().isEmpty())
            return 0;
        return data.get(groupPosition).getSon().size();
    }

    @Override
    public CarBrands getGroup(int groupPosition) {
        if (data == null || data.isEmpty())
            return null;
        return data.get(groupPosition);
    }

    @Override
    public CarBrandSon getChild(int groupPosition, int childPosition) {
        if (data == null || data.isEmpty())
            return null;
        if (data.get(groupPosition) == null)
            return null;
        if (data.get(groupPosition).getSon() == null || data.get(groupPosition).getSon().isEmpty())
            return null;
        return data.get(groupPosition).getSon().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return (groupPosition + 1) * 1000 + childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View view = convertView;
        GroupHolder holder;
        if(view == null){
            holder = new GroupHolder();
            view = View.inflate(parent.getContext(), R.layout.item_car_brand_group, null);
            holder.groupName = view.findViewById(R.id.tv_brand_group);
            holder.arrow = view.findViewById(R.id.iv_expand);
            view.setTag(holder);
        }else{
            holder = (GroupHolder)view.getTag();
        }

        //判断是否已经打开列表
        if(isExpanded){
            holder.arrow.setBackgroundResource(R.mipmap.icon_collapse);
        }else{
            holder.arrow.setBackgroundResource(R.mipmap.icon_expand);
        }

        holder.groupName.setText(getGroup(groupPosition).getName());

        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        Context context = parent.getContext();
        View view = convertView;
        ChildHolder holder;
        if(view == null){
            holder = new ChildHolder();
            view = View.inflate(context, R.layout.item_car_brand_child, null);
            holder.childbrand = view.findViewById(R.id.tv_brand_child);
            holder.childName = view.findViewById(R.id.tv_car_name);
            view.setTag(holder);
        }else{
            holder = (ChildHolder)view.getTag();
        }

        final CarBrandSon data = getChild(groupPosition, childPosition);
        holder.childbrand.setText(String.format(context.getResources().getString(R.string.brand_name), data.getCar()));
        holder.childName.setText(String.format(context.getResources().getString(R.string.car_name), data.getType()));

        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    private static class GroupHolder{
        TextView groupName;
        ImageView arrow;
    }

    private static class ChildHolder{
        TextView childbrand;
        TextView childName;
    }
}
