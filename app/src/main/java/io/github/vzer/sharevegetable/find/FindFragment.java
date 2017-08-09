package io.github.vzer.sharevegetable.find;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.github.vzer.common.app.FragmentPresenter;
import io.github.vzer.factory.model.find.FindModel;
import io.github.vzer.factory.presenter.find.FindContract;
import io.github.vzer.factory.presenter.find.FindPresenter;
import io.github.vzer.sharevegetable.R;

/**
 * @author YangCihang
 * @since 17/7/27.
 * email yangcihang@hrsoft.net
 */

public class FindFragment extends FragmentPresenter<FindContract.Presenter> implements FindContract.View {
    @BindView(R.id.find_rec)
    RecyclerView findRec;

    List<FindModel> list = new ArrayList<>();
    @Override
    public void showLoading() {

    }

    @Override
    protected FindContract.Presenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        FindAdapter adapter = new FindAdapter(getContext(), list);
        findRec.setLayoutManager(new LinearLayoutManager(getContext()));
        findRec.setAdapter(adapter);
    }

    @Override
    protected void initWidget(View root) {
        FindModel findModel = new FindModel();
        findModel.setTitle("蔬菜秘密知多少，十个你不知道的小知识");
        findModel.setContentUri("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1502295554843&di=a58cec9134aca2167844a79f866de7de&imgtype=0&src=http%3A%2F%2Fwww.hi.chinanews.com.cn%2Fpdcontent%2F2014-03-31%2FU63P16T8D18686F211DT20140331092345.jpg");
        list.add(findModel);
        findModel = new FindModel();
        findModel.setTitle("怎样挑选新鲜蔬菜？进来看看吧");
        findModel.setContentUri("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1502295622172&di=da2632cd53053c4f2550f58df5bb760c&imgtype=0&src=http%3A%2F%2Fimg.juimg.com%2Ftuku%2Fyulantu%2F140331%2F330480-14033111014943.jpg");
        list.add(findModel);

    }

    @Override
    protected void initArgs(Bundle arguments) {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_find;
    }
}
