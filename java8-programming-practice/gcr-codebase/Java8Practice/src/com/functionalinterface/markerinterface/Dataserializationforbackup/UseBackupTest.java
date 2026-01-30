package com.functionalinterface.markerinterface.Dataserializationforbackup;

public class UseBackupTest {

    public static void main(String[] args) {

        UserData user = new UserData("Akshay", 25);
        TemporaryCache cache = new TemporaryCache("session123");

        BackupProcessor.backupObject(user);
        BackupProcessor.backupObject(cache);
    }
}
