package com.smarthomeautomationsystem;

public class UserController {

    public void toggleDevice(Appliance appliance) {
        if (appliance.isOn()) {
            appliance.turnOff();
        } else {
            appliance.turnOn();
        }
    }

    public void showApplianceInfo(Appliance appliance) {
        appliance.deviceInfo();
    }
}
