package io.github.vzer.sharevegetable.mine.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.github.vzer.common.widget.RecyclerViewAdapter;

/**
 * 选择地址的adapter
 *
 * @author YangCihang
 * @since 17/8/14.
 * email yangcihang@hrsoft.net
 */

public class LocationAdapter extends RecyclerViewAdapter<String> {
    public LocationAdapter(Context context, List<String> strings) {
        super(context, strings);
    }

    @Override
    public ViewHolder<String> onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    class ItemHolder extends ViewHolder<String> {

        public ItemHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(String s) {

        }
    }
}
