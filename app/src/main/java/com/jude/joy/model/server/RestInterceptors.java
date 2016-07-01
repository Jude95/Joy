package com.jude.joy.model.server;

import com.jude.utils.JUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Iterator;
import java.util.ServiceConfigurationError;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Zane on 16/3/14.
 * 拦截,http缓存
 */
public class RestInterceptors implements Interceptor {

    private static final String TAG = "HeaderInterceptors";

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

        Response originalResponse = chain.proceed(request);
        MediaType contentType = originalResponse.body().contentType();

        //先解析一遍json数据，根据status和message去手动改状态码和描述
        String originalContent = originalResponse.body().string();
        JUtils.Log("RestInterceptors",request.url().toString()+":\n"+originalContent);

        int code = 400;
        String errorMessage = "";
        String body = "null";

        JSONObject wrapper = null;
        try {
            wrapper = new JSONObject(originalContent);
            Iterator<String> iterator = wrapper.keys();
            while (iterator.hasNext()){
                String key = iterator.next();
                switch (key){
                    case "showapi_res_code":
                        code = wrapper.getInt(key);
                        if (code == 0)code=200;
                        else code=400;
                        break;
                    case "showapi_res_error":
                        errorMessage = wrapper.getString(key);
                        break;
                    default:
                        body = wrapper.getString(key);
                        break;
                }
            }
        } catch (JSONException e) {
            throw new ServiceConfigurationError("服务器错误："+e.getLocalizedMessage());
        }


        return originalResponse.newBuilder()
                       .code(code)
                       .message(errorMessage)
                       .body(ResponseBody.create(contentType, body))
                       .build();

    }
}
