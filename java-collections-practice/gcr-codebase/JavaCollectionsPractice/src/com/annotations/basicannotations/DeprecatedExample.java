package com.annotations.basicannotations;

class LegacyAPI {

    @Deprecated
    void oldFeature() {
        System.out.println("Old feature (do not use)");
    }

    void newFeature() {
        System.out.println("New feature (recommended)");
    }
}

public class DeprecatedExample {

    public static void main(String[] args) {

        LegacyAPI api = new LegacyAPI();

        api.oldFeature();   
        api.newFeature();   
    }
}
