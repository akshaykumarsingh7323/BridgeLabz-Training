package com.goemeasuresolution;

public class Line {

    private double x1, y1, x2, y2;

    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double calculateLength() {
        return Math.sqrt(
                Math.pow(x2 - x1, 2) +
                Math.pow(y2 - y1, 2)
        );
    }

    public int compareTo(Line other) {
        double len1 = this.calculateLength();
        double len2 = other.calculateLength();

        if (len1 == len2)
            return 0;
        else if (len1 > len2)
            return 1;
        else
            return -1;
    }

    public void display() {
        System.out.println("Line [(" + x1 + "," + y1 + ") to (" + x2 + "," + y2 + ")]");
        System.out.println("Length = " + calculateLength());
    }
}

