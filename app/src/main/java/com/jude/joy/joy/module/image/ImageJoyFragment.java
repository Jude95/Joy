package com.jude.joy.joy.module.image;

import android.view.ViewGroup;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.list.BeamListFragment;
import com.jude.beam.expansion.list.ListConfig;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.joy.model.bean.ImageJoy;
import com.jude.joy.module.image.ImageJoyPresenter;
import com.jude.joy.module.image.ImageJoyVH;

/**
 * Created by Mr.Jude on 2015/8/20.
 */
@RequiresPresenter(com.jude.joy.module.image.ImageJoyPresenter.class)
public class ImageJoyFragment extends BeamListFragment<ImageJoyPresenter,ImageJoy> {
    @Override
    protected BaseViewHolder getViewHolder(ViewGroup viewGroup, int i) {
        return new ImageJoyVH(viewGroup);
    }
    @Override
    protected ListConfig getConfig() {
        return super.getConfig()
                .setLoadmoreAble(true)
                .setRefreshAble(true)
                .setNoMoreAble(true)
                .setErrorAble(true)
                .setErrorTouchToResumeAble(true);

    }
}
