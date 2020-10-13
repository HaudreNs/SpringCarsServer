package com.printec.cars;

public class Brand {
    private String brandName;

    Brand(){}

    public Brand(String brandName) {
        this.brandName = brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }
}
