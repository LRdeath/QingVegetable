package io.github.vzer.sharevegetable.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import butterknife.BindView;
import io.github.vzer.sharevegetable.R;

/**
 * @author YangCihang
 * @since 17/8/3.
 * email yangcihang@hrsoft.net
 */

public class DistributeView extends LinearLayout {
    public DistributeView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.view_image_distribute_statue, this, true);
    }

    public DistributeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_image_distribute_statue, this, true);
        initView();
    }

    /**
     * 初始化布局信息（暴露出view设置的相关接口）
     */
    private void initView() {
    }

}
