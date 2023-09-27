package org.example.domain;

import org.example.base.domain.BaseEntity;

public class Shareholder extends BaseEntity {
    public static final String TABLE_NAME ="shareholder";
    public static final String NAME = "name_shareholder";
    public static final String PHONE_NUMBER = "phone_number";
    public static final String NATIONAL_CODE = "national_code";
    private String phoneNumber;
    private String nationalCode;
     private Brand[] brands;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }
}
