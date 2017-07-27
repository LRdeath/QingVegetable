package io.github.vzer.common.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

/**
 * @author: Vzer.
 * @date: 2017/7/27. 12:29
 * @email: vzer@qq.com
 */

public class RefreshLayout extends LinearLayout {

    public RefreshLayout(Context context) {
        super(context);
    }

    public RefreshLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RefreshLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        addHeadRefresh();
    }

    private void addHeadRefresh() {
        setOrientation(LinearLayout.VERTICAL);
        ProgressBar progressBar = new ProgressBar(getContext());
        addView(progressBar, 0);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        scrollBy(0, getChildAt(0).getHeight());
    }
}
