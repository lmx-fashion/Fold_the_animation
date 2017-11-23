package com.bwie.liumengxin.presenter;

import com.bwie.liumengxin.bean.MyGson;
import com.bwie.liumengxin.model.MyModel;
import com.bwie.liumengxin.view.Iview;

import java.util.Map;

/**
 * date：2017/11/20
 * 用途：
 */
public class MyPresenter implements MyModel.Onfinish {
    private final Iview iview;
    private final MyModel myModel;

    public MyPresenter(Iview iview) {
        this.iview = iview;
        this.myModel = new MyModel();
        myModel.setOnFinish(this);
    }

    public void setData(String url, Map<String, String> map) {
        myModel.getData(url, map);
    }

    @Override
    public void onFinish(MyGson list) {
        iview.getDatas(list);
    }
}
