package com.jude.joy.module.image;

import android.os.Bundle;

import com.jude.beam.expansion.list.BeamListFragmentPresenter;
import com.jude.joy.model.bean.ImageJoy;
import com.jude.joy.model.bean.ImageJoyPage;
import com.jude.joy.model.server.DaggerServiceModelComponent;
import com.jude.joy.model.server.SchedulerTransform;
import com.jude.joy.model.server.ServiceAPI;

import javax.inject.Inject;

/**
 * Created by Mr.Jude on 2015/8/20.
 */
public class ImageJoyPresenter extends BeamListFragmentPresenter<ImageJoyFragment,ImageJoy> {
    int page = 1;
    @Inject
    ServiceAPI mServer;

    @Override
    protected void onCreate(ImageJoyFragment view, Bundle savedState) {
        super.onCreate(view, savedState);
        DaggerServiceModelComponent.builder().build().inject(this);
        onRefresh();
    }


    @Override
    public void onRefresh() {
        mServer.getImageJoyList(1)
                .compose(new SchedulerTransform<>())
                .map(ImageJoyPage::getContentlist)
                .doAfterTerminate(()-> setCurPage(2))
                .unsafeSubscribe(getRefreshSubscriber());
    }

    @Override
    public void onLoadMore() {
        mServer.getImageJoyList(getCurPage())
                .compose(new SchedulerTransform<>())
                .map(ImageJoyPage::getContentlist)
                .unsafeSubscribe(getMoreSubscriber());
    }
}
