package com.objectmodeling.universitymanagement;

import java.util.*;

class Department {
    private String deptName;

    public Department(String deptName) {
        this.deptName = deptName;
        System.out.println("Department created: " + deptName);
    }

    public void display() {
        System.out.println(" Department: " + deptName);
    }

    public void destroy() {
        System.out.println("Department destroyed: " + deptName);
    }
}
