package com.github.phoenix.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
        setSubView();
        initEvent();
    }

    protected abstract int getLayoutId();
    protected abstract void setSubView();
    protected abstract void initEvent();
}
