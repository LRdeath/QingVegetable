package io.github.vzer.factory.model.db;

/**
 * 用户基本信息表
 * @author: Vzer.
 * @date: 2017/7/25. 16:43
 * @email: vzer@qq.com
 */

public class User {
    public static final int SEX_MAN = 1;
    public static final int SEX_WOMAN = 2;


    private String name;
    private String portrait;
    private String realName;
    private String phone;
    private int sex =0;
    private int credits=0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", realName='" + realName + '\'' +
                ", phone='" + phone + '\'' +
                ", portrait='" + portrait + '\'' +
                ", sex=" + sex +
                ", credits=" + credits +
                '}';
    }
}
