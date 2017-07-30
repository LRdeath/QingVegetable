package io.github.vzer.sharevegetable.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.vzer.common.app.FragmentPresenter;
import io.github.vzer.common.widget.DialogUtils;
import io.github.vzer.factory.presenter.mine.MineContract;
import io.github.vzer.factory.presenter.mine.MinePresenter;
import io.github.vzer.factory.utils.ToastUtil;
import io.github.vzer.sharevegetable.R;

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

    @OnClick(R.id.ly_mobile)
    void changeMobile() {
        ToastUtil.showToast("点击了手机号");
    }

    @OnClick(R.id.txt_logout)
    void onGoLogin() {
        mPresenter.goLogin();
    }
}
