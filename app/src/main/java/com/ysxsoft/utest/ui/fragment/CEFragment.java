package com.ysxsoft.utest.ui.fragment;

import android.view.View;

import com.ysxsoft.common_base.base.BaseFragment;
import com.ysxsoft.common_base.utils.JsonUtils;
import com.ysxsoft.common_base.utils.SharedPreferencesUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import com.ysxsoft.utest.R;
import com.ysxsoft.utest.net.Api;
import okhttp3.Call;

/**
* 测试Fragment页面
* create by Sincerly on 9999/9/9 0009
**/
public class CEFragment extends BaseFragment {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_ce;
    }

    @Override
    protected void doWork(View view) {

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    public void request() {
        showLoadingDialog("请求中");
        OkHttpUtils.post()
//                .url(Api.GET_CODE)
                .addParams("uid", SharedPreferencesUtils.getUid(getActivity()))
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
//                        ListResponse resp = JsonUtils.parseByGson(response, ListResponse.class);
//                        if (resp != null) {
//                                if (HttpResponse.SUCCESS.equals(resp.getCode())) {
//                                    //请求成功
//                                    List<ListResponse.DataBean> data = resp.getData();
//                                    manager.setData(data);
//                                } else {
//                                    //请求失败
//                                    showToast(resp.getMsg());
//                                }
//                        } else {
//                            showToast("获取失败");
//                        }
                    }
                });
    }
}
