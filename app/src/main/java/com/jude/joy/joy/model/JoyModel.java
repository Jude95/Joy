package com.jude.joy.joy.model;

import android.content.Context;

import com.jude.beam.model.AbsModel;
import com.jude.http.RequestManager;
import com.jude.http.RequestMap;
import com.jude.joy.config.API;
import com.jude.joy.model.bean.ImageJoyPage;
import com.jude.joy.model.bean.TextJoyPage;
import com.jude.joy.model.callback.DataCallback;

import java.util.HashMap;

/**
 * Created by Mr.Jude on 2015/8/20.
 */
public class JoyModel extends AbsModel {

    public static com.jude.joy.model.JoyModel getInstance() {
        return getInstance(com.jude.joy.model.JoyModel.class);
    }

    @Override
    protected void onAppCreate(Context ctx) {
        super.onAppCreate(ctx);
        HashMap<String ,String > header = new HashMap<>();
        header.put("apikey"," c676a989ffe83f89db5265482ef3222d");
        RequestManager.getInstance().setHeader(header);
    }

    public void getTextJoy(int page , DataCallback<TextJoyPage> callback){
        RequestManager.getInstance().post(API.URL.JOY_TEXT, new RequestMap("page", page + ""), callback);
    }
    public void getImageJoy(int page , DataCallback<ImageJoyPage> callback){
        RequestManager.getInstance().post(API.URL.JOY_IMAGE,new RequestMap("page",page+""),callback);
    }
}
