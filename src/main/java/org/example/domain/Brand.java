package org.example.domain;

import org.example.base.domain.BaseEntity;

public class Brand extends BaseEntity {
    public static final String TABLE_NAME = "brand";
    public static final String NAME = "name_brand";
    public static final String WEBSITE = "website";
    public static final String DESCRIPTION = "description";
    private String website;
    private String description;
    private Shareholder[] shareholders;

    public Shareholder[] getShareholders() {
        return shareholders;
    }

    public void setShareholders(Shareholder[] shareholders) {
        this.shareholders = shareholders;
    }

    public Brand() {
    }

    public Brand(String nameOfBrand, String website, String description) {
    }


    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
