package com.objectmodeling.universitymanagement;

class Faculty {
    private int facultyId;
    private String name;

    public Faculty(int facultyId, String name) {
        this.facultyId = facultyId;
        this.name = name;
        System.out.println("Faculty created: " + name);
    }

    public void display() {
        System.out.println(" Faculty ID: " + facultyId + ", Name: " + name);
    }
}

