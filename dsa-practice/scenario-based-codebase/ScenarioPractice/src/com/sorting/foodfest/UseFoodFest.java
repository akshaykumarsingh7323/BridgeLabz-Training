package com.sorting.foodfest;

import java.util.*;

import java.util.*;

public class UseFoodFest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of zones: ");
        int zones = sc.nextInt();

        List<List<Stall>> zoneData = new ArrayList<>();

        for (int z = 1; z <= zones; z++) {
            System.out.print("\nEnter number of stalls in Zone " + z + ": ");
            int stalls = sc.nextInt();
            sc.nextLine(); 

            List<Stall> zone = new ArrayList<>();

            System.out.println("Enter stall name and footfall (already sorted):");
            for (int i = 0; i < stalls; i++) {
                System.out.print("Stall name: ");
                String name = sc.nextLine();
                System.out.print("Footfall: ");
                int footfall = sc.nextInt();
                sc.nextLine();

                zone.add(new Stall(name, footfall));
            }

            zoneData.add(zone);
        }

        List<Stall> finalList = zoneData.get(0);
        for (int i = 1; i < zoneData.size(); i++) {
            finalList = MergeSorter.merge(finalList, zoneData.get(i));
        }

        System.out.println("\nFinal Sorted Stall Footfall:");
        for (Stall s : finalList) {
            System.out.println(s.name + " - " + s.footfall);
        }

        sc.close();
    }
}
