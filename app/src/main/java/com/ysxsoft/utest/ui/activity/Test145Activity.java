package com.ysxsoft.utest.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ysxsoft.common_base.base.BaseActivity;
import com.ysxsoft.common_base.utils.JsonUtils;
import com.ysxsoft.common_base.utils.SharedPreferencesUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import com.ysxsoft.utest.ARouterPath;
import com.ysxsoft.utest.R;
import com.ysxsoft.utest.models.response.Test145Response;
import com.ysxsoft.utest.net.Api;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 测试页面145
 * create by Sincerly on 9999/9/9 0009
 **/
@Route(path = "/main/Test145Activity")
public class Test145Activity extends BaseActivity {
    @BindView(R.id.statusBar)
    View statusBar;
    @BindView(R.id.backWithText)
    TextView backWithText;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.backLayout)
    LinearLayout backLayout;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.customCenterTabView)
    LinearLayout customCenterTabView;
    @BindView(R.id.rightWithIcon)
    TextView rightWithIcon;
    @BindView(R.id.bg)
    LinearLayout bg;
    @BindView(R.id.bottomLineView)
    View bottomLineView;
    @BindView(R.id.parent)
    LinearLayout parent;

    public static void start(){
        ARouter.getInstance().build(ARouterPath.getTest145Activity()).navigation();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test145;
    }

    @Override
    public void doWork() {
        super.doWork();
        initTitle();
    }

    private void initTitle() {
        bg.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        backLayout.setVisibility(View.VISIBLE);
        back.setImageResource(R.mipmap.icon_gray_back);
        title.setText("测试145");
    }

    @OnClick(R.id.backLayout)
    public void onViewClicked() {
        backToActivity();
    }

    public void request() {
        showLoadingDialog("请求中");
        OkHttpUtils.post()
                .url(Api.GET_TEST145)
                .addParams("uid", SharedPreferencesUtils.getUid(Test145Activity.this))
                .tag(this)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        hideLoadingDialog();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        hideLoadingDialog();
                        Test145Response resp = JsonUtils.parseByGson(response,Test145Response.class);
                        if (resp != null) {
//                                if (HttpResponse.SUCCESS.equals(resp.getCode())) {
//                                    //请求成功
//                                    List<Test145Response.DataBean> data = resp.getData();
//                                    manager.setData(data);
//                                } else {
//                                    //请求失败
//                                    showToast(resp.getMsg());
//                                }
                        } else {
                            showToast("获取测试页面145失败");
                        }
                    }
                });
    }
}
