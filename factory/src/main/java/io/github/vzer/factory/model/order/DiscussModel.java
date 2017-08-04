package io.github.vzer.factory.model.order;

import java.io.Serializable;
import java.util.List;

/**
 * @author YangCihang
 * @since 17/8/4.
 * email yangcihang@hrsoft.net
 */

public class DiscussModel implements Serializable {
    private List<DiscussVegetableModel> vegetableModelList;
    private int userId;
    private int orderId;
    private long createTime;

    public List<DiscussVegetableModel> getVegetableModelList() {
        return vegetableModelList;
    }

    public void setVegetableModelList(List<DiscussVegetableModel> vegetableModelList) {
        this.vegetableModelList = vegetableModelList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
