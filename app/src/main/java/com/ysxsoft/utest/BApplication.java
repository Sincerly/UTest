package com.ysxsoft.utest;

import android.content.Context;

import com.ysxsoft.common_base.base.BaseApplication;
import com.ysxsoft.common_base.jpush.JpushUtils;

public class BApplication extends BaseApplication {
    public static Context context;

    @Override
    protected void handle() {
        super.handle();
        JpushUtils.init(this);
        context = super.getApplicationContext();
    }

    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
