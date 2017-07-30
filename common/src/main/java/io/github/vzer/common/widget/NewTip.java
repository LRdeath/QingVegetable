package io.github.vzer.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import io.github.vzer.common.R;

import static android.view.Gravity.CENTER;

/**
 * @author YangCihang
 * @since 17/7/29.
 * email yangcihang@hrsoft.net
 */

public class NewTip extends TextView {

    public NewTip(Context context) {
        super(context);
    }

    public NewTip(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NewTip(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setNewTipCount(int count) {
        count = count < 1 ? 1 : count;
        String text = count > 99 ? "99+" : String.valueOf(count);
        setText(text);
        setGravity(CENTER);
        setTextColor(getResources().getColor(R.color.color_white));
        setBackground(getResources().getDrawable(R.drawable.bg_shape_new_tip_red_solid_ring));
    }


}
