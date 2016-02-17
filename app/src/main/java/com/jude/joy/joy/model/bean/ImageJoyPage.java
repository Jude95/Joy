package com.jude.joy.joy.model.bean;

import com.jude.joy.model.bean.ImageJoy;

/**
 * Created by Mr.Jude on 2015/8/20.
 */
public class ImageJoyPage {
    private int allNum;
    private int allPage;

    public int getAllNum() {
        return allNum;
    }

    public void setAllNum(int allNum) {
        this.allNum = allNum;
    }

    public int getAllPage() {
        return allPage;
    }

    public void setAllPage(int allPage) {
        this.allPage = allPage;
    }

    public ImageJoy[] getContentlist() {
        return contentlist;
    }

    public void setContentlist(ImageJoy[] contentlist) {
        this.contentlist = contentlist;
    }

    private ImageJoy[] contentlist;
}
