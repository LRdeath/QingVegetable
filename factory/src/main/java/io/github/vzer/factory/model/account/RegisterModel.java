package io.github.vzer.factory.model.account;

/**
 * 用户注册model
 * @author: Vzer.
 * @date: 2017/7/25. 20:58
 * @email: vzer@qq.com
 */

public class RegisterModel {
    private String phone; //手机号
    private String password; //密码
    private String code; //验证码

    public RegisterModel(String phone, String password, String code) {
        this.phone = phone;
        this.password = password;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "RegisterModel{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
