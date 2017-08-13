package io.github.vzer.factory.model.shopping;

import java.io.Serializable;
import java.util.List;

/**
 * 新建订单Model
 *
 * @author: Vzer.
 * @date: 2017/8/8. 22:03
 * @email: vzer@qq.com
 */

public class ShoppingOrderModel implements Serializable {
    private int uId;//用户id
    private PayModel payModel; //支付信息
    private ReceiveModel receiveModel; //支付信息
    private List<ShoppingModel> modelList;//商品列表
    private double totalPrice;//合计
    private String remark; //备注
    private int state = 0; //订单状态： 0代表未付款，1代表已付款



    public ShoppingOrderModel(int uId, List<ShoppingModel> modelList, double totalPrice, String remark) {
        this.uId = uId;
        this.modelList = modelList;
        this.totalPrice = totalPrice;
        this.remark = remark;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public List<ShoppingModel> getModelList() {
        return modelList;
    }

    public void setModelList(List<ShoppingModel> modelList) {
        this.modelList = modelList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
