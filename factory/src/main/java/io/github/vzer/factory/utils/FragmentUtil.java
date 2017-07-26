package io.github.vzer.factory.utils;


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
     * @param context
     * @param viewId
     * @param fragment
     */
    public static void add(BaseActivity context, int viewId, Fragment fragment) {
        context.getSupportFragmentManager()
                .beginTransaction()
                .add(viewId,fragment)
                .commit();
    }

    /**
     * 替换Fragment
     * @param context
     * @param viewId
     * @param fragment
     */
    public static void replace(BaseActivity context, int viewId, Fragment fragment) {
        context.getSupportFragmentManager()
                .beginTransaction()
                .replace(viewId,fragment)
                .commit();
    }

}
