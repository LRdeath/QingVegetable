package io.github.vzer.factory.model.order;

import java.io.Serializable;

/**
 * @author YangCihang
 * @since 17/8/4.
 * email yangcihang@hrsoft.net
 */

public class DiscussVegetableModel implements Serializable {
    private String name;
    private int satisfation;
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getName() {
        return name;
    }

    public int getSatisfation() {
        return satisfation;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setSatisfation(int satisfation) {
        this.satisfation = satisfation;
    }
}
