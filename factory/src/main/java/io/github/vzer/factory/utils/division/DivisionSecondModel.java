package io.github.vzer.factory.utils.division;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author YangCihang
 * @since 17/8/14.
 * email yangcihang@hrsoft.net
 */

public class DivisionSecondModel implements Serializable {
    private String name;
    private ArrayList<String> area;

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getArea() {
        return area;
    }
}
