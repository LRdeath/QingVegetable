package io.github.vzer.factory.network;

/**
 * 网络请求返回码
 * @author: Vzer.
 * @date: 2017/7/25. 16:00
 * @email: vzer@qq.com
 */

public class RspCode {
    public static final int SUCCEED = 1;//成功
    public static final int ERROR_PARAMETERS = 4001;//参数错误
    public static final int ERROR_PARAMETERS_EXIST_ACCOUNT = 4002;//账户已存在

    public static final int ERROR_SERVICE = 5001;//服务器错误

    public static final int ERROR_ACCOUNT_TOKEN = 2001;//账户token错误
    public static final int ERROR_ACCOUNT_LOGIN = 2002;//账户登录错误
    public static final int ERROR_ACCOUNT_REGISTER = 2003;

    public static final int ERROR_ACCOUNT_NO_PERMISSION = 2010;
}
