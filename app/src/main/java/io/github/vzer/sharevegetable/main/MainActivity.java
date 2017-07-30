package io.github.vzer.sharevegetable.main;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yancy.imageselector.ImageSelector;
import com.yancy.imageselector.ImageSelectorActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.vzer.common.app.BaseActivity;
import io.github.vzer.common.widget.NewTip;
import io.github.vzer.factory.utils.FragmentUtil;
import io.github.vzer.factory.utils.ToastUtil;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.find.FindFragment;
import io.github.vzer.sharevegetable.mine.MineFragment;
import io.github.vzer.sharevegetable.order.OrderFragment;
import io.github.vzer.sharevegetable.shopping.ShoppingActivity;
import io.github.vzer.sharevegetable.vegetable.VegetableFragment;

public class MainActivity extends BaseActivity {

    @BindView(R.id.txt_tab_find)
    TextView findTxt;
    @BindView(R.id.txt_tab_mine)
    TextView mineTxt;
    @BindView(R.id.txt_tab_order)
    TextView orderTxt;
    @BindView(R.id.txt_tab_vegetable)
    TextView vegetableTxt;
    @BindView(R.id.img_tab_find)
    ImageView findImg;
    @BindView(R.id.img_tab_order)
    ImageView orderImg;
    @BindView(R.id.img_tab_mine)
    ImageView mineImg;
    @BindView(R.id.img_tab_vegetable)
    ImageView vegetableImg;
    @BindView(R.id.ly_menu_find)
    LinearLayout findLayout;
    @BindView(R.id.ly_menu_mine)
    LinearLayout mineLayout;
    @BindView(R.id.ly_menu_order)
    LinearLayout orderLayout;
    @BindView(R.id.ly_menu_vegetable)
    LinearLayout vegetableLayout;
    @BindView(R.id.img_shopping)
    ImageView shoppingImg;
    @BindView(R.id.tip_sum)
    NewTip sumTip;
    private static final String ORDER_TAG = "order";
    private static final String FIND_TAG = "find";
    private static final String VEGETABLE_TAG = "vegetable";
    private static final String MINE_TAG = "mine";
    private ShoppingActivity shoppingActivity;

    public static void show(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    @Override
    protected void initData() {
    }

    @Override
    public void initWidget() {
        FragmentUtil.add(this, R.id.frame_content, new VegetableFragment(), VEGETABLE_TAG);
        changeVegetableMenuState();
    }

    @Override
    protected void initWindows() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }

    /**
     * 点击蔬菜按钮
     */
    @OnClick(R.id.ly_menu_vegetable)
    void onVegetableClicked() {
        replaceCurrentFragment(R.id.ly_menu_vegetable);
        changeVegetableMenuState();
    }

    /**
     * 点击订单按钮
     */
    @OnClick(R.id.ly_menu_order)
    void onOrderClicked() {
        replaceCurrentFragment(R.id.ly_menu_order);
        changeOrderMenuState();
    }

    /**
     * 点击发现按钮
     */
    @OnClick(R.id.ly_menu_find)
    void onFindClicked() {
        replaceCurrentFragment(R.id.ly_menu_find);
        changeFindMenuState();
    }

    /**
     * 点击我的按钮
     */
    @OnClick(R.id.ly_menu_mine)
    void onMineClicked() {
        replaceCurrentFragment(R.id.ly_menu_mine);
        changeMineMenuState();
    }

    /**
     * 点击购物按钮
     */
    @OnClick(R.id.img_shopping)
    void onShoppingClicked() {
        startActivity(new Intent(this, ShoppingActivity.class));
    }


    /**
     * 展示当前的fragment
     */
    private void replaceCurrentFragment(int id) {
        OrderFragment orderFragment = (OrderFragment) getSupportFragmentManager().findFragmentByTag(ORDER_TAG);
        MineFragment mineFragment = (MineFragment) getSupportFragmentManager().findFragmentByTag(MINE_TAG);
        VegetableFragment vegetableFragment = (VegetableFragment) getSupportFragmentManager().findFragmentByTag(VEGETABLE_TAG);
        FindFragment findFragment = (FindFragment) getSupportFragmentManager().findFragmentByTag(FIND_TAG);
        if (mineFragment != null) {
            FragmentUtil.hideFragment(this, mineFragment);
        }
        if (orderFragment != null) {
            FragmentUtil.hideFragment(this, orderFragment);
        }
        if (vegetableFragment != null) {
            FragmentUtil.hideFragment(this, vegetableFragment);
        }
        if (findFragment != null) {
            FragmentUtil.hideFragment(this, findFragment);
        }
        switch (id) {
            case R.id.ly_menu_find:
                if (findFragment == null) {
                    findFragment = new FindFragment();
                    FragmentUtil.add(this, R.id.frame_content, findFragment, FIND_TAG);
                } else {
                    FragmentUtil.showFragment(this, findFragment);
                }
                break;
            case R.id.ly_menu_mine:
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                    FragmentUtil.add(this, R.id.frame_content, mineFragment, MINE_TAG);
                } else {
                    FragmentUtil.showFragment(this, mineFragment);
                }
                break;
            case R.id.ly_menu_order:
                if (orderFragment == null) {
                    orderFragment = new OrderFragment();
                    FragmentUtil.add(this, R.id.frame_content, orderFragment, ORDER_TAG);
                } else {
                    FragmentUtil.showFragment(this, orderFragment);
                }
                break;
            case R.id.ly_menu_vegetable:
                if (vegetableFragment == null) {
                    vegetableFragment = new VegetableFragment();
                    FragmentUtil.add(this, R.id.frame_content, vegetableFragment, VEGETABLE_TAG);
                } else {
                    FragmentUtil.showFragment(this, vegetableFragment);
                }

                break;
            default:
                ToastUtil.showToast("逻辑不可达");
                break;
        }
    }

    /**
     * 改变蔬菜tab的状态
     */
    private void changeVegetableMenuState() {
        clearAllState();
        vegetableTxt.setSelected(true);
        vegetableImg.setSelected(true);
    }

    /**
     * 改变订单tab的状态
     */
    private void changeOrderMenuState() {
        clearAllState();
        orderTxt.setSelected(true);
        orderImg.setSelected(true);
    }

    /**
     * 改变发现tab的状态
     */
    private void changeFindMenuState() {
        clearAllState();
        findTxt.setSelected(true);
        findImg.setSelected(true);
    }

    /**
     * 改变我的tab的状态
     */
    private void changeMineMenuState() {
        clearAllState();
        mineTxt.setSelected(true);
        mineImg.setSelected(true);
    }

    /**
     * 清除所有状态
     */
    private void clearAllState() {
        vegetableTxt.setSelected(false);
        findTxt.setSelected(false);
        mineTxt.setSelected(false);
        orderTxt.setSelected(false);
        findImg.setSelected(false);
        mineImg.setSelected(false);
        vegetableImg.setSelected(false);
        orderImg.setSelected(false);
    }

}
