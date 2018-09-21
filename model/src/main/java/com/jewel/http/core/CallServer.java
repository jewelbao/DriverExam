package com.jewel.http.core;

import com.jewel.model.BaseData;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;
import com.yanzhenjie.nohttp.rest.Response;

/**
 * 请求队列单例
 *
 * @author Jewel
 * @version 1.0
 * @since 2018/04/02
 */

public class CallServer {

    private RequestQueue queue;

    public <SOURCE, RESULT> void request(int what, final Request<SOURCE> request, final IHttpCallback<RESULT> callback) {
        queue.add(what, request, new OnResponseListener<SOURCE>() {

            @Override
            public void onStart(int what) {
                callback.onStart(what);
            }

            @Override
            public void onSucceed(int what, Response<SOURCE> response) {
                BaseData<RESULT> result = (BaseData<RESULT>) response.get();
                if (result.isSuccess()) {
                    callback.onSuccess(what, result.getResult());
                } else {
                    callback.onFail(what, result.getMsg());
                }
            }

            @Override
            public void onFailed(int what, Response<SOURCE> response) {
                callback.onError(what, response.getException());
            }

            @Override
            public void onFinish(int what) {
                callback.onFinish(what);
            }
        });
    }

    public void stop() {
        queue.stop();
    }

    private static CallServer instance;

    public static CallServer getInstance() {
        if (instance == null) {
            synchronized (CallServer.class) {
                if (instance == null) {
                    instance = new CallServer();
                }
            }
        }
        return instance;
    }

    private CallServer() {
        queue = NoHttp.newRequestQueue(3);
    }
}
