package com.jewel.http.core.parse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jewel.model.BaseData;
import com.yanzhenjie.nohttp.Headers;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.StringRequest;

import java.lang.reflect.Type;

public class GsonObjRequest<T> extends Request<BaseData<T>> {
    private Gson gson = new Gson();
    private Type type;

    public GsonObjRequest(String url) {
        super(url, RequestMethod.GET);
        setAccept(Headers.HEAD_VALUE_CONTENT_TYPE_JSON);

        type = new TypeToken<BaseData<T>>() {
        }.getType();
    }

    @Override
    public BaseData<T> parseResponse(Headers responseHeaders, byte[] responseBody) {
        String result = StringRequest.parseResponseString(responseHeaders, responseBody);
        return gson.fromJson(result, type);
    }
}
