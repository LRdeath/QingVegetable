package io.github.vzer.factory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.github.vzer.common.app.Application;

/**
 * @author: Vzer.
 * @date: 2017/7/25. 15:40
 * @email: vzer@qq.com
 */

public class Factory {

    private final Gson gson;
    private static Factory instance;//单例模式

    static {
        instance = new Factory();
    }

    /**
     * Factory的初始化
     */
    public static void setup() {
        // TODO: 2017/7/25  数据库的初始化
    }

    public Factory() {

        //初始化Gson格式
        gson = new GsonBuilder()
                //设置时间格式
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
                .create();
    }

    /**
     * 得到全局Application
     *
     * @return
     */
    public static Application app() {
        return Application.getInstance();
    }

    /**
     * 返回全局的Gson,这里可以对Gson进行一些初始化
     *
     * @return Gson
     */
    public static Gson getGson() {
        return instance.gson;
    }
}
