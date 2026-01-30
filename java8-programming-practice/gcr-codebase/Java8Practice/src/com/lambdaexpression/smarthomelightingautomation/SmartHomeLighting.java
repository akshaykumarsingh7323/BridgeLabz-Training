package com.lambdaexpression.smarthomelightingautomation;

public class SmartHomeLighting {

    public static void main(String[] args) {

        // Motion detected trigger
        LightAction motionTrigger = () -> System.out.println("Motion detected → Lights ON at full brightness");

        // Time-based trigger
        LightAction eveningTrigger = () -> System.out.println("Evening time → Lights dimmed to 40%");

        // Voice command trigger
        LightAction voiceTrigger = () -> System.out.println("Voice command received → Lights set to custom mode");

        // Execute actions
        activateLight(motionTrigger);
        activateLight(eveningTrigger);
        activateLight(voiceTrigger);
    }

    static void activateLight(LightAction action) {
        action.activate();
    }
}

