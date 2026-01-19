package com.generics.resumescreeningsystem;

import java.util.List;

class Screening {

    static void screenAll(List<? extends JobRole> list) {
        for (JobRole j : list) {
            System.out.println(j.name + " | " + j.role());
        }
    }

    static <T extends JobRole> void evaluate(T job) {
        System.out.println("Evaluating: " + job.name);
    }
}

