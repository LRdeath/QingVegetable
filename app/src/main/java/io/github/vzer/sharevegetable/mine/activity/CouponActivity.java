package io.github.vzer.sharevegetable.mine.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.github.vzer.common.app.ToolbarActivityPresenter;
import io.github.vzer.common.widget.recycler.RecyclerScrollListener;
import io.github.vzer.factory.model.mine.coupon.CouponModel;
import io.github.vzer.factory.presenter.mine.CouponContract;
import io.github.vzer.factory.presenter.mine.CouponPresenter;
import io.github.vzer.factory.utils.Utility;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.mine.adapter.CouponAdapter;

/**
 * 优惠券
 *
 * @author YangCihang
 * @since 17/8/21.
 * email yangcihang@hrsoft.net
 */

public class CouponActivity extends ToolbarActivityPresenter<CouponContract.Presenter>
        implements CouponContract.View {
    @BindView(R.id.rec_coupon)
    RecyclerView couponRec;
    private CouponAdapter adapter;
    private ArrayList<CouponModel> list;

    @Override
    public void showError(int strId) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public CouponContract.Presenter initPresenter() {
        return new CouponPresenter(this);
    }

    @Override
    protected void initWidget() {
        setActivityTitle("优惠信息");
        initList();
        //初始化列表
        mPresenter.requestCoupon();
    }

    @Override
    protected void initData() {
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_coupon;
    }

    /**
     * 初始化list
     */
    private void initList() {
        list = new ArrayList<>();
        adapter = new CouponAdapter(this, list);
        couponRec.setLayoutManager(new LinearLayoutManager(this));
        couponRec.setAdapter(adapter);
    }

    @Override
    public void onDataLoadSuccess(List<CouponModel> couponModelList) {
        adapter.addAll(couponModelList);
    }

    @Override
    public void onDataLoadFailed() {

    }
}
