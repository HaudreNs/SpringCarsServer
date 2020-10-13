package com.printec.cars;

public class Model {
    private String modelName;

    Model() {}

    public Model(String modelName) {
        this.modelName = modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }
}
