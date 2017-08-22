package io.github.vzer.factory.model.mine.coupon;

import java.io.Serializable;

/**
 * @author YangCihang
 * @since 17/8/22.
 * email yangcihang@hrsoft.net
 */

public class CouponItemModel implements Serializable {
    //满减的钱数
    private int amout;
    private int base;
    private long createdAt;
    private long expiredAt;
    private int id;
    private String descrption;
    private String title;
    //type=1满减，其余的以后扩充
    private int type;

    public int getAmout() {
        return amout;
    }

    public void setAmout(int amout) {
        this.amout = amout;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(long expiredAt) {
        this.expiredAt = expiredAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
