package io.github.vzer.factory.model.account;

/**
 * 用户登录model
 * @author: Vzer.
 * @date: 2017/7/25. 16:13
 * @email: vzer@qq.com
 */

public class LoginModel {
    private String mobile;
    private String password;
    private String pushId;
    private int client; //端口号，1表示安卓端，2表示网络端

    public LoginModel(String mobile, String password) {
        this(mobile, password, 1);
    }

    public LoginModel(String mobile, String password, int client) {
        this.mobile = mobile;
        this.password = password;
        this.client = client;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "LoginModel{" +
                "mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", pushId='" + pushId + '\'' +
                '}';
    }
}
