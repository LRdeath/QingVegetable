package io.github.vzer.sharevegetable.mine;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.yancy.imageselector.ImageSelector;
import com.yancy.imageselector.ImageSelectorActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.vzer.common.app.FragmentPresenter;
import io.github.vzer.common.widget.DialogUtils;
import io.github.vzer.factory.presenter.mine.MineContract;
import io.github.vzer.factory.presenter.mine.MinePresenter;
import io.github.vzer.factory.utils.Image.ImageSelectorUtils;
import io.github.vzer.factory.utils.ToastUtil;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.account.AccountActivity;
import io.reactivex.functions.Consumer;

import static android.app.Activity.RESULT_OK;

/**
 * @author YangCihang
 * @since 17/7/27.
 * email yangcihang@hrsoft.net
 */

public class MineFragment extends FragmentPresenter<MineContract.Presenter> implements MineContract.View {

    @BindView(R.id.img_circle_avatar)
    ImageView avatarImg;
    @BindView(R.id.txt_user_name)
    TextView userNameTxt;
    @BindView(R.id.txt_nickname)
    TextView nicknameTxt;
    @BindView(R.id.txt_true_name)
    TextView trueNameTxt;
    @BindView(R.id.txt_sex)
    TextView sexTxt;
    @BindView(R.id.txt_mobile)
    TextView mobileTxt;
    @BindView(R.id.txt_logout)
    TextView exitTxt;
    @BindView(R.id.txt_contract)
    TextView contractTxt;
    @BindView(R.id.ly_user_name)
    RelativeLayout userNameLy;
    @BindView(R.id.ly_true_name)
    RelativeLayout trueNameLy;
    @BindView(R.id.ly_sex)
    RelativeLayout sexLy;
    @BindView(R.id.ly_mobile)
    RelativeLayout mobileLy;

    @Override
    public void showLoading() {

    }

    @Override
    protected MineContract.Presenter initPresenter() {
        return new MinePresenter(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initArgs(Bundle arguments) {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_mine;
    }

    /**
     * 改变用户名
     */
    @OnClick(R.id.ly_user_name)
    void changeUserName() {
        new DialogUtils(getContext())
                .setCancelable(false)
                .setInputEditView()
                .setInputHintText("请输入您要修改的用户名")
                .setNegativeButton(null)
                .setTitleText("修改用户名")
                .setPositiveButton(new DialogUtils.OnButtonListener() {
                    @Override
                    public void onButtonClicked(DialogUtils dialogUtils) {
                        mPresenter.changeUserName(dialogUtils.getInputText());
                    }
                })
                .showDialog();

    }

    /**
     * 改变真实姓名
     */
    @OnClick(R.id.ly_true_name)
    void changeTrueName() {
        new DialogUtils(getContext())
                .setCancelable(false)
                .setInputEditView()
                .setInputHintText("请输入您的真实姓名")
                .setNegativeButton(null)
                .setTitleText("修改真实姓名")
                .setPositiveButton(new DialogUtils.OnButtonListener() {
                    @Override
                    public void onButtonClicked(DialogUtils dialogUtils) {
                        mPresenter.changeTrueName(dialogUtils.getInputText());
                    }
                })
                .showDialog();
    }

    /**
     * 改变性别
     */
    @OnClick(R.id.ly_sex)
    void changeSex() {
        final boolean[] sex = {true}; //男为true，女为false默认为男;
        new DialogUtils(getContext())
                .setCancelable(false)
                .setNegativeButton(null)
                .setTitleText("修改性别")
                .setCustomView(R.layout.view_dialog_choose_sex, new DialogUtils.OnViewListener() {
                    @Override
                    public void onViewEventSetting(View view) {
                        RadioGroup sexGroup = view.findViewById(R.id.group_sex);
                        sexGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                switch (i) {
                                    case R.id.btn_man:
                                        sex[0] = true;
                                        break;
                                    case R.id.btn_woman:
                                        sex[0] = false;
                                        break;
                                    default:
                                        ToastUtil.showToast("逻辑不可达");
                                        break;
                                }
                            }
                        });
                    }
                })
                .setPositiveButton(new DialogUtils.OnButtonListener() {
                    @Override
                    public void onButtonClicked(DialogUtils dialogUtils) {
                        mPresenter.changeSex(sex[0]);
                        ToastUtil.showToast("已选择性别");
                    }
                })
                .showDialog();
    }

    /**
     * 点击手机号
     */
    @OnClick(R.id.ly_mobile)
    void changeMobile() {
        ToastUtil.showToast("点击了手机号");
    }

    /**
     * 登出
     */
    @OnClick(R.id.txt_logout)
    void onGoLogin() {
        mPresenter.goLogin();
        AccountActivity.show(getContext());
    }

    /**
     * 跳转到拨号
     */
    @OnClick(R.id.txt_contract)
    void onContract() {
        // TODO: 17/7/30 加入phoneNum
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 123123123));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    /**
     * 修改用户图像
     */
    @OnClick(R.id.img_circle_avatar)
    void onChangeAvatar() {
        new RxPermissions(getActivity()).request(Manifest.permission.READ_EXTERNAL_STORAGE
                , Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            new ImageSelectorUtils().singleLoadCustomImage(getContext())
                                    .selectImageInFragment(MineFragment.this);
                        } else {
                            ToastUtil.showToast("请确认权限后再选择图片");
                        }
                    }
                });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ImageSelector.IMAGE_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            // Get Image Path List
            List<String> pathList = data.getStringArrayListExtra(ImageSelectorActivity.EXTRA_RESULT);
            // TODO: 17/7/30 上传图像
            Glide.with(this).load(pathList.get(0)).error(R.mipmap.ic_launcher).into(avatarImg);
        } else {
            ToastUtil.showToast("逻辑有错误");
        }
    }
}
