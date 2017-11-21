package com.bwie.liumengxin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bwie.liumengxin.bean.MyGson;
import com.bwie.liumengxin.fragment.FaxianFragment;
import com.bwie.liumengxin.fragment.JingxuanFragment;
import com.bwie.liumengxin.presenter.MyPresenter;
import com.bwie.liumengxin.view.Iview;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements Iview {


    MyPresenter myPresenter;
    Map<String, String> map;
    @BindView(R.id.lineat)
    FrameLayout lineat;
    @BindView(R.id.jingxuan)
    RadioButton jingxuan;
    @BindView(R.id.zhuanti)
    RadioButton zhuanti;
    @BindView(R.id.faxian)
    RadioButton faxian;
    @BindView(R.id.mine)
    RadioButton mine;
    @BindView(R.id.group)
    RadioGroup group;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fm = getSupportFragmentManager();
        //初始化p层
        myPresenter = new MyPresenter(this);
        map = new HashMap<>();
        map.put("catalogId", "402834815584e463015584e539330016");
        map.put("pnum", "1");
        //进行连接
        myPresenter.setData("columns/getVideoList.do", map);
        group.check(R.id.jingxuan);
    }

    MyGson my;

    @Override
    public void getDatas(MyGson myGson) {
        my = myGson;
        setfragment(new JingxuanFragment(my));
    }

    @OnClick({R.id.jingxuan, R.id.zhuanti, R.id.faxian, R.id.mine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.jingxuan:
                setfragment(new JingxuanFragment(my));
                break;
            case R.id.zhuanti:
                break;
            case R.id.faxian:
                setfragment(new FaxianFragment(my));
                break;
            case R.id.mine:
                break;
        }
    }

    /*
    动态添加fragment
     */
    public void setfragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.lineat, fragment);
        fragmentTransaction.commit();
    }

    ;
}
