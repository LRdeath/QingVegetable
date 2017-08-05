package io.github.vzer.sharevegetable.order.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.vzer.common.widget.RecyclerViewAdapter;
import io.github.vzer.factory.model.order.DiscussVegetableModel;
import io.github.vzer.factory.utils.ToastUtil;
import io.github.vzer.sharevegetable.R;

import static io.github.vzer.factory.model.order.DiscussVegetableModel.STATE_DISSATISFIED;
import static io.github.vzer.factory.model.order.DiscussVegetableModel.STATE_SATISFIED;
import static io.github.vzer.factory.model.order.DiscussVegetableModel.STATE_UNSELECTED;

/**
 * @author YangCihang
 * @since 17/8/4.
 * email yangcihang@hrsoft.net
 */

public class DiscussVegetableAdapter extends RecyclerViewAdapter<DiscussVegetableModel> {
    private List<Integer> flagList;
    private List<String> contentList;

    public DiscussVegetableAdapter(Context context, List<DiscussVegetableModel> discussVegetableModels) {
        super(context, discussVegetableModels);
        flagList = new ArrayList<>();
        contentList = new ArrayList<>();
        for (int i = 0; i < getListData().size(); i++) {
            flagList.add(STATE_UNSELECTED);
            contentList.add("");
        }
    }

    @Override
    public ViewHolder<DiscussVegetableModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_rec_discuss, parent, false);
        return new ItemHolder(view);
    }

    public class ItemHolder extends ViewHolder<DiscussVegetableModel> {
        @BindView(R.id.txt_vegetable_name)
        TextView nameTxt;
        @BindView(R.id.img_satisfied)
        ImageView satisfiedImg;
        @BindView(R.id.img_dissatisfied)
        ImageView dissatisfiedImg;
        @BindView(R.id.edit_describe)
        EditText describeEdit;
        private int position;
        DiscussVegetableModel model;

        public ItemHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(DiscussVegetableModel discussVegetableModel) {
            position = getAdapterPosition();
            model = getListData().get(position);
            //避免img内容错乱
            switch (flagList.get(position)) {
                case STATE_UNSELECTED:
                    satisfiedImg.setSelected(false);
                    dissatisfiedImg.setSelected(false);
                    break;
                case STATE_SATISFIED:
                    satisfiedImg.setSelected(true);
                    dissatisfiedImg.setSelected(false);
                    break;
                case STATE_DISSATISFIED:
                    satisfiedImg.setSelected(false);
                    dissatisfiedImg.setSelected(true);
                    break;
                default:
                    ToastUtil.showToast(R.string.toast_logic_error);
            }
            describeEdit.addTextChangedListener(textWatcher);
            //避免editText内容错乱
            if (model.getContent() == null || model.getContent().isEmpty()) {
                describeEdit.setHint(R.string.hint_describe);
                describeEdit.setText(null);
            } else {
                describeEdit.setText(contentList.get(position));
            }
        }

        @OnClick(R.id.img_satisfied)
        void onSatisfiedClicked() {
            flagList.set(position, STATE_SATISFIED);
            model.setSatisfation(STATE_SATISFIED);
            setModelAndRefresh();
        }

        @OnClick(R.id.img_dissatisfied)
        void onDissatisfiedClicked() {
            flagList.set(position, STATE_DISSATISFIED);
            model.setSatisfation(STATE_DISSATISFIED);
            setModelAndRefresh();
        }

        private void setModelAndRefresh() {
            getListData().set(position, model);
            refresh();
        }

        private TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String content = describeEdit.getText().toString().trim();
                contentList.set(position, content);
                model.setContent(content);
                getListData().set(position, model);
            }
        };
    }
}
