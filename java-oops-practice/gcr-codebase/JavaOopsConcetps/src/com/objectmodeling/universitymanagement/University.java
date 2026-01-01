package com.objectmodeling.universitymanagement;

import java.util.*;

class University {
    private String universityName;
    private List<Department> departments;
    private List<Faculty> faculties;

    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
        System.out.println("University created: " + universityName);
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void showDetails() {
        System.out.println("\nUniversity: " + universityName);

        System.out.println("Departments:");
        for (Department d : departments) {
            d.display();
        }

        System.out.println("Faculties:");
        for (Faculty f : faculties) {
            f.display();
        }
    }

    public void destroyUniversity() {
        for (Department d : departments) {
            d.destroy();
        }
        departments.clear();
        System.out.println("University destroyed: " + universityName);
    }
}

