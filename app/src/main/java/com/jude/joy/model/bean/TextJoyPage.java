package com.jude.joy.model.bean;

/**
 * Created by Mr.Jude on 2015/8/20.
 */
public class TextJoyPage {
    private int allNum;
    private int allPage;
    private TextJoy[] contentlist;

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

    public TextJoy[] getContentlist() {
        return contentlist;
    }

    public void setContentlist(TextJoy[] contentlist) {
        this.contentlist = contentlist;
    }
}
