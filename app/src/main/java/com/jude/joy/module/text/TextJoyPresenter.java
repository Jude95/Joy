package com.jude.joy.module.text;

import android.os.Bundle;

import com.jude.beam.expansion.list.BeamListFragmentPresenter;
import com.jude.joy.model.bean.TextJoy;
import com.jude.joy.model.bean.TextJoyPage;
import com.jude.joy.model.server.DaggerServiceModelComponent;
import com.jude.joy.model.server.SchedulerTransform;
import com.jude.joy.model.server.ServiceAPI;

import javax.inject.Inject;

/**
 * Created by Mr.Jude on 2015/8/20.
 */
public class TextJoyPresenter extends BeamListFragmentPresenter<TextJoyFragment,TextJoy> {
    @Inject
    ServiceAPI mServer;

    @Override
    protected void onCreate(TextJoyFragment view, Bundle savedState) {
        super.onCreate(view, savedState);
        DaggerServiceModelComponent.builder().build().inject(this);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        mServer.getTextJoyList(1)
                .compose(new SchedulerTransform<>())
                .map(TextJoyPage::getContentlist)
                .doAfterTerminate(()-> setCurPage(2))
                .unsafeSubscribe(getRefreshSubscriber());
    }

    @Override
    public void onLoadMore() {
        mServer.getTextJoyList(getCurPage())
                .compose(new SchedulerTransform<>())
                .map(TextJoyPage::getContentlist)
                .unsafeSubscribe(getMoreSubscriber());
    }
}
