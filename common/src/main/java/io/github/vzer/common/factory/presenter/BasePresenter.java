package io.github.vzer.common.factory.presenter;

/**
 * MVP模式中 P层的基本公共方法
 * @author: Vzer.
 * @date: 2017/7/25.
 * @email: vzer@qq.com
 */

public class BasePresenter<T extends BaseContract.View> implements BaseContract.Presenter {
    protected T mView;

    /**
     * P层构造方法;
     * 创建P层时就进行双向绑定
     * @param mView V层的引用
     */
    @SuppressWarnings("unchecked")
    public BasePresenter(T mView) {
        this.mView = mView;
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {
        T view = mView;
        if (view !=null){
            view .showLoading();
        }
    }

    /**
     * 销毁P层,销毁V与P之间的引用
     */
    @SuppressWarnings("unchecked")
    @Override
    public void destory() {
        T view = mView;
        mView = null;
        if (view !=null){
            //销毁V层对P层的引用
            view.setPresenter(null);
        }
    }
}
