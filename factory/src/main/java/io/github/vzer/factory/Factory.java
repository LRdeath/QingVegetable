package io.github.vzer.factory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.github.vzer.common.app.Application;
import io.github.vzer.factory.persistence.Account;
import io.github.vzer.factory.utils.CacheUtil;

/**
 * @author: Vzer.
 * @date: 2017/7/25. 15:40
 * @email: vzer@qq.com
 */

public class Factory {

    private final Gson gson;
    private static Factory instance;//单例模式
    private static CacheUtil cacheUtil;
    private final ExecutorService executor;//全局线程池

    static {
        instance = new Factory();
    }

    /**
     * Factory的初始化
     */
    public static void setup() {
        // TODO: 2017/7/25  数据库的初始化
        //持久化数据初始化
        Account.load(getAppInstance());
    }

    public Factory() {
        // 新建一个4个线程的线程池
        executor =  Executors.newFixedThreadPool(4);
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
    public static Application getAppInstance() {
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

    /**
     * 缓存初始化
     */
    public static CacheUtil getCacheUtil() {
        if (cacheUtil == null) {
            cacheUtil = CacheUtil.get(getAppInstance().getFilesDir());
        }
        return cacheUtil;
    }

    /**
     * 异步运行的方法
     *
     * @param runnable Runnable
     */
    public static void runOnAsync(Runnable runnable){
        // 拿到单例，拿到线程池，然后异步执行
        instance.executor.execute(runnable);
    }
}
