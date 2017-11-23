package com.bwie.liumengxin.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.bwie.liumengxin.R;
import com.bwie.liumengxin.adapter.MyAdapters;
import com.bwie.liumengxin.bean.MyGson;
import com.bwie.liumengxin.bean.Mybean;
import com.bwie.liumengxin.cardswipelayout.CardConfig;
import com.bwie.liumengxin.cardswipelayout.CardItemTouchHelperCallback;
import com.bwie.liumengxin.cardswipelayout.CardLayoutManager;
import com.bwie.liumengxin.cardswipelayout.OnSwipeListener;
import com.bwie.liumengxin.presenter.MyPresenter;
import com.bwie.liumengxin.view.Iview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * date：2017/11/20
 * 用途：
 */
public class FaxianFragment extends Fragment implements Iview {
    Unbinder unbinder;
    @BindView(R.id.huanyipi)
    Button huanyipi;
    private MyGson myGsons;
    MyPresenter myPresenter;
    Map<String, String> map;
    int page = 1;

    public FaxianFragment(MyGson myGson) {
        this.myGsons = myGson;
    }

    MyAdapters mAdapter;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.faxian, null);
        unbinder = ButterKnife.bind(this, view);
        recyclerView = view.findViewById(R.id.recyclers);
        map = new HashMap<>();
        myPresenter = new MyPresenter(this);
        initData();
        return view;
    }

    //配置出现的影视
    public void initData() {
        ArrayList<Mybean> list = myGsons.getRet().getList();
        mAdapter = new MyAdapters(getActivity(), list);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        CardItemTouchHelperCallback cardCallback = new CardItemTouchHelperCallback(recyclerView.getAdapter(), list);
        cardCallback.setOnSwipedListener(new OnSwipeListener<Mybean>() {
            @Override
            public void onSwiping(RecyclerView.ViewHolder viewHolder, float ratio, int direction) {
                MyAdapters.MyHolder myHolder = (MyAdapters.MyHolder) viewHolder;
                viewHolder.itemView.setAlpha(1 - Math.abs(ratio) * 0.2f);
                if (direction == CardConfig.SWIPING_LEFT) {
                    myHolder.dislikeImageView.setAlpha(Math.abs(ratio));
                } else if (direction == CardConfig.SWIPING_RIGHT) {
                    myHolder.likeImageView.setAlpha(Math.abs(ratio));
                } else {
                    myHolder.dislikeImageView.setAlpha(0f);
                    myHolder.likeImageView.setAlpha(0f);
                }
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, Mybean mybean, int direction) {
                MyAdapters.MyHolder myHolder = (MyAdapters.MyHolder) viewHolder;
                viewHolder.itemView.setAlpha(1f);
                myHolder.dislikeImageView.setAlpha(0f);
                myHolder.likeImageView.setAlpha(0f);
                //Toast.makeText(getActivity(), direction == CardConfig.SWIPED_LEFT ? "swiped left" : "swiped right", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSwipedClear() {
                Toast.makeText(getActivity(), "data clear", Toast.LENGTH_SHORT).show();
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        initData();
                        recyclerView.getAdapter().notifyDataSetChanged();
                    }
                }, 3000L);
            }

        });
        final ItemTouchHelper touchHelper = new ItemTouchHelper(cardCallback);
        final CardLayoutManager cardLayoutManager = new CardLayoutManager(recyclerView, touchHelper);
        recyclerView.setLayoutManager(cardLayoutManager);
        touchHelper.attachToRecyclerView(recyclerView);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.huanyipi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.huanyipi:
                page++;
                map.put("catalogId", "402834815584e463015584e539330016");
                map.put("pnum", page + "");
                //进行连接
                myPresenter.setData("columns/getVideoList.do", map);
                break;
        }
    }

    @Override
    public void getDatas(MyGson myGson) {
        myGsons = myGson;
        initData();
    }
}
