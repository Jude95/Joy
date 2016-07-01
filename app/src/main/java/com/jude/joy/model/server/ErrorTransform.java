package com.jude.joy.model.server;

import com.jude.utils.JUtils;

import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.functions.Action1;

/**
 * Created by Mr.Jude on 2015/8/25.
 * 对服务器请求的Observer的修改
 */
public class ErrorTransform<T> implements Observable.Transformer<T, T> {

    private Action1<Throwable> handler;
    public ErrorTransform(Action1<Throwable> handler) {
        this.handler = handler;
    }

    @Override
    public Observable<T> call(Observable<T> tObservable) {
        return tObservable.doOnError(handler)
                .onErrorResumeNext(Observable.empty());
    }


    public static class ServerErrorHandler implements Action1<Throwable> {
        private static final int W_TOAST = 1;

        public static final ServerErrorHandler NONE = new ServerErrorHandler(0);
        public static final ServerErrorHandler TOAST = new ServerErrorHandler(1<< W_TOAST);


        private int kind;

        public ServerErrorHandler(int kind) {
            this.kind = kind;
        }

        private boolean has(int index){
            return (kind & 1<<index) >0;
        }

        @Override
        public void call(Throwable throwable) {
            JUtils.Log("Error:"+throwable.getClass().getName()+":"+throwable.getMessage());
            String errorString;
            if (throwable instanceof HttpException) {
                HttpException err = (HttpException) throwable;
                if (err.code() >= 400 && err.code() < 500){
                   errorString = "请求错误:"+err.message();
                }else if (err.code() >= 500){
                    errorString = "服务器错误";
                }else {
                    errorString = "请求错误:"+err.code();
                }
            }else {
                errorString = "网络错误";
                JUtils.Log(throwable.getMessage());
            }
            if (has(W_TOAST)) JUtils.Toast(errorString);
        }


    }

}
