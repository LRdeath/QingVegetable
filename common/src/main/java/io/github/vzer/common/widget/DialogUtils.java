package io.github.vzer.common.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatEditText;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import io.github.vzer.common.R;

import static io.github.vzer.common.widget.ScreenUtil.sp2px;

/**
 * @author YangCihang
 * @since 17/7/29.
 * email yangcihang@hrsoft.net
 */

public class DialogUtils {

    private Context mcontext;
    private TextView titleTxt = null;
    private TextView inputHintTxt = null;
    private AppCompatEditText inputEdit = null;
    private TextView hintTxt = null;
    private ProgressBar progressBar = null;
    private View customView;
    private boolean needNegativeButton = false;
    private boolean needPositiveButton = false;
    private boolean isCancelable = false;
    private LinearLayout layout;//Dialog总布局
    private LinearLayout.LayoutParams hintTextViewParams, editTextViewParams, hintInputTextViewParams, titleTextViewParams;
    private OnButtonListener onPositiveButtonListener;
    private OnButtonListener onNegativeButtonListener;

    public DialogUtils(Context context) {
        mcontext = context;
        layout = new LinearLayout(mcontext);
    }

    /**
     * 设置title
     */
    public DialogUtils setTitleText(String titleText) {
        titleTxt = new TextView(mcontext);
        titleTxt.setText(titleText);
        titleTxt.setGravity(Gravity.START);
        titleTextViewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                , ViewGroup.LayoutParams.WRAP_CONTENT);
        titleTxt.setTextColor(mcontext.getResources().getColor(R.color.text_primary));
        titleTxt.setGravity(Gravity.CENTER);
        titleTxt.setTextSize(mcontext.getResources().getInteger(R.integer.dialog_title_txt_size));
        return this;
    }

    public DialogUtils setInputHintText(String inputHintText) {
        inputHintTxt = new TextView(mcontext);
        inputHintTxt.setText(inputHintText);
        inputHintTxt.setTextColor(mcontext.getResources().getColor(R.color.text_secondary));
        inputHintTxt.setTextSize(mcontext.getResources().getInteger(R.integer.dialog_input_hint_txt_size));
        inputHintTxt.setGravity(Gravity.CENTER);
        hintInputTextViewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        return this;
    }

    public DialogUtils setInputEditView() {
        inputEdit = new AppCompatEditText(mcontext);
        editTextViewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        inputEdit.setGravity(Gravity.CENTER);
        editTextViewParams.setMargins(20, 0, 20, 0);
        return this;
    }

    public DialogUtils setCustomView(int resId, @NonNull OnViewListener listener) {
        customView = View.inflate(mcontext, resId, null);
        listener.onViewEventSetting(customView);
        return this;
    }
//    public DialogUtils setHintText(String hintText) {
//        hintTxt = new TextView(mcontext);
//        hintTxt.setText(hintText);
//        hintTxt.setTextColor(mcontext.getResources().getColor(R.color.text_secondary));
//        hintTextViewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT);
//        hintTxt.setTextSize(mcontext.getResources().getInteger(R.integer.dialog_hint_txt_size));
//        hintTxt.setGravity(Gravity.CENTER);
//        return this;
//    }

    public DialogUtils setProgressBar() {
        progressBar = new ProgressBar(mcontext);
        return this;
    }

    public DialogUtils setNegativeButton(OnButtonListener onNegativeButtonListener) {
        needNegativeButton = true;
        this.onNegativeButtonListener = onNegativeButtonListener;
        return this;
    }

    public DialogUtils setPositiveButton(OnButtonListener onButtonListener) {
        needPositiveButton = true;
        this.onPositiveButtonListener = onButtonListener;
        return this;
    }

    public String getInputText() {
        if (inputEdit != null) {
            return inputEdit.getText().toString().trim();
        } else {
            return null;
        }
    }

    public DialogUtils setCancelable(boolean isCancelable) {
        this.isCancelable = isCancelable;
        return this;
    }

    public DialogUtils showDialog() {
        int marginLeft = sp2px(mcontext.getResources().getInteger(R.integer.dialog_margin_abroad));
        int marginTop = sp2px(mcontext.getResources().getInteger(R.integer.dialog_margin_top));
        int marginRight = sp2px(mcontext.getResources().getInteger(R.integer.dialog_margin_abroad));
        layout.setPadding(marginLeft, marginTop, marginRight, 0);
        layout.setOrientation(LinearLayout.VERTICAL); //设置布局走向
        if (titleTxt != null) {
            layout.addView(titleTxt, titleTextViewParams);
        }
        if (inputHintTxt != null) {
            layout.addView(inputHintTxt, hintInputTextViewParams);
        }
        if (inputEdit != null) {
            layout.addView(inputEdit);
        }
        if (hintTxt != null) {
            layout.addView(hintTxt, hintTextViewParams);
        }
        if (customView != null) {
            layout.addView(customView);
        }
        if (progressBar != null) {
            layout.addView(progressBar);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(mcontext);
        builder.setView(layout);
        if (needPositiveButton) {
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (onPositiveButtonListener != null) {
                        onPositiveButtonListener.onButtonClicked(DialogUtils.this);
                    }
                }
            });
        }
        if (needNegativeButton) {
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (onNegativeButtonListener != null) {
                        onNegativeButtonListener.onButtonClicked(DialogUtils.this);
                    }
                }
            });
        }
        if (isCancelable) {
            builder.setCancelable(true);
        } else {
            builder.setCancelable(false);
        }
        AlertDialog dialog = builder.create();
        dialog.show();
        if (needNegativeButton) {
            Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
            negativeButton.setTextColor(mcontext.getResources().getColor(R.color.text_primary));
            negativeButton.setTextSize(mcontext.getResources().getInteger(R.integer.dialog_button_txt_size));
        }
        if (needPositiveButton) {
            Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            positiveButton.setTextColor(mcontext.getResources().getColor(R.color.text_primary));
            positiveButton.setTextSize(mcontext.getResources().getInteger(R.integer.dialog_button_txt_size));
        }
        return this;
    }


    public interface OnButtonListener {
        void onButtonClicked(DialogUtils dialogUtils);
    }

    public interface OnViewListener {
        void onViewEventSetting(View view);
    }
}
