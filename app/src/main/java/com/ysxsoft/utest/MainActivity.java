package com.ysxsoft.utest;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ysxsoft.common_base.base.BaseActivity;
import com.ysxsoft.common_base.base.ViewPagerFragmentAdapter;
import com.ysxsoft.common_base.utils.SharedPreferencesUtils;
import com.ysxsoft.common_base.view.widgets.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import com.ysxsoft.utest.ui.fragment.MainChild1Fragment;
import com.ysxsoft.utest.ui.fragment.MainChild2Fragment;
import com.ysxsoft.utest.ui.fragment.MainChild3Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/main/MainActivity")
public class MainActivity extends BaseActivity {
    @BindView(R.id.bottomNavigationView)
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.viewPager)
    NoScrollViewPager viewPager;

    public static void start() {
        ARouter.getInstance().build(ARouterPath.getMainActivity()).navigation();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_base_tab_notitle;
    }

    @Override
    public void doWork() {
        super.doWork();
        initViewPager();
    }

    private void initViewPager() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new MainChild1Fragment());
        fragmentList.add(new MainChild2Fragment());
        fragmentList.add(new MainChild3Fragment());
        viewPager.setAdapter(new ViewPagerFragmentAdapter(getSupportFragmentManager(), fragmentList, new ArrayList<String>()));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int position) {
                viewPager.setCurrentItem(position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                resetMenu(position);
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });
        viewPager.setOffscreenPageLimit(4);
        resetMenu(0);
    }

    /**
     * 切换菜单
     *
     * @param position
     */
    private void resetMenu(int position) {
        if (bottomNavigationView != null) {
            bottomNavigationView.getMenu().getItem(1).setIcon(position == 1 ? R.mipmap.icon_tab2_selected : R.mipmap.icon_tab2_normal);
            bottomNavigationView.getMenu().getItem(2).setIcon(position == 2 ? R.mipmap.icon_tab3_selected : R.mipmap.icon_tab3_normal);
            bottomNavigationView.getMenu().getItem(3).setIcon(position == 3 ? R.mipmap.icon_tab4_selected : R.mipmap.icon_tab4_normal);
        }
        switch (position) {
            case 0:
                //菜单1
                break;
            case 1:
                //菜单2
                break;
            case 2:
                //菜单3
                break;
            case 3:
                //菜单4
                break;
        }
    }
}
