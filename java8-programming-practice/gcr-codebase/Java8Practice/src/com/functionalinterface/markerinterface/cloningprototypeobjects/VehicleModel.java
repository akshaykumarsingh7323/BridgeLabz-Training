package com.functionalinterface.markerinterface.cloningprototypeobjects;

class VehicleModel implements Cloneable {

    private String modelName;
    private int maxSpeed;

    public VehicleModel(String modelName, int maxSpeed) {
        this.modelName = modelName;
        this.maxSpeed = maxSpeed;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); 
    }

    @Override
    public String toString() {
        return "VehicleModel{modelName='" + modelName + "', maxSpeed=" + maxSpeed + "}";
    }
}
