package com.jude.joy.model.server;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptors implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        builder.addHeader("apikey", "c676a989ffe83f89db5265482ef3222d");
        return chain.proceed(builder.build());
    }
}