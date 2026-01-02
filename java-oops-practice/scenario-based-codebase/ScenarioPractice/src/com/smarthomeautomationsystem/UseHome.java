package com.smarthomeautomationsystem;

public class UseHome {
    public static void main(String[] args) {

        Appliance light = new Light("Bedroom", 20);
        Appliance fan = new Fan("Hall", 60, 3);
        Appliance ac = new AC("Master Room", 1500, 22);

        UserController controller = new UserController();

        controller.showApplianceInfo(light);
        controller.showApplianceInfo(fan);
        controller.showApplianceInfo(ac);

        controller.toggleDevice(light);
        controller.toggleDevice(ac);

        light.compareEnergy(fan);
        ac.compareEnergy(light);

        controller.toggleDevice(ac);
    }
}
