package io.github.vzer.factory.network;

import java.io.IOException;

import io.github.vzer.factory.constant.CommonConstant;
import io.github.vzer.factory.Factory;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络请求类的封装
 * @author: Vzer.
 * @date: 2017/7/25. 15:04
 * @email: vzer@qq.com
 */

public class NetWork {

    private static NetWork instance;
    private Retrofit retrofit;

    static {
        instance = new NetWork();
    }

    public static NetWork getInstance() {
        return instance;
    }

    /**
     * 封装Retrofit
     * @return Retrofit
     */
    public static Retrofit getRetrofit() {
        if (instance.retrofit != null) return instance.retrofit;

        OkHttpClient client = new OkHttpClient.Builder()
                //给所有请求添加拦截器
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();//拿到我们的请求
                        Request.Builder builder = request.newBuilder();//重新进行build
                        builder.addHeader("Content-Type","application/json");
                        Request newRequest = builder.build();//重建请求

                        return chain.proceed(newRequest);
                    }
                })
                .build();

        instance.retrofit = new Retrofit.Builder()
                .baseUrl(CommonConstant.API_URL)
                .client(client)
                //设置Json解析器
                .addConverterFactory(GsonConverterFactory.create(Factory.getGson()))
                .build();

        return instance.retrofit;
    }

    /**
     * 返回封装后的网络接口类
     * @return RemoteService
     */
    public static RemoteService getService(){
        return getRetrofit().create(RemoteService.class);
    }
}
