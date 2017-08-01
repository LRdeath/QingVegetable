package io.github.vzer.sharevegetable.vegetable;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;
import io.github.vzer.common.app.FragmentPresenter;
import io.github.vzer.common.widget.RecyclerViewAdapter;
import io.github.vzer.factory.model.vegetable.VegetableModel;
import io.github.vzer.factory.presenter.vegetable.VegetableContract;
import io.github.vzer.sharevegetable.R;

/**
 * @author YangCihang
 * @since 17/7/27.
 * email yangcihang@hrsoft.net
 */

public class VegetableFragment extends FragmentPresenter<VegetableContract.Presenter>implements VegetableContract.View{
    @BindView(R.id.rcview_vegetable)
    RecyclerView rcviewVegetable;

    @Override
    public void showLoading() {
    }

    @Override
    protected VegetableContract.Presenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initWidget(View root) {
        rcviewVegetable.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected void initArgs(Bundle arguments) {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_vegetable;
    }

    class VegetableViewHolder extends RecyclerViewAdapter.ViewHolder<VegetableModel>{

        public VegetableViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(VegetableModel vegetableModel) {

        }
    }
}
