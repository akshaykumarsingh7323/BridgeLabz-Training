package com.generics.resumescreeningsystem;

import java.util.ArrayList;
import java.util.List;

public class UseResumeScreening {
    public static void main(String[] args) {

        Resume<SoftwareEngineer> r1 =
                new Resume<>(new SoftwareEngineer("Akshay"));
        Resume<DataScientist> r2 =
                new Resume<>(new DataScientist("Deepanshu"));

        r1.process();
        r2.process();

        List<JobRole> list = new ArrayList<>();
        list.add(new SoftwareEngineer("Aman"));
        list.add(new ProductManager("Rohit"));

        Screening.screenAll(list);
        Screening.evaluate(new DataScientist("Punit"));
    }
}


