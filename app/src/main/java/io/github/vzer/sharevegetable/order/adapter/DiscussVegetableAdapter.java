package io.github.vzer.sharevegetable.order.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.github.vzer.common.widget.RecyclerViewAdapter;
import io.github.vzer.factory.model.order.DiscussVegetableModel;
import io.github.vzer.sharevegetable.R;

/**
 * @author YangCihang
 * @since 17/8/4.
 * email yangcihang@hrsoft.net
 */

public class DiscussVegetableAdapter extends RecyclerViewAdapter<DiscussVegetableModel> {
    public DiscussVegetableAdapter(Context context, List<DiscussVegetableModel> discussVegetableModels) {
        super(context, discussVegetableModels);
    }

    @Override
    public ViewHolder<DiscussVegetableModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_rec_discuss, parent, false);
        return new ItemHolder(view);
    }

    public class ItemHolder extends ViewHolder<DiscussVegetableModel> {

        public ItemHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(DiscussVegetableModel discussVegetableModel) {

        }
    }
}
