package io.github.vzer.factory.network;

import android.text.format.DateFormat;
import android.util.Log;

import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.model.GetObjectRequest;
import com.alibaba.sdk.android.oss.model.GetObjectResult;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;

import java.io.File;
import java.util.Date;

import io.github.vzer.factory.Factory;
import io.github.vzer.factory.utils.HashUtil;

/**
 * 上传工具类，主要用于上传用户头像到阿里OSS存储
 *
 * @author: Vzer.
 * @date: 2017/8/14. 17:12
 * @email: vzer@qq.com
 */

public class UploadHelper {
    private static final String ENDPOINT = "http://oss-cn-qingdao.aliyuncs.com";  //存储区域
    private static final String BUCKET_NAME = "qin-vegetable"; //上传的仓库名

    private static OSS getClient() {
        OSSCredentialProvider credentialProvider = new OSSPlainTextAKSKCredentialProvider("LTAIGoUrzfDKhdjz",
                "Ce8M1rs61mZdXNRi5KcWr4QsfxK0h0");
        return new OSSClient(Factory.getAppInstance(), ENDPOINT, credentialProvider);
    }

    /**
     * 上传的最终方法， 成功返回则返回一个路径
     *
     * @param objKey 文件在服务器上的独立的key
     * @param path   需要上传文件的地址
     * @return 存储地址
     */
    private static String upload(String objKey, String path) {
        // 构造一个上传请求
        PutObjectRequest request = new PutObjectRequest(BUCKET_NAME, objKey, path);

        try {
            // 初始化上传的Client
            OSS client = getClient();
            // 开始同步上传
            PutObjectResult result = client.putObject(request);
            // 得到一个外网可访问的地址
            String url = client.presignPublicObjectURL(BUCKET_NAME, objKey);
            // 格式打印输出
            Log.d("TAG", String.format("PublicObjectURL:%s", url));
            return url;
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("TAG", e.getMessage());
            // 如果有异常则返回空
            return null;
        }
    }

    /**
     * 上传头像
     *
     * @param path 本地地址
     * @return 服务器地址
     */
    public static String uploadPortrait(String path) {
        //获取文件格式化后的地址
        String key = getObjKey(path);
        return upload(key, path);
    }

    /**
     * 格式化文件地址
     *
     * @param path 文件本地地址
     * @return 服务器地址
     */
    private static String getObjKey(String path) {
        //分月存储
        String date = DateFormat.format("yyyyMM", new Date()).toString();
        //当前文件的MD5的key
         String fileMD5 = HashUtil.getMD5String(new File(path));
        return String.format("portrait/%s/%s.jpg", date, fileMD5);
    }
}
