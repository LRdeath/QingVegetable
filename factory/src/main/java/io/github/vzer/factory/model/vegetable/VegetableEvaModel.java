package io.github.vzer.factory.model.vegetable;

/**
 * 商品评价model
 * @author: Vzer.
 * @date: 2017/8/4. 15:49
 * @email: vzer@qq.com
 */

public class VegetableEvaModel {
    private int pId; //商品id
    private int uId; //用户id
    private String name; //用户名(默认匿名用户)
    private String date; //评价时间 格式:2017-07-01
    private int degree; //满意度: 1为满意,2为不满意
    private String portraitUri; //用户头像地址
    private String content; //评价内容

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public String getPortraitUri() {
        return portraitUri;
    }

    public void setPortraitUri(String portraitUri) {
        this.portraitUri = portraitUri;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
