package com.jewel.http.business;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jewel.http.core.CallServer;
import com.jewel.http.core.IHttpCallback;
import com.jewel.http.core.SimpleCallback;
import com.jewel.http.core.parse.FastJsonRequest;
import com.jewel.model.BaseData;
import com.jewel.model.ExamCategories;
import com.jewel.model.ExamData;
import com.jewel.model.ListData;
import com.orhanobut.logger.Logger;
import com.yanzhenjie.nohttp.rest.Request;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jewel
 * @version 1.0
 * @since 2018/04/02
 */

public class ExamRequest implements IExamRequest {

    public ExamRequest() {

    }

    @Override
    public void getQuestion1(int page, final IHttpCallback<List<ExamData>> callback) {
        Request<BaseData<ListData>> request = new FastJsonRequest<>(HttpConfig.Url.QUESTION_ONE, ListData.class);
        request.add(HttpConfig.Params.PAGE, page);
        request.add(HttpConfig.Params.SIZE, HttpConfig.Params.SIZE_VALUE);
        CallServer.getInstance().request(WHAT_QUESTION_1, request, new SimpleCallback<ListData>() {

            @Override
            public void onSuccess(int what, ListData data) {
                super.onSuccess(what, data);
                transformData(what, data, callback);
            }

            @Override
            public void onStart(int what) {
                super.onStart(what);
                if(callback != null) {
                    callback.onStart(what);
                }
            }

            @Override
            public void onFinish(int what) {
                super.onFinish(what);
                if(callback != null) {
                    callback.onFinish(what);
                }
            }

            @Override
            public void onError(int what, Throwable e) {
                super.onError(what, e);
                if(callback != null) {
                    callback.onError(what, e);
                }
            }
        });
    }

    @Override
    public void getQuestion4(int page, final IHttpCallback<List<ExamData>> callback) {
        Request<BaseData<ListData>> request = new FastJsonRequest<>(HttpConfig.Url.QUESTION_FOUR, ListData.class);
        request.add(HttpConfig.Params.PAGE, page);
        request.add(HttpConfig.Params.SIZE, HttpConfig.Params.SIZE_VALUE);
        CallServer.getInstance().request(WHAT_QUESTION_4, request, new SimpleCallback<ListData>() {
            @Override
            public void onSuccess(int what, ListData data) {
                super.onSuccess(what, data);
                transformData(what, data, callback);
            }

            @Override
            public void onStart(int what) {
                super.onStart(what);
                if(callback != null) {
                    callback.onStart(what);
                }
            }

            @Override
            public void onFinish(int what) {
                super.onFinish(what);
                if(callback != null) {
                    callback.onFinish(what);
                }
            }

            @Override
            public void onError(int what, Throwable e) {
                super.onError(what, e);
                if(callback != null) {
                    callback.onError(what, e);
                }
            }
        });
    }

    @Override
    public void getCategory(final IHttpCallback<List<ExamCategories>> callback) {
        Request<BaseData<Object>> request = new FastJsonRequest<>(HttpConfig.Url.QUESTION_CATEGORY, Object.class);
        CallServer.getInstance().request(WHAT_CATEGORY, request, new SimpleCallback<Object>() {
            @Override
            public void onSuccess(int what, Object data) {
                super.onSuccess(what, data);
                try {
                    String json = JSON.toJSONString(data);
                    Logger.d(json);
                    callback.onSuccess(WHAT_CATEGORY, ExamCategories.parseJson(json));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onStart(int what) {
                super.onStart(what);
                if(callback != null) {
                    callback.onStart(what);
                }
            }

            @Override
            public void onFinish(int what) {
                super.onFinish(what);
                if(callback != null) {
                    callback.onFinish(what);
                }
            }

            @Override
            public void onError(int what, Throwable e) {
                super.onError(what, e);
                if(callback != null) {
                    callback.onError(what, e);
                }
            }
        });
    }

    @Override
    public void getCategoryDetail(String cid, int page, final IHttpCallback<List<ExamData>> callback) {
        Request<BaseData<ListData>> request = new FastJsonRequest<>(HttpConfig.Url.QUESTION_CATEGORY_DETAIL, ListData.class);
        request.add(HttpConfig.Params.CID, cid);
        request.add(HttpConfig.Params.PAGE, page);
        request.add(HttpConfig.Params.SIZE, HttpConfig.Params.SIZE_VALUE);
        CallServer.getInstance().request(WHAT_CATEGORY_DETAIL, request, new SimpleCallback<ListData>() {
            @Override
            public void onSuccess(int what, ListData data) {
                super.onSuccess(what, data);
                transformData(what, data, callback);
            }

            @Override
            public void onStart(int what) {
                super.onStart(what);
                if(callback != null) {
                    callback.onStart(what);
                }
            }

            @Override
            public void onFinish(int what) {
                super.onFinish(what);
                if(callback != null) {
                    callback.onFinish(what);
                }
            }

            @Override
            public void onError(int what, Throwable e) {
                super.onError(what, e);
                if(callback != null) {
                    callback.onError(what, e);
                }
            }
        });
    }

    private void transformData(int what, ListData data, IHttpCallback<List<ExamData>> callback) {
        if (data != null && data.getList() != null && !data.getList().isEmpty()) {
            List<ExamData> newData = new ArrayList<>();
            for (int i = 0; i < data.getList().size(); i++) {
                JSONObject jsonObject = (JSONObject) data.getList().get(i);
                ExamData examData = new ExamData();
                examData.setTitle(jsonObject.getString("title"));
                examData.setFile(jsonObject.getString("file"));
                examData.setExplainText(jsonObject.getString("explainText"));
                examData.setId(jsonObject.getString("id"));
                examData.setTikuType(jsonObject.getString("tikuType"));
                examData.setA(jsonObject.getString("a"));
                examData.setB(jsonObject.getString("b"));
                examData.setC(jsonObject.getString("c"));
                examData.setD(jsonObject.getString("d"));
                examData.setVal(jsonObject.getString("val"));
                examData.setTotal(data.getTotal());
                newData.add(examData);
                Logger.d(examData);
            }
            if (callback != null) {
                callback.onSuccess(what, newData);
            }
        }
    }
}
