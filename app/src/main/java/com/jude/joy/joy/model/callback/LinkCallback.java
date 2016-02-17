package com.jude.joy.joy.model.callback;


import com.jude.http.RequestListener;

/**
 * Created by Mr.Jude on 2015/6/13.
 */
class LinkCallback implements RequestListener {
    private com.jude.joy.model.callback.LinkCallback link;
    public com.jude.joy.model.callback.LinkCallback add(com.jude.joy.model.callback.LinkCallback other){
        other.setLink(this);
        return other;
    }
    private void setLink(com.jude.joy.model.callback.LinkCallback link){
        this.link = link;
    }

    @Override
    public void onRequest() {
        if (link != null)
        link.onRequest();
    }

    @Override
    public void onSuccess(String s) {
        if (link != null)
        link.onSuccess(s);
    }

    @Override
    public void onError(String s) {
        if (link != null)
        link.onError(s);
    }
}
