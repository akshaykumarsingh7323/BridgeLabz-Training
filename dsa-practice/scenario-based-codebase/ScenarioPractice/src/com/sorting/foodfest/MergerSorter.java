package com.sorting.foodfest;

import java.util.*;

class MergeSorter {

    static List<Stall> merge(List<Stall> left, List<Stall> right) {
        List<Stall> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).footfall <= right.get(j).footfall) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }
}
