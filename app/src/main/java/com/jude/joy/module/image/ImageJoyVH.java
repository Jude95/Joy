package com.jude.joy.module.image;

import android.net.Uri;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.joy.R;
import com.jude.joy.model.bean.ImageJoy;
import com.jude.joy.utils.RecentDateFormat;
import com.jude.utils.JTimeTransform;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mr.Jude on 2015/8/20.
 */
public class ImageJoyVH extends BaseViewHolder<ImageJoy> {

    @InjectView(R.id.title)
    TextView title;
    @InjectView(R.id.image)
    SimpleDraweeView image;
    @InjectView(R.id.time)
    TextView time;

    public ImageJoyVH(ViewGroup parent) {
        super(parent, R.layout.item_joy_image);
        ButterKnife.inject(this,itemView);
    }

    @Override
    public void setData(ImageJoy data) {
        title.setText(data.getTitle());
        image.setImageURI(Uri.parse(data.getImg()));
        time.setText(new JTimeTransform().parse("yyyy-MM-dd hh:mm:ss",data.getCt()).toString(new RecentDateFormat()));
    }
}
