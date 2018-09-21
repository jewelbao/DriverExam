package com.jewel.model;

import com.alibaba.fastjson.JSON;

import org.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void jsonTest() {
        String json = "{\n" +
                "        \"客车科目四考试题库2016\": [\n" +
                "            {\n" +
                "                \"cid\": \"193\",\n" +
                "                \"title\": \"违法行为综合判断与案例分析\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"196\",\n" +
                "                \"title\": \"安全行车常识\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"198\",\n" +
                "                \"title\": \"常见交通标志、标线和交警手势信号辨识\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"200\",\n" +
                "                \"title\": \"驾驶职业道德和文明驾驶常识\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"202\",\n" +
                "                \"title\": \"恶劣气候和复杂道路条件下驾驶常识\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"204\",\n" +
                "                \"title\": \"紧急情况下避险常识\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"206\",\n" +
                "                \"title\": \"交通事故救护及常见危化品处置常识\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"208\",\n" +
                "                \"title\": \"2015年科目四新增加试题\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"小车科目四考试题库2016\": [\n" +
                "            {\n" +
                "                \"cid\": \"193\",\n" +
                "                \"title\": \"违法行为综合判断与案例分析\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"195\",\n" +
                "                \"title\": \"安全行车常识\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"197\",\n" +
                "                \"title\": \"常见交通标志、标线和交警手势信号辨识\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"199\",\n" +
                "                \"title\": \"驾驶职业道德和文明驾驶常识\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"201\",\n" +
                "                \"title\": \"恶劣气候和复杂道路条件下驾驶常识\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"203\",\n" +
                "                \"title\": \"紧急情况下避险常识\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"205\",\n" +
                "                \"title\": \"交通事故救护及常见危化品处置常识\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"208\",\n" +
                "                \"title\": \"2015年科目四新增加试题\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"货车科目一考试题库2016\": [\n" +
                "            {\n" +
                "                \"cid\": \"183\",\n" +
                "                \"title\": \"道路交通安全法律、法规和规章\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"184\",\n" +
                "                \"title\": \"道路交通信号\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"185\",\n" +
                "                \"title\": \"安全行车、文明驾驶基础知识\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"186\",\n" +
                "                \"title\": \"机动车驾驶操作相关基础知识\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"191\",\n" +
                "                \"title\": \"货车专用试题\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"207\",\n" +
                "                \"title\": \"2015年科目一新增试题\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"小车科目一考试题库2016\": [\n" +
                "            {\n" +
                "                \"cid\": \"183\",\n" +
                "                \"title\": \"道路交通安全法律、法规和规章\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"184\",\n" +
                "                \"title\": \"道路交通信号\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"185\",\n" +
                "                \"title\": \"安全行车、文明驾驶基础知识\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"186\",\n" +
                "                \"title\": \"机动车驾驶操作相关基础知识\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"207\",\n" +
                "                \"title\": \"2015年科目一新增试题\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"货车科目四考试题库2016\": [\n" +
                "            {\n" +
                "                \"cid\": \"193\",\n" +
                "                \"title\": \"违法行为综合判断与案例分析\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"196\",\n" +
                "                \"title\": \"安全行车常识\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"198\",\n" +
                "                \"title\": \"常见交通标志、标线和交警手势信号辨识\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"200\",\n" +
                "                \"title\": \"驾驶职业道德和文明驾驶常识\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"202\",\n" +
                "                \"title\": \"恶劣气候和复杂道路条件下驾驶常识\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"204\",\n" +
                "                \"title\": \"紧急情况下避险常识\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"206\",\n" +
                "                \"title\": \"交通事故救护及常见危化品处置常识\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"208\",\n" +
                "                \"title\": \"2015年科目四新增加试题\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"客车科目一考试题库2016\": [\n" +
                "            {\n" +
                "                \"cid\": \"183\",\n" +
                "                \"title\": \"道路交通安全法律、法规和规章\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"184\",\n" +
                "                \"title\": \"道路交通信号\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"185\",\n" +
                "                \"title\": \"安全行车、文明驾驶基础知识\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"186\",\n" +
                "                \"title\": \"机动车驾驶操作相关基础知识\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"190\",\n" +
                "                \"title\": \"客车专用试题\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cid\": \"207\",\n" +
                "                \"title\": \"2015年科目一新增试题\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }";

        try {
            List<ExamCategories> categories =  praseJson(json);
            for (int i = 0; i < categories.size(); i++) {
                System.out.println(categories.get(i).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    List<ExamCategories> praseJson(String str) throws Exception {
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
}