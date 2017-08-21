package io.github.vzer.sharevegetable.find;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import io.github.vzer.common.widget.recycler.RecyclerViewAdapter;
import io.github.vzer.factory.model.find.FindModel;
import io.github.vzer.sharevegetable.R;

/**
 * @author: Vzer.
 * @date: 2017/8/9. 21:20
 * @email: vzer@qq.com
 */

public class FindAdapter extends RecyclerViewAdapter<FindModel> {
    public FindAdapter(Context context, List<FindModel> findModels) {
        super(context, findModels);
    }

    @Override
    public ViewHolder<FindModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FindViewHolder(inflater.inflate(R.layout.item_recview_find, parent, false));
    }

    class FindViewHolder extends ViewHolder<FindModel> {

        @BindView(R.id.find_rec_title)
        TextView titleTxt;
        @BindView(R.id.find_rec_imge)
        ImageView contentImage;

        public FindViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(FindModel findModel) {
            titleTxt.setText(findModel.getTitle());
            Glide.with(context)
                    .load(findModel.getContentUri())
                    .centerCrop()
                    .placeholder(R.drawable.ic_default)
                    .into(contentImage);
        }
    }
}
