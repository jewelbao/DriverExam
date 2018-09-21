package com.jewel.http.business;

/**
 * @author Jewel
 * @version 1.0
 * @since 2018/04/01
 */

public class HttpConfig {

    public static class Params {
        public static final String KEY = "key";
        public static final String KEY_VALUE = "1bb017a697230";

        public static final String CID = "cid";
        /**
         * 查询起始页：默认为1
         */
        public static final String PAGE = "page";
        /**
         * 查询页大小：默认为10
         */
        public static final String SIZE = "size";
        public static final int SIZE_VALUE = 1;
    }

    public static class Url{
        /**
         * 科目一题库列表查询接口，接口返回值{@link com.jewel.model.ExamData}数组
         */
        public static final String QUESTION_ONE = "http://apicloud.mob.com/tiku/kemu1/query";
        /**
         * 科目四题库列表查询接口，接口返回值{@link com.jewel.model.ExamData}数组
         */
        public static final String QUESTION_FOUR = "http://apicloud.mob.com/tiku/kemu4/query";
        /**
         * 专项题库分类查询接口，接口返回值{@link com.jewel.model.ExamData}数组
         */
        public static final String QUESTION_CATEGORY = "http://apicloud.mob.com/tiku/shitiku/category/query";
        /**
         * 专项练习题库查询接口，接口返回值{@link com.jewel.model.ExamData}数组
         */
        public static final String QUESTION_CATEGORY_DETAIL = "http://apicloud.mob.com/tiku/shitiku/query";


        /**
         * 查询汽车品牌，汽车基本信息
         */
        public static final String CAR_BRANDS = "http://apicloud.mob.com/car/brand/query";
        /**
         * 根据车系名称查询车型
         */
        public static final String CAR_SERIES = "http://apicloud.mob.com/car/seriesname/query";
        /**
         * 查询车型详细信息
         */
        public static final String CAR_DETAIL = "http://apicloud.mob.com/car/series/query";

    }

}
