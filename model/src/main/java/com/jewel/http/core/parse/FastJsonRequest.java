package com.jewel.http.core.parse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jewel.model.BaseData;
import com.jewel.model.ListData;
import com.yanzhenjie.nohttp.Headers;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.StringRequest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jewel
 * @version 1.0
 * @since 2018/04/02
 */

public class FastJsonRequest<T> extends Request<BaseData<T>> {

    private Type type;

    public FastJsonRequest(String url, Class<T> clz) {
        super(url, RequestMethod.GET);
        setAccept(Headers.HEAD_VALUE_CONTENT_TYPE_JSON);
        type = new TypeReference<BaseData<T>>(clz) {}.getType();
    }

    @Override
    public BaseData<T> parseResponse(Headers responseHeaders, byte[] responseBody) {
        String result = StringRequest.parseResponseString(responseHeaders, responseBody);
        return JSON.parseObject(result, type);
    }
}
