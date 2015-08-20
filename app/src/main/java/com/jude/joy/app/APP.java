package com.jude.joy.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.jude.beam.Beam;
import com.jude.http.RequestManager;
import com.jude.joy.BuildConfig;
import com.jude.utils.JUtils;

/**
 * Created by Mr.Jude on 2015/8/20.
 */
public class APP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        JUtils.initialize(this);
        JUtils.setDebug(BuildConfig.DEBUG, "JoyLog");
        Fresco.initialize(this);
        RequestManager.getInstance().init(this);
        RequestManager.getInstance().setDebugMode(BuildConfig.DEBUG, "JoyNet");
        Beam.init(this);
    }
}
