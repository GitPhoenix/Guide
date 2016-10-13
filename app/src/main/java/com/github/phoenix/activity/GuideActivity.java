package com.github.phoenix.activity;


import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.github.phoenix.R;
import com.github.phoenix.adapter.GuidePagerAdapter;
import com.github.phoenix.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 导航页
 *
 * @author Phoenix
 * @date 2016-10-13 14:16
 */
public class GuideActivity extends BaseActivity {

    private List<View> views;

    @Override
    protected int getLayoutId() {
        requestWindowFeature(Window.FEATURE_NO_TITLE); //设置无标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);  //设置全屏
        return R.layout.activity_guide;
    }

    @Override
    protected void setSubView() {
        views = new ArrayList<View>();
        LayoutInflater inflater = LayoutInflater.from(this);

        //把引导页加入到集合中
        views.add(inflater.inflate(R.layout.view_guide_01, null));
        views.add(inflater.inflate(R.layout.view_guide_02, null));
        views.add(inflater.inflate(R.layout.view_guide_03, null));
        views.add(inflater.inflate(R.layout.view_guide_04, null));

        GuidePagerAdapter guidePagerAdapter = new GuidePagerAdapter(views, this);
        ((ViewPager)findViewById(R.id.viewpager_guide)).setAdapter(guidePagerAdapter);
    }

    @Override
    protected void initEvent() {

    }
}
