package io.github.vzer.factory.data;

import android.text.TextUtils;
import android.util.Log;

import io.github.vzer.factory.Factory;
import io.github.vzer.factory.network.UploadHelper;
import io.github.vzer.factory.persistence.Account;
import io.github.vzer.factory.presenter.mine.MinePresenter;
import io.github.vzer.factory.utils.ToastUtil;

/**
 * @author YangCihang
 * @since 17/8/7.
 * email yangcihang@hrsoft.net
 */

public class MineHelper {

    /**
     * 修改用户图像
     */
    public static boolean updateAvatarRequest(final String uri, MinePresenter callback) {
        
        Factory.runOnAsync(new Runnable() {
            @Override
            public void run() {
                String url = UploadHelper.uploadPortrait(uri);//得到图片云端地址
                if (!TextUtils.isEmpty(url)){
                    Log.d("TAG",url);
                    Account.setPortrait(uri);
                    // TODO: 2017/8/14 头像url 上传给服务端
                }
            }
        });
        return true;
    }

    /**
     * 修改用户性别
     */
    public static boolean updateSexRequest(MinePresenter callback) {
        return true;

    }

    /**
     * 修改用户名
     */
    public static boolean updateUserNameRequest(MinePresenter callback) {
        return true;

    }

    /**
     * 修改用户真实姓名
     */
    public static boolean updateUserTrueNameRequest(MinePresenter callback) {
        return true;

    }
}
