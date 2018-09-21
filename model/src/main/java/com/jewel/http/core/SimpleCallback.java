package com.jewel.http.core;

public class SimpleCallback<T> implements IHttpCallback<T> {


    @Override
    public void onStart(int what) {

    }

    @Override
    public void onSuccess(int what, T data) {

    }

    @Override
    public void onFail(int what, String msg) {

    }

    @Override
    public void onError(int what, Throwable e) {

    }

    @Override
    public void onFinish(int what) {

    }
}
