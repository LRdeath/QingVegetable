package io.github.vzer.sharevegetable.mine.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lwkandroid.imagepicker.ImagePicker;
import com.lwkandroid.imagepicker.data.ImageBean;
import com.lwkandroid.imagepicker.data.ImagePickType;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import io.github.vzer.common.app.Application;
import io.github.vzer.common.app.ToolbarActivityPresenter;
import io.github.vzer.common.widget.DialogUtils;
import io.github.vzer.factory.persistence.Account;
import io.github.vzer.factory.presenter.mine.MineContract;
import io.github.vzer.factory.presenter.mine.MinePresenter;
import io.github.vzer.factory.utils.ToastUtil;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.widget.ImageDisplayer;
import io.reactivex.functions.Consumer;

/**
 * 用户详情
 *
 * @author YangCihang
 * @since 17/8/10.
 * email yangcihang@hrsoft.net
 */

public class UserDetailActivity extends ToolbarActivityPresenter<MineContract.Presenter>
        implements MineContract.View {
    @BindView(R.id.txt_user_name)
    TextView userNameTxt;
    @BindView(R.id.txt_true_name)
    TextView trueNameTxt;
    @BindView(R.id.txt_sex)
    TextView sexTxt;
    @BindView(R.id.ly_user_name)
    RelativeLayout userNameLy;
    @BindView(R.id.ly_true_name)
    RelativeLayout trueNameLy;
    @BindView(R.id.ly_sex)
    RelativeLayout sexLy;
    @BindView(R.id.ly_user_avatar)
    RelativeLayout avatarLy;
    @BindView(R.id.img_user_avatar)
    CircleImageView avatarImg;
    private static final int REQUEST_CODE = 0;

    @Override

    public void showError(int strId) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public MineContract.Presenter initPresenter() {
        return new MinePresenter(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initWidget() {
        setActivityTitle("用户详情");
        String url = Account.getPortrait();
        Glide.with(this)
                .load(url)
                .centerCrop()
                .into(avatarImg);
    }

    @Override
    protected void initWindows() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_user_detail;
    }

    /**
     * 修改用户图像
     */
    @SuppressLint("InlinedApi")
    @OnClick(R.id.ly_user_avatar)
    void changeUserAvatar() {
        new RxPermissions(this).request(Manifest.permission.READ_EXTERNAL_STORAGE
                , Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) {
//                            new ImageSelectorUtils().singleLoadCustomImage(UserDetailActivity.this)
//                                    .selectImageInActivity(UserDetailActivity.this);
                            new ImagePicker()
                                    .pickType(ImagePickType.SINGLE) //设置选取类型(拍照ONLY_CAMERA、单选SINGLE、多选MUTIL)
                                    .maxNum(9) //设置最大选择数量(此选项只对多选生效，拍照和单选都是1，修改后也无效)
                                    .needCamera(true) //是否需要在界面中显示相机入口
                                    .cachePath(Application.getInstance().getCachePath()) //自定义缓存路径(拍照和裁剪都需要用到缓存)
                                    .doCrop(1, 1, 500, 500) //裁剪功能需要调用这个方法，多选模式下无效
                                    .displayer(new ImageDisplayer()) //自定义图片加载器，默认是Glide实现的,可自定义图片加载器
                                    .start(UserDetailActivity.this, REQUEST_CODE); //自定义RequestCode
                        } else {
                            ToastUtil.showToast("请确认权限后再选择图片");
                        }
                    }
                });
    }

    /**
     * 修改用户名
     */
    @OnClick(R.id.ly_user_name)
    void changeUserName() {
        new DialogUtils(this)
                .setCancelable(false)
                .setInputEditView()
                .setNegativeButton(null)
                .setTitleText("修改用户姓名")
                .setPositiveButton(new DialogUtils.OnButtonListener() {
                    @Override
                    public void onButtonClicked(DialogUtils dialogUtils) {
                        if (mPresenter.changeUserName(dialogUtils.getInputText())) {
                            ToastUtil.showToast(R.string.toast_change_success);
                            userNameTxt.setText(dialogUtils.getInputText());
                        }
                    }
                })
                .showDialog();
    }

    /**
     * 改变真实姓名
     */
    @OnClick(R.id.ly_true_name)
    void changeTrueName() {
        new DialogUtils(this)
                .setCancelable(false)
                .setInputEditView()
                .setNegativeButton(null)
                .setTitleText("修改真实姓名")
                .setPositiveButton(new DialogUtils.OnButtonListener() {
                    @Override
                    public void onButtonClicked(DialogUtils dialogUtils) {
                        if (mPresenter.changeTrueName(dialogUtils.getInputText())) {
                            ToastUtil.showToast(R.string.toast_change_success);
                            trueNameTxt.setText(dialogUtils.getInputText());
                        }
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
        new DialogUtils(this)
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
                                        ToastUtil.showToast(getResources().getString(R.string.toast_logic_error));
                                        break;
                                }
                            }
                        });
                    }
                })
                .setPositiveButton(new DialogUtils.OnButtonListener() {
                    @Override
                    public void onButtonClicked(DialogUtils dialogUtils) {
                        if (mPresenter.changeSex(sex[0])) {
                            ToastUtil.showToast(R.string.toast_change_success);
                            // TODO: 17/8/7  修改sexTxt
                        }
                        ToastUtil.showToast("已选择性别");
                    }
                })
                .showDialog();
    }

    /**
     * 选择图片后的处理
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            // Get Image Path List
            List<ImageBean> resultList = data.getParcelableArrayListExtra(ImagePicker.INTENT_RESULT_DATA);
            String imagePath = resultList.get(0).getImagePath();
            // TODO: 17/7/30 上传图像
            //ToastUtil.showToast(pathList.get(0));
            if (!TextUtils.isEmpty(imagePath)) {
                if (mPresenter.changeAvatar(imagePath)) {
                    Glide.with(this).load(imagePath).error(R.mipmap.ic_launcher_round).into(avatarImg);
                } else {
                    ToastUtil.showToast(R.string.toast_avatar_load_error);
                }
            } else {
                ToastUtil.showToast(R.string.toast_avatar_load_error);
            }

        }
    }

}
