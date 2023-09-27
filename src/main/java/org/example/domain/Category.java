package org.example.domain;

import org.example.base.domain.BaseEntity;

public class Category extends BaseEntity {
    public static final String TABLE_NAME ="category";
    public static final String NAME = "name_category";
    public static final String DESCRIPTION = "description";
    private String description;

    public Category() {
    }

    public Category(String nameOfCategory, String description) {
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
