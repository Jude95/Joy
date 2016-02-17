package com.jude.joy.joy.config;

/**
 * Created by zhuchenxi on 15/8/2.
 */
public class API {
    public static final class URL{
        public static final String JOY_TEXT = "http://apis.baidu.com/showapi_open_bus/showapi_joke/joke_text";
        public static final String JOY_IMAGE = "http://apis.baidu.com/showapi_open_bus/showapi_joke/joke_pic";
    }

    public static class KEY {
        public static final String STATUS = "showapi_res_code";
        public static final String INFO = "showapi_res_error";
        public static final String DATA = "showapi_res_body";
    }

    public static class CODE {
        public static final int SUCCEED = 0;
    }
}
