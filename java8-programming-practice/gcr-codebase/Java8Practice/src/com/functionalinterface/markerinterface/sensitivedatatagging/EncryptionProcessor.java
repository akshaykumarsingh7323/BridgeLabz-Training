package com.functionalinterface.markerinterface.sensitivedatatagging;

class EncryptionProcessor {

    public static void process(Object obj) {

        if (obj instanceof SensitiveData) {
            System.out.println("Encrypting sensitive data: " + obj.getClass().getSimpleName());
        } else {
            System.out.println("No encryption required for: " + obj.getClass().getSimpleName());
        }
    }
}
