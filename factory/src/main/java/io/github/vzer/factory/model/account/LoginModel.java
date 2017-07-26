package io.github.vzer.factory.model.account;

/**
 * 用户登录model
 * @author: Vzer.
 * @date: 2017/7/25. 16:13
 * @email: vzer@qq.com
 */

public class LoginModel {
    private String phone;
    private String password;
    private String pushId;

    public LoginModel(String phone, String password) {
        this(phone,password,null);
    }

    public LoginModel(String phone, String password, String pushId) {
        this.phone = phone;
        this.password = password;
        this.pushId = pushId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    @Override
    public String toString() {
        return "LoginModel{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", pushId='" + pushId + '\'' +
                '}';
    }
}
