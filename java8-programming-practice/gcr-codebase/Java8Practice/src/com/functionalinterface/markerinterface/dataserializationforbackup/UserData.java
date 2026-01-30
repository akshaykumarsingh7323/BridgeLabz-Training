package com.functionalinterface.markerinterface.dataserializationforbackup;

class UserData implements BackupSerializable {

    private String username;
    private int age;

    public UserData(String username, int age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserData{username='" + username + "', age=" + age + "}";
    }
}
