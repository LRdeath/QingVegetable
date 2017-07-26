package io.github.vzer.factory.model;

/**
 *  响应基类
 * @author: Vzer.
 * @date: 2017/7/25. 16:11
 * @email: vzer@qq.com
 */

public class RspModel<T> {

    private int code; //返回码
    private T result;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
