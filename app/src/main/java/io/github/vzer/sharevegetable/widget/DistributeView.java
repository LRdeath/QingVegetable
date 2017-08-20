package io.github.vzer.sharevegetable.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.vzer.sharevegetable.R;

/**
 * @author YangCihang
 * @since 17/8/3.
 * email yangcihang@hrsoft.net
 */

public class DistributeView extends LinearLayout {

    //    @BindView(R.id.img_submit)
//    ImageView submitImg;
    @BindView(R.id.img_payment)
    ImageView paymentImg;
    @BindView(R.id.img_pick)
    ImageView pickImg;
    @BindView(R.id.img_finish)
    ImageView finishImage;
    //    @BindView(R.id.txt_submit)
//    TextView submitTxt;
    @BindView(R.id.txt_firm_payment)
    TextView paymentTxt;
    @BindView(R.id.txt_pick)
    TextView pickTxt;
    @BindView(R.id.txt_finish)
    TextView finishTxt;
    @BindView(R.id.img_point_pick)
    ImageView pickPointImg;
    @BindView(R.id.img_point_finish)
    ImageView finishPointImg;
//    @BindView(R.id.img_point_payment)
//    ImageView paymentPointImg;

    private Context mContext;

    public DistributeView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.view_image_distribute_statue, this, true);
        mContext = context;
        initView();
    }

    public DistributeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_image_distribute_statue, this, true);
        mContext = context;
        initView();
    }

    /**
     * 初始化布局信息（暴露出view设置的相关接口）
     */
    private void initView() {
        ButterKnife.bind(getRootView(), this);
    }

    /**
     * 设置待付款状态
     */
    public void setPaymentState() {
        paymentImg.setSelected(true);
        paymentTxt.setSelected(true);
    }

    /**
     * 设置待取货状态
     */
    public void setPickState() {
        setPaymentState();
        pickImg.setSelected(true);
        pickPointImg.setSelected(true);
        pickTxt.setSelected(true);
    }

    /**
     * 设置已完成状态
     */
    public void setFinishState() {
        setPickState();
        finishImage.setSelected(true);
        finishPointImg.setSelected(true);
        finishTxt.setSelected(true);
    }

}
