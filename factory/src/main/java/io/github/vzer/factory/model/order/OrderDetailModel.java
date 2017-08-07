package io.github.vzer.factory.model.order;

import java.io.Serializable;
import java.util.List;

/**
 * @author YangCihang
 * @since 17/8/1.
 * email yangcihang@hrsoft.net
 */

public class OrderDetailModel implements Serializable {

    public static final int STATE_SUBMIT = 0x12;
    public static final int STATE_PAYMENT = 0x123;
    public static final int STATE_DISTRIBUTE = 0x1234;
    public static final int STATE_FINISH = 0x12345;
    private int orderId; //订单id
    private long createTime; //创建时间
    private long receiveTime;//收货时间
    private int totalPrice; //总金额
    private String place; //收货地点
    private String remark; //备注
    private List<OrderDetailVegetableModel> pList;//商品列表
    private int state; //订单状态

    public int getOrderId() {
        return orderId;
    }

    public long getCreateTime() {
        return createTime;
    }

    public long getReceiveTime() {
        return receiveTime;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public String getPlace() {
        return place;
    }

    public String getRemark() {
        return remark;
    }

    public List<OrderDetailVegetableModel> getpList() {
        return pList;
    }

    public int getState() {
        return state;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public void setReceiveTime(long receiveTime) {
        this.receiveTime = receiveTime;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setpList(List<OrderDetailVegetableModel> pList) {
        this.pList = pList;
    }

    public void setState(int state) {
        this.state = state;
    }
}
