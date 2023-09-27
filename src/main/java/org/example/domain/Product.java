package org.example.domain;

import org.example.base.domain.BaseEntity;

public class Product extends BaseEntity {
    public static final String TABLE_NAME ="product";
    public static final String NAME = "name_product";
    public static final String CREATE_DATE = "create_date";
    public static final String BRAND = "brand_id";
    public static final String CATEGORY = "category_id";
    private String createDate;
    private Brand brand;
    private Category category;


    public String getCreateDate() {
        return createDate;
    }
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
