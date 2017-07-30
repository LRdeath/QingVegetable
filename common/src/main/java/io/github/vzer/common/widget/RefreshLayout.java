package io.github.vzer.common.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Scroller;
import android.widget.Toast;

/**
 * @author: Vzer.
 * @date: 2017/7/27. 12:29
 * @email: vzer@qq.com
 */

public class RefreshLayout extends LinearLayout {
    private Scroller scroller = new Scroller(getContext());
    private ListView listView;
    private RecyclerView recyclerView;
    private OnRefreshListener mListener;
    private boolean interrupt;
    private boolean isRefresh;
    private int curY;
    private int bufferY;
    private int preY;
    private int mTouchSlop = ViewConfiguration.getTouchSlop();

    public RefreshLayout(Context context) {
        super(context);
        init();
    }

    public RefreshLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RefreshLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        addHeadRefresh();
    }

    private void addHeadRefresh() {
        setOrientation(LinearLayout.VERTICAL);
        ProgressBar progressBar = new ProgressBar(getContext());
        progressBar.setProgress(0);
        addView(progressBar, 0);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        scrollTo(0, getChildAt(0).getHeight());
        checkChildView();
    }

    private void checkChildView() {
        //检测是否有scrollview
        for (int i = 0; i < getChildCount(); i++) {
            Object v = getChildAt(i);
            if (v instanceof ListView) {
                listView = (ListView) v;
            } else if (v instanceof RecyclerView) {
                recyclerView = (RecyclerView) v;
            }
        }
    }

    //下滑拦截事件
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        curY = (int) ev.getRawY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                interrupt = false;
                break;
            case MotionEvent.ACTION_MOVE:
                //如果滑动区域在listviewView或RecyclerView,则不拦截
                interrupt = curY - preY > mTouchSlop && !isMoveListView() && !isMoveRecyclerView();
                break;
            case MotionEvent.ACTION_UP:
                interrupt = false;
                break;
        }
        preY = curY;

        return interrupt;
    }

    //检测移动区域是不是在RecyclerView
    private boolean isMoveRecyclerView() {
        return recyclerView != null && ViewCompat.canScrollVertically(recyclerView, -1);

    }

    private boolean isMoveListView() {
        return listView != null && ViewCompat.canScrollVertically(listView, -1);

    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!scroller.isFinished() || isRefresh) {
            return true;
        }
        curY = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                int moveY = curY - preY;
                if (moveY > 0) {
                    scrollBy(0, -moveY / 3); //  /2为了让下拉有感觉
                    bufferY += moveY / 3;
                } else {
                    if (isRefresh) endRefresh();
                }
                break;
            case MotionEvent.ACTION_UP:
                if (bufferY > getChildAt(0).getHeight()) {
                    smoothToScroll(bufferY - getChildAt(0).getHeight());
                    bufferY = getChildAt(0).getHeight();
                    isRefresh = true;
                    if (mListener != null) mListener.OnRefresh();
                    else {
                        //监听器不存在；结束刷新
                        delayedFinish();
                    }
                    Toast.makeText(getContext(), "正在刷新中", Toast.LENGTH_SHORT).show();
                } else {
                    endRefresh();
                }
                break;
        }
        preY = curY;
        return true;
    }

    /**
     * 延迟800毫秒结束刷新
     */
    private void delayedFinish() {
        postDelayed(new Runnable() {
            @Override
            public void run() {
                endRefresh();
            }
        }, 800);
    }

    //结束滑动的方法
    public void endRefresh() {
        isRefresh = false;
        smoothToScroll(bufferY);
        bufferY = 0;
    }

    private void smoothToScroll(int y) {
        scroller.startScroll(0, getScrollY(), 0, y, 500);
        invalidate();
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (scroller.computeScrollOffset()) {
            scrollTo(0, scroller.getCurrY());
            postInvalidate();
        }
    }

    //设置刷新方法监听器
    public void setReefreshListener(OnRefreshListener listener) {
        mListener = listener;
    }

    //开始刷新的回调方法
    public interface OnRefreshListener {
        void OnRefresh();
    }

}
