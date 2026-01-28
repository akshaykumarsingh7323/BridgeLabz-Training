package com.medwarehouse;

public class UseMedWarehouse {

    public static void main(String[] args) {

        Medicine[] medicines = {
            new Medicine(20240210),
            new Medicine(20240305),
            new Medicine(20240520),
            new Medicine(20240125),
            new Medicine(20240415)
        };

        MergeSorter.mergeSort(medicines, 0, medicines.length - 1);

        System.out.println("Medicines sorted by expiry date:");
        for (Medicine med : medicines) {
            System.out.println(med);
        }

        System.out.println("\nNear Expiry Medicines:");
        for (Medicine med : medicines) {
            if (med.expiryDate <= 20240301) {
                System.out.println(med);
            }
        }
    }
}
