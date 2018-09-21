package com.jewel.model;

import lombok.Data;

@Data
public class CarSeries {

    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * 数据id(查询车型详细信息用到)
     */
    private String carId;
    /**
     * 指导价
     */
    private String guidePrice;
    /**
     * 车型名称
     */
    private String seriesName;


}
