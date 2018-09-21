package com.jewel.model;

import lombok.Data;

@Data
public class ExamCategory implements ICategoryData{


    /**
     * cid : 193
     * title : 违法行为综合判断与案例分析
     */

    private String cid;
    private String title;

    @Override
    public String getData() {
        return title;
    }

    @Override
    public String getId() {
        return cid;
    }


}
