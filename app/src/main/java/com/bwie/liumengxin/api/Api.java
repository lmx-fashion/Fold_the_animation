package com.bwie.liumengxin.api;

import java.util.Random;

/**
 * autor:刘梦欣
 * date：2017/11/20
 * 用途：
 */
public class Api {
    final String catalogId = "402834815584e463015584e539330016";

    public static final String HOST = "http://api.svipmovie.com/front/";
    //影片分类
    // columns/getVideoList.do
    // 参数：catalogId 分类id  已经给出
    // pnum 传入  为能随机获取视频请传入getNextPage（），此方法已经给出

//    private int getNextPage() {
//        if (SystemUtils.isNetworkConnected()) {
//            page = StringUtils.getRandomNumber(1, 108);
//        }
//        return page;
//    }

    public static int getRandomNumber(int min, int max) {
        return new Random().nextInt(max) % (max - min + 1) + min;
    }

}
