package io.github.vzer.sharevegetable.lock;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.vzer.common.app.ActivityPresenter;
import io.github.vzer.factory.model.order.OrderDetailModel;
import io.github.vzer.factory.presenter.lock.UnlockContract;
import io.github.vzer.factory.presenter.lock.UnlockPresenter;
import io.github.vzer.sharevegetable.R;

/**
 * @author YangCihang
 * @since 17/8/3.
 * email yangcihang@hrsoft.net
 */

public class UnlockActivity extends ActivityPresenter<UnlockContract.Presenter>
        implements UnlockContract.View {
    @BindView(R.id.rec_lock_order)
    RecyclerView orderRec;
    @BindView(R.id.img_lock_circle)
    ImageView lockCircleImg;
    @BindView(R.id.img_lock_content)
    ImageView lockContentImg;
    @BindView(R.id.txt_clicked_lock)
    TextView clickedLockTxt;
    private Animation animation;
    private boolean isLockStart = false;
    private LockOrderAdapter adapter;
    @Override
    public void showError(int strId) {
    }

    @Override
    public void showLoading() {

    }

    @Override
    public UnlockContract.Presenter initPresenter() {
        return new UnlockPresenter(this);
    }

    @Override
    protected void initData() {
        animation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);

        //测试数据
        List<OrderDetailModel> list = new ArrayList<>();
        list.add(new OrderDetailModel());
        adapter = new LockOrderAdapter(this, list);
    }

    @Override
    public void initWidget() {
//        RotateAnimation rotateAnimation = new RotateAnimation(0f,360f, Animation.RELATIVE_TO_SELF,
//                0,Animation.RELATIVE_TO_SELF,0);
//        rotateAnimation.setDuration(1000);
//        rotateAnimation.setInterpolator(new LinearInterpolator());
//        rotateAnimation.setRepeatCount(Animation.INFINITE);
//        lockCircleImg.setAnimation(rotateAnimation);
//        rotateAnimation.start();
        lockCircleImg.setAnimation(animation);
        animation.cancel();
        orderRec.setAdapter(adapter);
        orderRec.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initWindows() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_unlock;
    }

    @OnClick(R.id.img_lock_content)
    void onLockClicked() {
        if (isLockStart) {
            animation.cancel();
            isLockStart = !isLockStart;
            lockContentImg.setSelected(false);
            clickedLockTxt.setText(R.string.text_click_to_unlock);
        } else {
            animation.start();
            lockContentImg.setSelected(true);
            isLockStart = !isLockStart;
            clickedLockTxt.setText(R.string.text_click_to_lock);
        }
    }
}
