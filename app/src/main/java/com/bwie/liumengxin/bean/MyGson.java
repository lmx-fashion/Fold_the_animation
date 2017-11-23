package com.bwie.liumengxin.bean;

/**
 * date：2017/11/20
 * 用途：
 */
public class MyGson {
    private Ret ret;

    @Override
    public String toString() {
        return "MyGson{" +
                "ret=" + ret +
                '}';
    }

    public Ret getRet() {
        return ret;
    }

    public void setRet(Ret ret) {
        this.ret = ret;
    }

    public MyGson(Ret ret) {
        this.ret = ret;
    }
}
