package io.github.vzer.sharevegetable.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/**
 * 只展示内容的RecyclerView
 *
 * @author YangCihang
 * @since 17/8/7.
 * email yangcihang@hrsoft.net
 */

public class NoTouchRecyclerView extends RecyclerView {
    float y, downY;
    float mTouchSlop = ViewConfiguration.getTouchSlop(); //获取滑动最小位移量

    public NoTouchRecyclerView(Context context) {
        super(context);
    }

    public NoTouchRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NoTouchRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        return false;
    }
}
