package io.github.vzer.sharevegetable.mine.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import io.github.vzer.common.widget.recycler.RecyclerFooterAdapter;
import io.github.vzer.factory.model.mine.wallet.UserWalletOrderModel;
import io.github.vzer.sharevegetable.R;

import static android.view.View.GONE;

/**
 * @author YangCihang
 * @since 17/8/21.
 * email yangcihang@hrsoft.net
 */

public class WalletOrderAdapter extends RecyclerFooterAdapter<UserWalletOrderModel> {
    private FooterItemHolder footerHolder;

    public WalletOrderAdapter(Context context, List<UserWalletOrderModel> userWalletOrderModels) {
        super(context, userWalletOrderModels);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == DATA_ITEM) {
            view = inflater.inflate(R.layout.item_wallet_order, parent, false);
            return new ItemHolder(view);
        } else {
            view = inflater.inflate(R.layout.view_rec_footer, parent, false);
            footerHolder = new FooterItemHolder(view);
            return footerHolder;
        }
    }

    class ItemHolder extends ViewHolder<UserWalletOrderModel> {
        public ItemHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(UserWalletOrderModel userWalletOrderModel) {

        }
    }

    class FooterItemHolder extends FooterHolder {
        @BindView(R.id.txt_load_more)
        TextView loadTxt;
        @BindView(R.id.progress_footer)
        ProgressBar footerProgress;

        public FooterItemHolder(View itemView) {
            super(itemView);
        }
    }

    public void setToRefresh(boolean toRefresh) {
        if (footerHolder != null) {
            if (toRefresh) {
                footerHolder.footerProgress.setVisibility(View.VISIBLE);
                footerHolder.loadTxt.setText("正在加载");
            } else {
                footerHolder.footerProgress.setVisibility(GONE);
                footerHolder.loadTxt.setText("已经加载完啦");
            }
        }

    }
}
