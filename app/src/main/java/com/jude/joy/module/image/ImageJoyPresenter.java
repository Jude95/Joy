package com.jude.joy.module.image;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jude.beam.expansion.list.BeamListFragmentPresenter;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.joy.model.bean.ImageJoy;
import com.jude.joy.model.bean.ImageJoyPage;
import com.jude.joy.model.server.DaggerServiceModelComponent;
import com.jude.joy.model.server.SchedulerTransform;
import com.jude.joy.model.server.ServiceAPI;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by Mr.Jude on 2015/8/20.
 */
public class ImageJoyPresenter extends BeamListFragmentPresenter<ImageJoyFragment,ImageJoy> {
    @Inject
    ServiceAPI mServer;
    @Override
    protected void onCreate(ImageJoyFragment view, Bundle savedState) {
        super.onCreate(view, savedState);
        DaggerServiceModelComponent.builder().build().inject(this);
        onRefresh();
    }

    @Override
    protected void onCreateView(@NonNull ImageJoyFragment view) {
        super.onCreateView(view);
        getAdapter().setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                ArrayList<String> list = new ArrayList<String>();
                for (ImageJoy imageJoy : getAdapter().getAllData()) {
                    list.add(imageJoy.getImg());
                }
                Intent i = new Intent(getView().getContext(),PictureActivity.class);
                i.putExtra(PictureActivity.KEY_PICTURES,list);
                i.putExtra(PictureActivity.KEY_INDEX,position);
                getView().startActivity(i);
            }
        });
    }

    @Override
    public void onRefresh() {
        mServer.getImageJoyList(1)
                .compose(new SchedulerTransform<>())
                .map(ImageJoyPage::getContentlist)
                .doAfterTerminate(()-> setCurPage(2))
                .doOnNext(list->{
                    for (ImageJoy imageJoy : list) {
                        String url = imageJoy.getImg();
                        Glide.with(getView()).load(url)
                                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                .preload();
                    }
                })
                .unsafeSubscribe(getRefreshSubscriber());
    }

    @Override
    public void onLoadMore() {
        mServer.getImageJoyList(getCurPage())
                .compose(new SchedulerTransform<>())
                .map(ImageJoyPage::getContentlist)
                .doOnNext(list->{
                    for (ImageJoy imageJoy : list) {
                        String url = imageJoy.getImg();
                        Glide.with(getView()).load(url)
                                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                .preload();
                    }
                })
                .unsafeSubscribe(getMoreSubscriber());
    }
}
