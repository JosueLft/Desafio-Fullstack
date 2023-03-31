package com.reign.lofty.applicationAPI.enums;

public enum SupplierType {

    NORMAL_PERSON(0),
    LEGAL_PERSON(1);

    private int code;

    private SupplierType(int code) { this.code = code; }

    public int getCode() { return code; }

    public static SupplierType valueOf(int code) {
        for(SupplierType value: SupplierType.values()) {
            if(value.getCode() == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid Occupation Area code");
    }
}