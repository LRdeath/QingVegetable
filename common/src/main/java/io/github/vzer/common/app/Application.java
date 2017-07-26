package io.github.vzer.common.app;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * Application类
 *
 * @author: Vzer.
 * @date: 2017/7/25.
 * @email: vzer@qq.com
 */

public class Application extends android.app.Application {

    private static Application instance;//实例对象
    private static List<Activity> activityList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    /**
     * 外部获取实例对象
     *
     * @return Application
     */
    public static Application getInstance() {
        return instance;
    }

    private static ActivityLifecycleCallbacks activityLifecycleCallbacks = new ActivityLifecycleCallbacks() {

        @Override
        public void onActivityCreated(Activity activity, Bundle bundle) {
            activityList.add(activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            activityList.remove(activity);
        }
    };

    /**
     * 移除Activity
     *
     * @param activity
     */
    public static void removeActivity(Activity activity) {
        activityList.remove(activity);
    }

    /**
     *清除所有Activity
     */
    public static void removeAllActivity() {
        activityList.clear();
    }

    /**
     * 退出应用
     */
    public static void exitApp() {
        removeAllActivity();
        // TODO: 2017/7/25 退出的后续操作
    }

    /**
     * 退出账户
     */
    public static void exitAccount() {
        removeAllActivity();
        // TODO: 2017/7/25 到登陆界面 ,清理缓存
    }

}