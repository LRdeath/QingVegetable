package io.github.vzer.sharevegetable.mine;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.vzer.common.app.ToolbarActivityPresenter;
import io.github.vzer.common.widget.RecyclerViewAdapter;
import io.github.vzer.factory.model.mine.LocationModel;
import io.github.vzer.factory.presenter.mine.LocationContract;
import io.github.vzer.factory.presenter.mine.LocationPresenter;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.mine.adapter.UserLocationAdapter;

/**
 * @author YangCihang
 * @since 17/8/14.
 * email yangcihang@hrsoft.net
 */

public class LocationActivity extends ToolbarActivityPresenter<LocationContract.Presenter>
        implements LocationContract.View {
    @BindView(R.id.txt_add_location)
    TextView addLocationTxt;
    @BindView(R.id.rec_user_location)
    RecyclerView userLocationRec;
    @BindView(R.id.ly_location_bottom)
    RelativeLayout bottomLy;
    UserLocationAdapter adapter;

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
    protected void initData() {
        List<LocationModel> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new LocationModel());
        }
        adapter = new UserLocationAdapter(this, list);
        userLocationRec.setAdapter(adapter);
        userLocationRec.setLayoutManager(new LinearLayoutManager(this));
        adapter.setOnItemClickedListener(new RecyclerViewAdapter.OnItemClicked<LocationModel>() {
            @Override
            public void onItemClicked(LocationModel locationModel, RecyclerViewAdapter.ViewHolder holder) {
                LocationDetailActivity.start(LocationActivity.this,
                        LocationDetailActivity.CHANGE_LOCATION);
            }
        });
    }

    @Override
    public void initWidget() {
        setActivityTitle("收货地址");
    }

    @Override
    protected void initWindows() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_location;
    }

    /**
     * 点击新增收货地址
     */
    @OnClick(R.id.ly_location_bottom)
    void addLocation() {
        LocationDetailActivity.start(this, LocationDetailActivity.ADD_LOCATION);
    }
}
