package com.jewel.http.business;

import com.jewel.http.core.CallServer;
import com.jewel.http.core.IHttpCallback;
import com.jewel.http.core.parse.CarBrandsRequest;
import com.jewel.http.core.parse.CarDetailRequest;
import com.jewel.http.core.parse.CarSeriesRequest;
import com.jewel.model.BaseData;
import com.jewel.model.CarBrands;
import com.jewel.model.CarDetail;
import com.jewel.model.CarSeries;
import com.yanzhenjie.nohttp.rest.Request;

import java.util.List;

public class CarRequest implements ICarRequest {


    @Override
    public void getCarBrands(final IHttpCallback<List<CarBrands>> callback) {
        Request<BaseData<List<CarBrands>>> request = new CarBrandsRequest(HttpConfig.Url.CAR_BRANDS);
        CallServer.getInstance().request(WHAT_CAR_BRANDS, request, callback);
    }

    @Override
    public void getCarSeries(String name, IHttpCallback<List<CarSeries>> callback) {
        Request<BaseData<List<CarSeries>>> request = new CarSeriesRequest(HttpConfig.Url.CAR_SERIES);
        CallServer.getInstance().request(WHAT_CAR_SERIES, request, callback);
    }

    @Override
    public void getCarDetail(String cid, final IHttpCallback<CarDetail> callback) {
        Request<BaseData<List<CarDetail>>> request = new CarDetailRequest(HttpConfig.Url.CAR_DETAIL);
        CallServer.getInstance().request(WHAT_CAR_DETAIL, request, new IHttpCallback<List<CarDetail>>() {
            @Override
            public void onStart(int what) {
                callback.onStart(what);
            }

            @Override
            public void onSuccess(int what, List<CarDetail> data) {
                if (data != null && !data.isEmpty()) {
                    callback.onSuccess(what, data.get(0));
                } else {
                    callback.onFail(what, "暂无数据");
                }
            }

            @Override
            public void onFail(int what, String msg) {
                callback.onFail(what, msg);
            }

            @Override
            public void onError(int what, Throwable e) {
                callback.onError(what, e);
            }

            @Override
            public void onFinish(int what) {
                callback.onFinish(what);
            }
        });

    }
}
