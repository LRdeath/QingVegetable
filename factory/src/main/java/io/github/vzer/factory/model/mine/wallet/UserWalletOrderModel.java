package io.github.vzer.factory.model.mine.wallet;

import java.io.Serializable;

/**
 * @author YangCihang
 * @since 17/8/21.
 * email yangcihang@hrsoft.net
 */

public class UserWalletOrderModel implements Serializable {
    //type 1-5分别为购物，充值，提现，退货，礼品卡
    public static final int SHOPPING_TYPE = 1;
    public static final int RECHARGE_TYPE = 2;
    public static final int WITHDRAW_TYPE = 3;
    public static final int REFUNDS_TYPE = 4;
    public static final int GIFT_TYPE = 5;
    private int amount;
    private boolean checked;
    private long createdAt;
    private long updatedAt;
    private String description;
    private int type;
    private int id;
    private String orderId;
    private int userId;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
