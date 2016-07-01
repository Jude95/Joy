package com.jude.joy.module.image;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.bumptech.glide.Glide;
import com.jude.joy.R;
import com.jude.joy.utils.ImageFilter;
import com.jude.utils.JUtils;
import com.pnikosis.materialishprogress.ProgressWheel;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoView;

/**
 * Created by zhuchenxi on 16/6/2.
 */

public class PictureFragment extends Fragment {
    String mPicture;
    @BindView(R.id.wheel)
    ProgressWheel wheel;
    @BindView(R.id.photoview)
    PhotoView photoview;
    @BindView(R.id.container)
    FrameLayout container;

    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPicture = getArguments().getString("picture");
        JUtils.Log("PictureFragment onCreate " + mPicture);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_picture, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Glide.with(getContext())
                .load(ImageFilter.filter(mPicture))
                .into(photoview);
    }

}
