package io.github.vzer.factory.model.mine.wallet;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author YangCihang
 * @since 17/8/21.
 * email yangcihang@hrsoft.net
 */

public class UserWalletOrderResponse implements Serializable {
    private ArrayList<UserWalletOrderModel> tradeList;

    public ArrayList<UserWalletOrderModel> getTradeList() {
        return tradeList;
    }

    public void setTradeList(ArrayList<UserWalletOrderModel> tradeList) {
        this.tradeList = tradeList;
    }
}
