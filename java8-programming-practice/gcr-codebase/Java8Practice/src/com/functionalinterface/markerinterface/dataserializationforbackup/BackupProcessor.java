package com.functionalinterface.markerinterface.dataserializationforbackup;

class BackupProcessor {

    public static void backupObject(Object obj) {

        if (obj instanceof BackupSerializable) {
            System.out.println("Backing up object: " + obj);
        } else {
            System.out.println("Backup NOT allowed for: " + obj.getClass().getSimpleName());
        }
    }
}
