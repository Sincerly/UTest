package com.ysxsoft.utest.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ysxsoft.common_base.base.BaseActivity;
import com.ysxsoft.common_base.utils.WebViewUtils;

import com.ysxsoft.utest.ARouterPath;
import com.ysxsoft.utest.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * web1页面
 * create by Sincerly on 9999/9/9 0009
 **/
@Route(path = "/main/Web1Activity")
public class Web1Activity extends BaseActivity {
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
    @BindView(R.id.webView)
    WebView webView;
    @BindView(R.id.parent)
    LinearLayout parent;
    @Autowired
    String webTitle;
    @Autowired
    String webUrl;
    @Autowired
    String webContent;

    public static void start(String url) {
        ARouter.getInstance().build(ARouterPath.getWeb1Activity()).withString("webUrl", url).navigation();
    }

    public static void startUrl(String title, String url) {
        ARouter.getInstance().build(ARouterPath.getWeb1Activity()).withString("webTitle", title).withString("webUrl", url).navigation();
    }

    public static void startContent(String title, String content) {
        ARouter.getInstance().build(ARouterPath.getWeb1Activity()).withString("webTitle", title).withString("webContent", content).navigation();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_web1;
    }

    @Override
    public void doWork() {
        super.doWork();
        ARouter.getInstance().inject(this);
        initTitle();
        initWebView();
    }

    private void initTitle() {
        bg.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        backLayout.setVisibility(View.VISIBLE);
        back.setImageResource(R.mipmap.icon_gray_back);
        if (webTitle == null) {
            title.setText("测试13");
        } else {
            title.setText(webTitle);
        }
    }

    private void initWebView() {
        WebViewUtils.init(webView);
        if (webUrl != null) {
            webView.loadUrl(webUrl);
        } else {
            if (webContent != null) {
                WebViewUtils.setH5Data(webView, webContent);
            } else {
                //自定义处理
                onCustom(webView);
            }
        }
    }

    @OnClick(R.id.backLayout)
    public void onViewClicked() {
        if (webView.canGoBack()) {
            webView.goBack();
            return;
        }
        backToActivity();
    }

    public void onCustom(WebView webView) {
    }
}
