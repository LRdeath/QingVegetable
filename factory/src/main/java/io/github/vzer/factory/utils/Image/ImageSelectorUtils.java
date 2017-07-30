package io.github.vzer.factory.utils.Image;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.yancy.imageselector.ImageConfig;
import com.yancy.imageselector.ImageSelector;

import io.github.vzer.factory.R;

/**
 * 图片选择工具类
 *
 * @author YangCihang
 * @since 17/7/30.
 * email yangcihang@hrsoft.net
 */

public class ImageSelectorUtils {

    private ImageConfig imageConfig;

    public ImageSelectorUtils singleLoadCustomImage(Context context) {
        imageConfig
                = new ImageConfig.Builder(new GlideLoader())
                .steepToolBarColor(context.getResources().getColor(R.color.blue))
                .titleBgColor(context.getResources().getColor(R.color.blue))
                .titleSubmitTextColor(context.getResources().getColor(R.color.white))
                .titleTextColor(context.getResources().getColor(R.color.white))
                // (截图默认配置：关闭    比例 1：1    输出分辨率  500*500)
                .crop(1, 1, 500, 500)
                // 开启单选   （默认为多选）
                .singleSelect()
                // 开启拍照功能 （默认关闭）
                .showCamera()
                // 拍照后存放的图片路径（默认 /temp/picture） （会自动创建）
                //.filePath("/ImageSelectorUtils/Pictures")
                .build();
        return this;
    }

    public void selectImageInFragment(Fragment fragment) {
        ImageSelector.open(fragment, imageConfig);
    }

    public void selectImageInActivity(Activity activity) {
        ImageSelector.open(activity, imageConfig);
    }

}
