package com.jude.joy.joy.model.bean;

/**
 * Created by Mr.Jude on 2015/8/20.
 */
public class ImageJoy {


    /**
     * ct : 2015-08-13 13:10:36.891
     * img : http://img.hao123.com/data/3_1b72caa7998cf674fecb4f334cf9d356_430
     * title : 牙膏还有这技能。
     * type : 2
     */
    private String ct;
    private String img;
    private String title;
    private int type;

    public void setCt(String ct) {
        this.ct = ct;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCt() {
        return ct;
    }

    public String getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public int getType() {
        return type;
    }
}
