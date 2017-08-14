package io.github.vzer.sharevegetable.mine.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.github.vzer.common.widget.RecyclerViewAdapter;
import io.github.vzer.factory.model.db.User;
import io.github.vzer.factory.model.mine.LocationModel;
import io.github.vzer.sharevegetable.R;

/**
 * 展示用户存储的地址
 *
 * @author YangCihang
 * @since 17/8/14.
 * email yangcihang@hrsoft.net
 */

public class UserLocationAdapter extends RecyclerViewAdapter<LocationModel> {


    public UserLocationAdapter(Context context, List<LocationModel> locationModels) {
        super(context, locationModels);
    }

    @Override
    public ViewHolder<LocationModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_recview_user_location, parent, false);
        return new ItemHolder(view);
    }

    class ItemHolder extends ViewHolder<LocationModel> {

        public ItemHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(LocationModel locationModel) {

        }
    }
}
