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
import com.ysxsoft.utest.models.response.Test89Response;
import com.ysxsoft.utest.net.Api;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 测试页面89
 * create by Sincerly on 9999/9/9 0009
 **/
@Route(path = "/main/Test89Activity")
public class Test89Activity extends BaseActivity {
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
        ARouter.getInstance().build(ARouterPath.getTest89Activity()).navigation();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test89;
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
        title.setText("测试89");
    }

    @OnClick(R.id.backLayout)
    public void onViewClicked() {
        backToActivity();
    }

    public void request() {
        showLoadingDialog("请求中");
        OkHttpUtils.post()
                .url(Api.GET_TEST89)
                .addParams("uid", SharedPreferencesUtils.getUid(Test89Activity.this))
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
                        Test89Response resp = JsonUtils.parseByGson(response,Test89Response.class);
                        if (resp != null) {
//                                if (HttpResponse.SUCCESS.equals(resp.getCode())) {
//                                    //请求成功
//                                    List<Test89Response.DataBean> data = resp.getData();
//                                    manager.setData(data);
//                                } else {
//                                    //请求失败
//                                    showToast(resp.getMsg());
//                                }
                        } else {
                            showToast("获取测试页面89失败");
                        }
                    }
                });
    }
}
