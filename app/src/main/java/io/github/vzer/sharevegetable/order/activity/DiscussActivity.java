package io.github.vzer.sharevegetable.order.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.vzer.common.app.ToolbarActivityPresenter;
import io.github.vzer.factory.model.order.DiscussModel;
import io.github.vzer.factory.model.order.DiscussVegetableModel;
import io.github.vzer.factory.model.order.OrderDetailModel;
import io.github.vzer.factory.presenter.order.OrderContract;
import io.github.vzer.factory.presenter.order.OrderPresenter;
import io.github.vzer.factory.utils.ToastUtil;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.order.adapter.DiscussVegetableAdapter;

/**
 * @author YangCihang
 * @since 17/8/4.
 * email yangcihang@hrsoft.net
 */

public class DiscussActivity extends ToolbarActivityPresenter<OrderContract.Presenter>
        implements OrderContract.View {
    @BindView(R.id.rec_discuss_vegetable)
    RecyclerView vegetableRec;
    @BindView(R.id.txt_submit_discuss)
    TextView toSubmitDiscussTxt;
    private DiscussVegetableAdapter adapter;
    private List<DiscussVegetableModel> modelList;

    @Override
    public void showError(int strId) {
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void loadOrderDetailListSuccess(List<OrderDetailModel> orderDetailModelList) {

    }

    @Override
    public OrderContract.Presenter initPresenter() {
        return new OrderPresenter(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initWidget() {
        setActivityTitle(getString(R.string.title_discuss));
        LinearLayoutManager manager = new LinearLayoutManager(this);
        modelList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            modelList.add(new DiscussVegetableModel());
        }
        adapter = new DiscussVegetableAdapter(this, modelList);
        vegetableRec.setLayoutManager(manager);
        vegetableRec.setAdapter(adapter);
    }

    @Override
    protected void initWindows() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_discuss;
    }

    @OnClick(R.id.txt_submit_discuss)
    void onSubmitDiscussClicked() {
        // TODO: 17/8/6 model添加订单号等数据
        DiscussModel discussModel = new DiscussModel();
        boolean canSendRequest = true;
        List<DiscussVegetableModel> vegetableList = adapter.getListData();
        for (DiscussVegetableModel model : vegetableList) {
            if (model.getSatisfation() == DiscussVegetableModel.STATE_UNSELECTED) {
                canSendRequest = false;
                ToastUtil.showToast(R.string.toast_please_choose_satisfation);
            }
        }
        if (canSendRequest) {
            discussModel.setVegetableModelList(vegetableList);
            mPresenter.sendDiscussRequest(discussModel);
        }
    }
}
