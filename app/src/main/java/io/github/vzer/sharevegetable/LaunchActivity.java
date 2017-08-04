package io.github.vzer.sharevegetable;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;

import butterknife.BindView;
import io.github.vzer.common.app.BaseActivity;
import io.github.vzer.sharevegetable.account.AccountActivity;
import io.github.vzer.sharevegetable.main.MainActivity;
import io.github.vzer.sharevegetable.vegetable.animation.ShoppingCartAnimationView;

public class LaunchActivity extends BaseActivity {

    private boolean isLogin = true;//是否登录了
    @BindView(R.id.rl_launch)
    RelativeLayout launchRL;

    @Override
    protected void initData() {
    }

    @Override
    public void initWidget() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!isLogin) {
                    AccountActivity.show(LaunchActivity.this);

                } else MainActivity.show(LaunchActivity.this);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        }, 1500);
        playAnimation();
    }

    private void playAnimation() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(520, 264);
        valueAnimator.setDuration(1500);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer height = (Integer) valueAnimator.getAnimatedValue();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) launchRL.getLayoutParams();
                layoutParams.height = (int) convertDpToPixel(height, LaunchActivity.this);
                launchRL.setLayoutParams(layoutParams);
            }
        });
        valueAnimator.start();

    }

    @Override
    protected void initWindows() {
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_launch;
    }

    /**
     * dp换成当前分辨率px
     */
    public float convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();

        float px = dp * (metrics.densityDpi / 160f);
        return px;
    }

}
