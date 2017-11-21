package com.bwie.liumengxin.bean;

import java.util.ArrayList;

/**
 * autor:刘梦欣
 * date：2017/11/20
 * 用途：
 */
public class Ret {

    ArrayList<Mybean> list;

    public ArrayList<Mybean> getList() {
        return list;
    }

    public void setList(ArrayList<Mybean> list) {
        this.list = list;
    }

    public Ret(ArrayList<Mybean> list) {
        this.list = list;
    }
}
