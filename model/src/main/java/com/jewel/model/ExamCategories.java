package com.jewel.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Data;

@Data
public class ExamCategories implements ICategoryData {

    private String categoryTitle;
    private List<ExamCategory> categories;

    public static List<ExamCategories> parseJson(String str) throws Exception {
        com.alibaba.fastjson.JSONObject obj = com.alibaba.fastjson.JSONObject.parseObject(str);
        Iterator<String> keys = obj.keySet().iterator();

        List<ExamCategories> allCategories = new ArrayList<>();

        while (keys.hasNext()) {
            String key = keys.next();

            ExamCategories examCategories = new ExamCategories();
            List<ExamCategory> subCategories = new ArrayList<>();

            examCategories.setCategoryTitle(key);

            com.alibaba.fastjson.JSONArray jsonArray = obj.getJSONArray(key);
            for (int i = 0; i < jsonArray.size(); i++) {
                com.alibaba.fastjson.JSONObject o = (com.alibaba.fastjson.JSONObject) jsonArray.get(i);
                ExamCategory category = new ExamCategory();
                category.setCid(o.getString("cid"));
                category.setTitle(o.getString("title"));
                subCategories.add(category);
            }
            examCategories.setCategories(subCategories);

            allCategories.add(examCategories);
        }
        return allCategories;
    }

    @Override
    public String getData() {
        return categoryTitle;
    }

    @Override
    public String getId() {
        return null;
    }
}
