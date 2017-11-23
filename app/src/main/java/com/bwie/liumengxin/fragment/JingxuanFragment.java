package com.bwie.liumengxin.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.liumengxin.R;
import com.bwie.liumengxin.adapter.MyAdApter;
import com.bwie.liumengxin.bean.MyGson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * date：2017/11/20
 * 用途：
 */
public class JingxuanFragment extends Fragment {
    @BindView(R.id.recycler)
    XRecyclerView recycler;
    Unbinder unbinder;

    private MyGson myGson;

    public JingxuanFragment(MyGson myGson) {
        this.myGson = myGson;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.ites, null);
        unbinder = ButterKnife.bind(this, view);
        //配置recyclerview
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.setAdapter(new MyAdApter(getActivity(), myGson));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
