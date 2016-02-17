package com.jude.joy.joy.model.bean;

/**
 * Created by Mr.Jude on 2015/8/20.
 */
public class TextJoy {

    /**
     * ct : 2015-08-13 13:10:26.149
     * text : 新人发帖求过…… 媳妇最近怀孕了…天天这也不想吃那也不想吃…有一天发脾气要我给他做想吃的，结果做了好多还是没有想吃的…最后着急了大喊:再做不出我想吃的我就去大街上要饭……我想说:你吃什么自己都不知道我怎么做啊…唉…想想男人女人都不容易啊…
     * title : 媳妇儿有了…
     * type : 1
     */
    private String ct;
    private String text;
    private String title;
    private int type;

    public void setCt(String ct) {
        this.ct = ct;
    }

    public void setText(String text) {
        this.text = text;
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

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public int getType() {
        return type;
    }
}
