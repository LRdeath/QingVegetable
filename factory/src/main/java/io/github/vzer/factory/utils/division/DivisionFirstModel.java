package io.github.vzer.factory.utils.division;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YangCihang
 * @since 17/8/14.
 * email yangcihang@hrsoft.net
 */

public class DivisionFirstModel implements Serializable {
    private String name;
    private ArrayList<DivisionSecondModel> city;

    public void setCity(ArrayList<DivisionSecondModel> city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<DivisionSecondModel> getCity() {
        return city;
    }

    public String getName() {
        return name;
    }
}
