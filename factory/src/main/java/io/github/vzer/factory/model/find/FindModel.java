package io.github.vzer.factory.model.find;

/**
 * @author: Vzer.
 * @date: 2017/8/9. 21:20
 * @email: vzer@qq.com
 */

public class FindModel {
    private String title; //文章名字
    private String contentUri; //内容图片地址

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentUri() {
        return contentUri;
    }

    public void setContentUri(String contentUri) {
        this.contentUri = contentUri;
    }
}
