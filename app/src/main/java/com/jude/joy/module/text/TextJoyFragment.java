package com.jude.joy.module.text;

import android.view.ViewGroup;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.list.BeamListFragment;
import com.jude.beam.expansion.list.ListConfig;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.joy.model.bean.TextJoy;

/**
 * Created by Mr.Jude on 2015/8/20.
 */
@RequiresPresenter(TextJoyPresenter.class)
public class TextJoyFragment extends BeamListFragment<TextJoyPresenter,TextJoy> {
    @Override
    protected BaseViewHolder getViewHolder(ViewGroup viewGroup, int i) {
        return new TextJoyVH(viewGroup);
    }

    @Override
    protected ListConfig getConfig() {
        return super.getConfig()
                .setLoadmoreAble(true)
                .setRefreshAble(true)
                .setNoMoreAble(true);
    }
}
