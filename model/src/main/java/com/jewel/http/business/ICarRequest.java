package com.jewel.http.business;

import com.jewel.http.core.IHttpCallback;
import com.jewel.model.CarBrands;
import com.jewel.model.CarDetail;
import com.jewel.model.CarSeries;

import java.util.List;

public interface ICarRequest {
    int WHAT_CAR_BRANDS = 1;
    int WHAT_CAR_SERIES = 2;
    int WHAT_CAR_DETAIL = 3;

    void getCarBrands(IHttpCallback<List<CarBrands>> callback);

    void getCarSeries(String name, IHttpCallback<List<CarSeries>> callback);

    void getCarDetail(String cid, IHttpCallback<CarDetail> callback);

}
