package io.github.vzer.sharevegetable.lock;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import io.github.vzer.common.widget.recycler.RecyclerViewAdapter;
import io.github.vzer.sharevegetable.R;

/**
 * @author YangCihang
 * @since 17/8/9.
 * email yangcihang@hrsoft.net
 */

public class LockOrderVegetableAdapter extends RecyclerViewAdapter<String> {

    public LockOrderVegetableAdapter(Context context, List<String> strings) {
        super(context, strings);
    }

    @Override
    public ViewHolder<String> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_recview_lock_vegetable, parent, false);
        return new ItemHolder(view);
    }

    class ItemHolder extends ViewHolder<String> {
        @BindView(R.id.txt_lock_vegetable)
        TextView vegetableTxt;

        public ItemHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(String s) {
            vegetableTxt.setText(s);
        }
    }
}
