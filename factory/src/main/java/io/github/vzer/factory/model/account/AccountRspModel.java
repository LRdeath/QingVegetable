package io.github.vzer.factory.model.account;

import io.github.vzer.factory.model.db.User;

/**
 * @author: Vzer.
 * @date: 2017/7/26. 12:13
 * @email: vzer@qq.com
 */

public class AccountRspModel {
    //用户基本信息
    private User user;
    //当前登录的账号
    private String account;
    //当前登录成功后获取的Token.
    //可以通过Token获取用户的所有信息
    private String token;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AccountRspModel{" +
                "user=" + user +
                ", account='" + account + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
