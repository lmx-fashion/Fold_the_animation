package com.bwie.liumengxin.model;

import android.util.Log;

import com.bwie.liumengxin.api.Api;
import com.bwie.liumengxin.api.ApiService;
import com.bwie.liumengxin.bean.MyGson;

import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * autor:刘梦欣
 * date：2017/11/20
 * 用途：
 */
public class MyModel implements Imodel {
    //接口回调传输数据
    public Onfinish onfinish1;

    public interface Onfinish {
        void onFinish(MyGson list);
    }

    public void setOnFinish(Onfinish onfinish) {
        this.onfinish1 = onfinish;
    }

    @Override
    public void getData(String url, Map<String, String> map) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.HOST).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        //添加动态代理
        ApiService apiService = retrofit.create(ApiService.class);
        //获取数据源
        Observable<MyGson> data = apiService.getDatasss(url, map);
        data.subscribeOn(Schedulers.io())////IO线程做耗时操作
                .observeOn(AndroidSchedulers.mainThread())//在主线程更新UI
                .subscribe(new Observer<MyGson>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("main--", "error");
                    }

                    @Override
                    public void onNext(MyGson myGson) {
                        Log.d("main--", myGson.getRet().getList().get(0).getDescription());
                        onfinish1.onFinish(myGson);
                    }
                });

    }

}
