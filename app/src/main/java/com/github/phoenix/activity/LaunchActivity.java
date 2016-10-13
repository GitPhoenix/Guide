package com.github.phoenix.activity;


import android.os.Handler;

import com.github.phoenix.base.BaseActivity;
import com.github.phoenix.utils.Constant;
import com.github.phoenix.utils.SPUtil;
import com.github.phoenix.utils.StartActivityUtil;

/**
 * 启动页
 *
 * @author Phoenix
 * @date 2016-10-13 14:16
 */
public class LaunchActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        //此处，在主题里面配置了背景，并且背景图一样，所以不需要布局文件了
        return 0;
    }

    @Override
    protected void setSubView() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //判断是不是第一次启动此应用，第一次启动进入GuideActivity，否则直接进入MainActivity
                if (!SPUtil.getBoolean(Constant.SP_IS_FIRST_LOGIN, false)) {
                    StartActivityUtil.startActivity(LaunchActivity.this, GuideActivity.class);
                }else {
                    StartActivityUtil.startActivity(LaunchActivity.this, MainActivity.class);
                }
                finish();
            }
        }, 2 * 1000);
    }

    @Override
    protected void initEvent() {

    }
}
