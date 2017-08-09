package io.github.vzer.sharevegetable;

import com.igexin.sdk.PushManager;

import io.github.vzer.common.app.Application;
import io.github.vzer.factory.Factory;
import io.github.vzer.sharevegetable.service.AppIntentService;
import io.github.vzer.sharevegetable.service.PushService;

/**
 * @author: Vzer.
 * @date: 2017/7/25. 21:37
 * @email: vzer@qq.com
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //对Factory进行初始化
        Factory.setup();
        // 初始化推送服务，接口调用后个推服务后台运行，联网成功后，通过广播或者IntentService回调接口返回 CID 信息
        PushManager.getInstance().initialize(this, PushService.class);
        //注册消息接收 IntentService，个推服务联网成功后，通过该注册的 Service 返回 CID、 在线状态、透传数据等信息。
        // 建议在initialize方法调用后，立即通过registerPushIntentService方法注册自定义IntentService。
        //如果调用了registerPushIntentService方法注册自定义IntentService，则SDK仅通过IntentService回调推送服务事件；
        //如果未调用registerPushIntentService方法进行注册，则原有的广播接收器仍然可以继续使用。
        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), AppIntentService.class);
    }
}
