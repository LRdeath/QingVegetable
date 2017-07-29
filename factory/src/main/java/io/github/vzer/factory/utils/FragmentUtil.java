package io.github.vzer.factory.utils;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import io.github.vzer.common.app.BaseActivity;

/**
 * Fragment管理类
 * @author: Vzer.
 * @date: 2017/7/25.
 * @email: vzer@qq.com
 */

public class FragmentUtil {
    /**
     * 添加Fragment
     */
    public static void add(BaseActivity context, int viewId, Fragment fragment, @Nullable String tag) {
        context.getSupportFragmentManager()
                .beginTransaction()
                .add(viewId, fragment, tag)
                .commit();
    }

    /**
     * 替换Fragment
     */
    public static void replace(BaseActivity context, int viewId, Fragment fragment, @Nullable String tag) {
        context.getSupportFragmentManager()
                .beginTransaction()
                .replace(viewId, fragment, tag)
                .commit();
    }

    /**
     * 隐藏Fragment
     */
    public static void hideFragment(BaseActivity context, Fragment fragment) {
        context.getSupportFragmentManager()
                .beginTransaction()
                .hide(fragment)
                .commit();
    }

    /**
     * 展示Fragment
     */
    public static void showFragment(BaseActivity context, Fragment fragment) {
        context.getSupportFragmentManager()
                .beginTransaction()
                .show(fragment)
                .commit();
    }
}
