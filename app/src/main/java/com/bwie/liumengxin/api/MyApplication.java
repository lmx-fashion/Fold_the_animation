package com.bwie.liumengxin.api;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * autor:刘梦欣
 * date：2017/11/20
 * 用途：
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}