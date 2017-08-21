package io.github.vzer.sharevegetable.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lljjcoder.citypickerview.widget.CityPicker;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.vzer.common.app.ToolbarActivityPresenter;
import io.github.vzer.factory.constant.KeyConstant;
import io.github.vzer.factory.presenter.mine.LocationContract;
import io.github.vzer.factory.presenter.mine.LocationPresenter;
import io.github.vzer.factory.utils.ToastUtil;
import io.github.vzer.sharevegetable.R;

/**
 * @author YangCihang
 * @since 17/8/14.
 * email yangcihang@hrsoft.net
 */

public class LocationDetailActivity extends ToolbarActivityPresenter<LocationContract.Presenter>
        implements LocationContract.View {
    public static int CHANGE_LOCATION = 1;
    public static int ADD_LOCATION = 2;
    private int type; //type，是修改地址还是添加地址
    @BindView(R.id.ly_location)
    RelativeLayout locationLy;
    @BindView(R.id.edit_location_receiver)
    EditText receiverEdit;
    @BindView(R.id.edit_phone_num)
    EditText phoneNumEdit;
    @BindView(R.id.txt_location)
    TextView locationTxt;
    @BindView(R.id.edit_detail_location)
    EditText detailLocationEdit;
    @BindView(R.id.txt_delete_location)
    TextView deleteTxt;
    @BindView(R.id.txt_location_save)
    TextView saveLoacationTxt;

    public static void start(Context context, int type) {
        Intent intent = new Intent(context, LocationDetailActivity.class);
        intent.putExtra(KeyConstant.KEY_START_LOCATION_TYPE, type);
        context.startActivity(intent);
    }

    @Override
    public void showError(int strId) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public LocationContract.Presenter initPresenter() {
        return new LocationPresenter(this);
    }

    @Override
    protected void initWidget() {
        if (type == CHANGE_LOCATION) {
            setActivityTitle("修改地址");
            deleteTxt.setVisibility(View.VISIBLE);
            // TODO: 17/8/14 添加用户信息
        } else if (type == ADD_LOCATION) {
            setActivityTitle("添加地址");
            deleteTxt.setVisibility(View.GONE);
        } else {
            ToastUtil.showToast(R.string.toast_logic_error);
        }
    }

    @Override
    protected void initData() {
        type = getIntent().getIntExtra(KeyConstant.KEY_START_LOCATION_TYPE, -1);

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_location_datail;
    }

    /**
     * 点击选择地址
     */
    @OnClick(R.id.ly_location)
    void onSelectLocation() {
//        Intent intent = new Intent(this, CityListSelectActivity.class);
//        startActivityForResult(intent, CityListSelectActivity.CITY_SELECT_RESULT_FRAG);
        CityPicker cityPicker = new CityPicker.Builder(this)
                .textSize(20)
                .title("地址选择")
                .backgroundPop(0xa0000000)
                .titleBackgroundColor("#45c24c")
                .titleTextColor("#000000")
                .backgroundPop(0xa0000000)
                .confirTextColor("#000000")
                .cancelTextColor("#000000")
                .province("河北省")
                .city("秦皇岛市")
                .district("海港区")
                .textColor(Color.parseColor("#000000"))
                .provinceCyclic(true)
                .cityCyclic(false)
                .districtCyclic(false)
                .visibleItemsCount(7)
                .itemPadding(10)
                .onlyShowProvinceAndCity(false)
                .build();
        cityPicker.show();

        //监听方法，获取选择结果
        cityPicker.setOnCityItemClickListener(new CityPicker.OnCityItemClickListener() {
            @Override
            public void onSelected(String... citySelected) {
                //省份
                String province = citySelected[0];
                //城市
                String city = citySelected[1];
                //区县（如果设定了两级联动，那么该项返回空）
                String district = citySelected[2];
                //邮编
                String code = citySelected[3];
                String result = province + city + district;
                locationTxt.setText(result);
            }

            @Override
            public void onCancel() {
                ToastUtil.showToast("已取消");
            }
        });
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == CityListSelectActivity.CITY_SELECT_RESULT_FRAG) {
//            if (resultCode == RESULT_OK) {
//                if (data == null) {
//                    return;
//                }
//                Bundle bundle = data.getExtras();
//
//                CityInfoBean cityInfoBean = (CityInfoBean) bundle.getParcelable("cityinfo");
//
//                if (null == cityInfoBean)
//                    return;
//
//                //城市名称
//                String cityName = cityInfoBean.getName();
//                //纬度
//                String latitude = cityInfoBean.getLongitude();
//                //经度
//                String longitude = cityInfoBean.getLatitude();
//
//            }
//        }
//    }

    /**
     * 点击删除
     */
    @OnClick(R.id.txt_delete_location)
    void onDeleteLocation() {
        // TODO: 17/8/14  删除已有地址
    }

    /**
     * 点击确定
     */
    @OnClick(R.id.txt_location_save)
    void onSaveLocation() {
        // TODO: 17/8/14 根据不同类型做不同的操作 
    }
}
