package com.lambdaexpression.notificationfiltering;

public class Alert {
    String message;
    String type;   

    public Alert(String message, String type) {
        this.message = message;
        this.type = type;
    }

    @Override
    public String toString() {
        return type + " ALERT : " + message;
    }
}
