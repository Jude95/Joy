package com.jude.joy.model.server;

import com.jude.joy.module.image.ImageJoyPresenter;
import com.jude.joy.module.text.TextJoyPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhuchenxi on 16/1/25.
 */
@Singleton
@Component(modules = {ServiceAPIModule.class})
public interface ServiceModelComponent {
    void inject(TextJoyPresenter model);

    void inject(ImageJoyPresenter model);
}