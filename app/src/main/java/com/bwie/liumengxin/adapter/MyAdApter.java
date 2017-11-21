package com.bwie.liumengxin.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.liumengxin.R;
import com.bwie.liumengxin.bean.MyGson;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * autor:刘梦欣
 * date：2017/11/20
 * 用途：
 */
public class MyAdApter extends RecyclerView.Adapter {
    private MyGson myGson;
    private Context context;

    public MyAdApter(Context context, MyGson myGson) {
        this.context = context;
        this.myGson = myGson;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(View.inflate(context, R.layout.itemss, null));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder m = (MyViewHolder) holder;
        m.img.setImageURI(myGson.getRet().getList().get(position).getPic());
        m.title.setText(myGson.getRet().getList().get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return myGson.getRet().getList().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView img;
        TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.titlee);
        }
    }
}
