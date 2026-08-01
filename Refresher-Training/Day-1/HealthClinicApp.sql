-- Create database
CREATE DATABASE HealthClinicDB;

-- Use database
USE HealthClinicDB;

-- Create Doctor table
CREATE TABLE Doctor (
    DoctorID INT AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Specialization VARCHAR(100) NOT NULL,
    Phone VARCHAR(15) UNIQUE,
    CreatedOn TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- View table structure
mysql> DESC Doctor; 
+----------------+--------------+------+-----+-------------------+-------------------+
| Field          | Type         | Null | Key | Default           | Extra             |
+----------------+--------------+------+-----+-------------------+-------------------+
| DoctorID       | int          | NO   | PRI | NULL              | auto_increment    |
| FirstName      | varchar(50)  | NO   |     | NULL              |                   |
| LastName       | varchar(50)  | NO   |     | NULL              |                   |
| Specialization | varchar(100) | NO   |     | NULL              |                   |
| Phone          | varchar(15)  | YES  | UNI | NULL              |                   |
| CreatedOn      | timestamp    | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
+----------------+--------------+------+-----+-------------------+-------------------+

-- Add Email column
mysql> ALTER TABLE Doctor ADD Email VARCHAR(100) UNIQUE;

-- View updated table structure
mysql> DESC Doctor;
+----------------+--------------+------+-----+-------------------+-------------------+
| Field          | Type         | Null | Key | Default           | Extra             |
+----------------+--------------+------+-----+-------------------+-------------------+
| DoctorID       | int          | NO   | PRI | NULL              | auto_increment    |
| FirstName      | varchar(50)  | NO   |     | NULL              |                   |
| LastName       | varchar(50)  | NO   |     | NULL              |                   |
| Specialization | varchar(100) | NO   |     | NULL              |                   |
| Phone          | varchar(15)  | YES  | UNI | NULL              |                   |
| CreatedOn      | timestamp    | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| Email          | varchar(100) | YES  | UNI | NULL              |                   |
+----------------+--------------+------+-----+-------------------+-------------------+

-- Insert doctor records
INSERT INTO Doctor (FirstName, LastName, Specialization, Phone, Email)
VALUES
('Anjali', 'Rao', 'Cardiology', '9876500001', 'anjali@gmail.com'),
('Akshay', 'Kumar', 'Orthopedics', '7323944100', 'akshay@gmail.com'),
('Avinash', 'Kumar', 'Dermatology', '9876506764', 'avinash@gmail.com'),
('Amit', 'Singh', 'Neurology', '9876500004', 'amit@gmail.com'),
('Priyanshu', 'Kumar', 'Pediatrics', '9876500005', 'priyanshu@gmail.com'),
('Pratham', 'Kacher', 'General Medicine', '9876500006', 'pratham@gmail.com');

-- View all records
mysql> SELECT * FROM Doctor;
+----------+-----------+----------+------------------+------------+---------------------+---------------------+
| DoctorID | FirstName | LastName | Specialization   | Phone      | CreatedOn           | Email               |
+----------+-----------+----------+------------------+------------+---------------------+---------------------+
|        1 | Anjali    | Rao      | Cardiology       | 9876500001 | 2026-08-01 23:49:45 | anjali@gmail.com    |
|        2 | Akshay    | Kumar    | Orthopedics      | 7323944100 | 2026-08-01 23:49:45 | akshay@gmail.com    |
|        3 | Avinash   | Kumar    | Dermatology      | 9876506764 | 2026-08-01 23:49:45 | avinash@gmail.com   |
|        4 | Amit      | Singh    | Neurology        | 9876500004 | 2026-08-01 23:49:45 | amit@gmail.com      |
|        5 | Priyanshu | Kumar    | Pediatrics       | 9876500005 | 2026-08-01 23:49:45 | priyanshu@gmail.com |
|        6 | Pratham   | Kacher   | General Medicine | 9876500006 | 2026-08-01 23:49:45 | pratham@gmail.com   |
+----------+-----------+----------+------------------+------------+---------------------+---------------------+

-- Find Cardiology doctors
mysql> SELECT DoctorID, FirstName, LastName, Specialization FROM Doctor WHERE Specialization = 'Cardiology';
+----------+-----------+----------+----------------+
| DoctorID | FirstName | LastName | Specialization |
+----------+-----------+----------+----------------+
|        1 | Anjali    | Rao      | Cardiology     |
+----------+-----------+----------+----------------+

-- Update phone number
UPDATE Doctor SET Phone = '9876500099' WHERE DoctorID = 1;

-- View updated records
mysql> SELECT * FROM Doctor;
+----------+-----------+----------+------------------+------------+---------------------+---------------------+
| DoctorID | FirstName | LastName | Specialization   | Phone      | CreatedOn           | Email               |
+----------+-----------+----------+------------------+------------+---------------------+---------------------+
|        1 | Anjali    | Rao      | Cardiology       | 9876500099 | 2026-08-01 23:49:45 | anjali@gmail.com    |
|        2 | Akshay    | Kumar    | Orthopedics      | 7323944100 | 2026-08-01 23:49:45 | akshay@gmail.com    |
|        3 | Avinash   | Kumar    | Dermatology      | 9876506764 | 2026-08-01 23:49:45 | avinash@gmail.com   |
|        4 | Amit      | Singh    | Neurology        | 9876500004 | 2026-08-01 23:49:45 | amit@gmail.com      |
|        5 | Priyanshu | Kumar    | Pediatrics       | 9876500005 | 2026-08-01 23:49:45 | priyanshu@gmail.com |
|        6 | Pratham   | Kacher   | General Medicine | 9876500006 | 2026-08-01 23:49:45 | pratham@gmail.com   |
+----------+-----------+----------+------------------+------------+---------------------+---------------------+

-- Delete doctor
mysql> DELETE FROM Doctor WHERE DoctorID = 4;

-- View remaining records
mysql> SELECT * FROM Doctor;
+----------+-----------+----------+------------------+------------+---------------------+---------------------+
| DoctorID | FirstName | LastName | Specialization   | Phone      | CreatedOn           | Email               |
+----------+-----------+----------+------------------+------------+---------------------+---------------------+
|        1 | Anjali    | Rao      | Cardiology       | 9876500099 | 2026-08-01 23:49:45 | anjali@gmail.com    |
|        2 | Akshay    | Kumar    | Orthopedics      | 7323944100 | 2026-08-01 23:49:45 | akshay@gmail.com    |
|        3 | Avinash   | Kumar    | Dermatology      | 9876506764 | 2026-08-01 23:49:45 | avinash@gmail.com   |
|        5 | Priyanshu | Kumar    | Pediatrics       | 9876500005 | 2026-08-01 23:49:45 | priyanshu@gmail.com |
|        6 | Pratham   | Kacher   | General Medicine | 9876500006 | 2026-08-01 23:49:45 | pratham@gmail.com   |
+----------+-----------+----------+------------------+------------+---------------------+---------------------+