package com.ysxsoft.common_base.ui.welcome;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.ysxsoft.common_base.R;
import com.ysxsoft.common_base.base.BaseActivity;
import com.ysxsoft.common_base.utils.SharedPreferencesUtils;

/**
 * create by Sincerly on 2019/1/3 0003
 **/
public class SplashActivity extends BaseActivity {

    @Override
    public void doWork() {
        super.doWork();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
//                if(SharedPreferencesUtils.hasShowGui(SplashActivity.this)){
                    if("".equals(SharedPreferencesUtils.getUid(SplashActivity.this))){
                        //未登录 跳转到登录页面  Tips:宿主工程必须依赖 annotationProcessor 'com.alibaba:arouter-compiler:1.2.2'
                        ARouter.getInstance().build("/main/LoginActivity").navigation();
                    }else{
                        //已登录 跳转到主页
                        ARouter.getInstance().build("/main/MainActivity").navigation();
                    }
//                }else{
//                    ARouter.getInstance().build("/main/GuideActivity").navigation();//跳转到引导页
//                }
                finish();
            }
        },1500);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }
}
