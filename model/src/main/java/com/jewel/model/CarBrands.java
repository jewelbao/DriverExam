package com.jewel.model;

import android.text.TextUtils;

import com.github.promeg.pinyinhelper.Pinyin;

import java.util.List;

import lombok.Data;

@Data
public class CarBrands {


    /**
     * name : ACSchnitzer  汽车品牌
     * son : [{"car":"ACSchnitzer","type":"ACSchnitzerX5"}]
     */

    /**
     * 汽车品牌
     */
    private String name;
    private List<CarBrandSon> son;

    public String getFirstLetter() {
        if(TextUtils.isEmpty(name)) {
            return "*";
        }
        return Pinyin.toPinyin(name.charAt(0)).substring(0, 1);
    }
}
