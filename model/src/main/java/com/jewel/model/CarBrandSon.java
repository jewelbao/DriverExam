package com.jewel.model;

import lombok.Data;

@Data
public class CarBrandSon {
    /**
     * car : ACSchnitzer   汽车子品牌或合资品牌
     * type : ACSchnitzerX5   车系名称
     */

    /**
     * 汽车子品牌或合资品牌
     */
    private String car;
    /**
     * 车系名称
     */
    private String type;
}
