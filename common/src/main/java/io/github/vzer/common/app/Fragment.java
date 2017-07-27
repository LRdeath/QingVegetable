package io.github.vzer.common.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Fragment的封装
 *
 * @author: Vzer.
 * @date: 2017/7/25.
 * @email: vzer@qq.com
 */

public abstract class Fragment extends android.support.v4.app.Fragment {
    private View mRoot;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initArgs(getArguments());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layId = getContentLayoutId();
        if (mRoot == null) {
            View root = inflater.inflate(layId, container, false);

            initWidget(root);
            mRoot = root;
        } else {
            if (mRoot.getParent() != null) {
                //移除当前布局的父布局
                ((ViewGroup) mRoot.getParent()).removeView(mRoot);
            }
        }
        return mRoot;
    }

    /**
     * BaseActivity onCreate（）执行完后回调这个方法
     *
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化控件
     */
    protected void initWidget(View root) {
        ButterKnife.bind(this, root);
    }


    /**
     * 初始化相关参数Bundle
     */
    protected abstract void initArgs(Bundle arguments);

    /**
     * 获取当前界面资源id
     */
    protected abstract int getContentLayoutId();
}
