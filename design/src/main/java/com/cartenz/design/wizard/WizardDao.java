package com.cartenz.design.wizard;

/**
 * Created by pratama on 2/15/2018.
 */

public class WizardDao {
    private String title;
    private int type; //0 : default, 1 : done, 2 : selected

    public WizardDao(String title, int type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
