package io.github.vzer.factory.model.mine.wallet;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author YangCihang
 * @since 17/8/21.
 * email yangcihang@hrsoft.net
 */

public class UserWalletOrderResponse implements Serializable {
    private ArrayList<UserWalletOrderModel> list;
    private boolean isLastPage;

    public ArrayList<UserWalletOrderModel> getList() {
        return list;
    }

    public void setList(ArrayList<UserWalletOrderModel> list) {
        this.list = list;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }
}
