package com.jewel.http.core.parse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jewel.model.BaseData;
import com.jewel.model.CarBrands;
import com.yanzhenjie.nohttp.Headers;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.StringRequest;

import java.lang.reflect.Type;
import java.util.List;

public class CarBrandsRequest extends Request<BaseData<List<CarBrands>>> {

    private Gson gson = new Gson();
    private Type type;

    public CarBrandsRequest(String url) {
        super(url, RequestMethod.GET);
        setAccept(Headers.HEAD_VALUE_CONTENT_TYPE_JSON);

        type = new TypeToken<BaseData<List<CarBrands>>>() {
        }.getType();
    }

    @Override
    public BaseData<List<CarBrands>> parseResponse(Headers responseHeaders, byte[] responseBody) {
        String result = StringRequest.parseResponseString(responseHeaders, responseBody);
        return gson.fromJson(result, type);
    }
}
