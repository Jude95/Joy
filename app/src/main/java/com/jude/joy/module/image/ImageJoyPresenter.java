package com.jude.joy.module.image;

import android.os.Bundle;

import com.jude.beam.expansion.list.BeamListFragmentPresenter;
import com.jude.joy.model.JoyModel;
import com.jude.joy.model.bean.ImageJoy;
import com.jude.joy.model.bean.ImageJoyPage;
import com.jude.joy.model.callback.DataCallback;

/**
 * Created by Mr.Jude on 2015/8/20.
 */
public class ImageJoyPresenter extends BeamListFragmentPresenter<ImageJoyFragment,ImageJoy> {
    int page = 1;
    @Override
    protected void onCreate(ImageJoyFragment view, Bundle savedState) {
        super.onCreate(view, savedState);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        JoyModel.getInstance().getImageJoy(1, new DataCallback<ImageJoyPage>() {
            @Override
            public void success(String info, ImageJoyPage data) {
                getAdapter().clear();
                getAdapter().addAll(data.getContentlist());
                page = 2;
            }

            @Override
            public void error(String errorInfo) {
                getView().showError(new Throwable(errorInfo));
            }
        });
    }

    @Override
    public void onLoadMore() {
        JoyModel.getInstance().getImageJoy(page, new DataCallback<ImageJoyPage>() {
            @Override
            public void success(String info, ImageJoyPage data) {
                getAdapter().addAll(data.getContentlist());
                page++;
            }

            @Override
            public void error(String errorInfo) {
                getAdapter().pauseMore();
            }
        });
    }
}
