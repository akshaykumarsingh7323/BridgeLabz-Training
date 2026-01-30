package com.functionalinterface.interfaces.smartdevicecontrol;

public class AC implements DeviceAction {

    @Override
    public void turnOn() {
        System.out.println("AC is turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("AC is turned OFF");
    }
}
