package io.github.vzer.sharevegetable.mine;

import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import butterknife.BindView;
import io.github.vzer.common.app.ToolbarActivity;
import io.github.vzer.common.factory.presenter.BasePresenter;
import io.github.vzer.factory.utils.ToastUtil;
import io.github.vzer.factory.utils.Utility;
import io.github.vzer.factory.utils.division.DivisionJson;
import io.github.vzer.factory.utils.division.DivisionModel;
import io.github.vzer.sharevegetable.R;

/**
 * @author YangCihang
 * @since 17/8/14.
 * email yangcihang@hrsoft.net
 */

public class LocationSelectActivity extends ToolbarActivity {
    @BindView(R.id.rec_location_select)
    RecyclerView locationSelectRec;

    @Override
    protected void initWidget() {
        setActivityTitle("选择地址");
    }

    @Override
    protected void initData() {
        Utility.runOnNewThread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                DivisionModel model = gson.fromJson(DivisionJson.DIVISION_JSON, DivisionModel.class);
                ToastUtil.showToast("123");
            }
        });

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_location_select;
    }
}
