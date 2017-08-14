package io.github.vzer.factory.utils.division;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author YangCihang
 * @since 17/8/14.
 * email yangcihang@hrsoft.net
 */

public class DivisionModel implements Serializable {
    private ArrayList<DivisionFirstModel> data;

    public void setData(ArrayList<DivisionFirstModel> data) {
        this.data = data;
    }

    public ArrayList<DivisionFirstModel> getData() {
        return data;
    }
}
