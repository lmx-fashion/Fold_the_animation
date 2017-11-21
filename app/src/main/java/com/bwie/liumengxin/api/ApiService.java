package com.bwie.liumengxin.api;


import com.bwie.liumengxin.bean.MyGson;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by dell on 2017/11/20.
 */

public interface ApiService {
    @GET
    Observable<MyGson> getDatasss(@Url  String url,@QueryMap Map<String, String> map);
}
