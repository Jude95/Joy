package com.jude.joy.module.image;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.ViewGroup;

import com.jude.beam.expansion.BeamBaseActivity;
import com.jude.joy.R;

import java.util.ArrayList;


/**
* Created by Mr.Jude on 2015/2/22.
 * 展示图片的Activity
*/
public class PictureActivity extends BeamBaseActivity {
    public static String KEY_PICTURES = "pictures";
    public static String KEY_PICTURE = "picture";
    public static String KEY_INDEX = "index";

    private ViewPager mViewPager;
    private PictureFragmentAdapter mAdapter;

    private ArrayList<String> mPictures;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.about);
        mViewPager.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        setContentView(mViewPager);

        mAdapter = new PictureFragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);

        mPictures = getIntent().getStringArrayListExtra(KEY_PICTURES);
        if (mPictures == null) mPictures = new ArrayList<>();
        String picture =  getIntent().getStringExtra(KEY_PICTURE);
        if (picture!=null) mPictures.add(picture);
        int index = getIntent().getIntExtra(KEY_INDEX,0);

        mAdapter.setPictures(mPictures);
        mViewPager.setCurrentItem(index);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    static class PictureFragmentAdapter extends FragmentStatePagerAdapter {
        ArrayList<String> mPictures;

        public PictureFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        public void setPictures(ArrayList<String> pictures){
            mPictures = pictures;
            notifyDataSetChanged();
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = new PictureFragment();
            Bundle bundle = new Bundle();
            bundle.putString("picture",mPictures.get(position));
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return mPictures==null?0:mPictures.size();
        }
    }



}
