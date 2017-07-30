package io.github.vzer.factory.utils.Image;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yancy.imageselector.ImageLoader;

/**
 * @author YangCihang
 * @since 17/7/30.
 * email yangcihang@hrsoft.net
 */

public class GlideLoader implements ImageLoader {
    @Override
    public void displayImage(Context context, String path, ImageView imageView) {
        Glide.with(context)
                .load(path)
                .placeholder(com.yancy.imageselector.R.mipmap.imageselector_photo)
                .centerCrop()
                .into(imageView);
    }
}
