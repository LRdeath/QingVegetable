package io.github.vzer.common.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    protected Unbinder mRootUnbinder;

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
            mRootUnbinder = ButterKnife.bind(this, root);
            initWidet(root);
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
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDatas();
    }

    /**
     * 初始化数据
     */
    protected abstract void initDatas();

    /**
     * 初始化控件
     */
    protected abstract void initWidet(View root);


    /**
     * 初始化相关参数Bundle
     * @param arguments
     */
    protected abstract void initArgs(Bundle arguments);

    /**
     * 获取当前界面资源id
     */
    protected abstract int getContentLayoutId();
}
