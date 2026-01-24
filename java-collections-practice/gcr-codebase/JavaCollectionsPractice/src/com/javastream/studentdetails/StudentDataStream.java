package com.javastream.studentdetails;

import java.io.*;

public class StudentDataStream {

    public static void main(String[] args) {

        String fileName = "student.dat";


        writeStudentData(fileName);

        readStudentData(fileName);
    }

    private static void writeStudentData(String fileName) {

        try (DataOutputStream dos =
                     new DataOutputStream(
                             new FileOutputStream(fileName))) {

            dos.writeInt(101);              
            dos.writeUTF("Akshay");         
            dos.writeDouble(8.14);          

            System.out.println("Student data written successfully.");

        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
    }

    private static void readStudentData(String fileName) {

        try (DataInputStream dis =
                     new DataInputStream(
                             new FileInputStream(fileName))) {

            int rollNo = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            System.out.println("\nStudent Data Read From File:");
            System.out.println("Roll No : " + rollNo);
            System.out.println("Name    : " + name);
            System.out.println("GPA     : " + gpa);

        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}
