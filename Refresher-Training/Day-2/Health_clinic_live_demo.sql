-- Create the database if it doesn't already exist
CREATE DATABASE IF NOT EXISTS health_clinic;

-- Show all available databases
SHOW DATABASES;

-- Switch to the health_clinic database
USE health_clinic;

-- Create the patient table
CREATE TABLE patient (
    patient_id INT PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(100) NOT NULL,
    phone      VARCHAR(15),
    dob        DATE
);

-- Create the doctor table
CREATE TABLE doctor (
    doctor_id  INT PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(100) NOT NULL,
    specialty  VARCHAR(50)
);

-- Create the appointment table with foreign key relationships
CREATE TABLE appointment (
    appointment_id    INT PRIMARY KEY AUTO_INCREMENT,
    patient_id        INT NOT NULL,
    doctor_id         INT NOT NULL,
    appointment_date  DATETIME NOT NULL,
    status            VARCHAR(20) DEFAULT 'Scheduled',
    FOREIGN KEY (patient_id) REFERENCES patient(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id)
);

-- Display all tables in the database
SHOW TABLES;

-- Insert sample patient records
INSERT INTO patient (name, phone, dob) VALUES
    ('Ravi Kumar', '9876500000', '1990-01-01'),
    ('Meena S', '9123400000', '1988-05-05'),
    ('Aman Kumar', '9236500000', '1993-04-03'),
    ('Raman', '8823400000', '1987-02-04');

-- Insert sample doctor records
INSERT INTO doctor (name, specialty) VALUES
    ('Dr. Anita', 'Cardiology'),
    ('Dr. Suresh', 'Orthopedic'),
    ('Dr. Shyam', 'Neurologist'),
    ('Dr. Amit', 'Dentist');

-- Insert sample appointment records
INSERT INTO appointment (patient_id, doctor_id, appointment_date, status) VALUES
    (1, 1, '2026-08-05 10:00:00', 'Scheduled'),
    (1, 2, '2026-08-06 11:30:00', 'Scheduled'),
    (2, 3, '2026-08-07 09:00:00', 'Scheduled'),
    (2, 1, '2026-08-08 11:00:00', 'Scheduled'),
    (3, 2, '2026-08-08 11:30:00', 'Scheduled'),
    (4, 1, '2026-08-07 09:00:00', 'Scheduled');

-- View all doctor records
SELECT * FROM doctor;

-- View all patient records
SELECT * FROM patient;

-- View all appointment records
SELECT * FROM appointment;

-- Create a non-normalized table (for comparison/demo)
CREATE TABLE appointment_bad (
    appt_id           INT PRIMARY KEY AUTO_INCREMENT,
    patient_name      VARCHAR(100),
    patient_phone     VARCHAR(15),
    doctor_name       VARCHAR(100),
    doctor_specialty  VARCHAR(50),
    appt_date         DATETIME
);

-- Insert sample data into the non-normalized table
INSERT INTO appointment_bad
    (patient_name, patient_phone, doctor_name, doctor_specialty, appt_date)
VALUES
    ('Ravi Kumar', '9876500000', 'Dr. Anita', 'Cardiology', '2026-08-05 10:00:00'),
    ('Ravi Kumar', '9876500000', 'Dr. Suresh', 'Orthopedic', '2026-08-06 11:30:00'),
    ('Meena S', '9123400000', 'Dr. Anita', 'Cardiology', '2026-08-07 09:00:00');

-- Display all doctors
SELECT * FROM doctor;

-- Display all patients
SELECT * FROM patient;

-- Display all appointments
SELECT * FROM appointment;

-- Display all records from appointment_bad
SELECT * FROM appointment_bad;

-- Show only patient names
SELECT name FROM patient;

-- Show doctor names with their specialties
SELECT name, specialty FROM doctor;

-- Find all scheduled appointments
SELECT * FROM appointment
WHERE status = 'Scheduled';

-- Find patients born after 1 Jan 1990
SELECT * FROM patient
WHERE dob > '1990-01-01';

-- Find all cardiology doctors
SELECT * FROM doctor
WHERE specialty = 'Cardiology';

-- Count the total number of patients
SELECT COUNT(name) FROM patient;

-- Count the total number of doctors
SELECT COUNT(name) FROM doctor;

-- Show each patient's name with their appointment date
SELECT patient.name, appointment.appointment_date
FROM patient
INNER JOIN appointment
ON patient.patient_id = appointment.patient_id;

-- Show each doctor's name with their appointment date
SELECT doctor.name, appointment.appointment_date
FROM doctor
INNER JOIN appointment
ON doctor.doctor_id = appointment.doctor_id;

-- Add a new column to store doctor fees
ALTER TABLE doctor
ADD COLUMN doctor_fees DOUBLE(10,2) NOT NULL;

-- Enable safe update mode
SET SQL_SAFE_UPDATES = 1;

-- Update doctor fees based on doctor ID
UPDATE doctor
SET doctor_fees = CASE doctor_id
    WHEN 1 THEN 500
    WHEN 2 THEN 1000
    WHEN 3 THEN 1500
    WHEN 4 THEN 2000
    ELSE NULL
END;

-- Turn off safe update mode
SET SQL_SAFE_UPDATES = 0;

-- Update Ravi Kumar's phone number in appointment_bad table
UPDATE appointment_bad
SET patient_phone = '9999999999'
WHERE patient_name = 'Ravi Kumar';

-- Check how many rows were updated
SELECT ROW_COUNT();

-- Turn on safe update mode
SET SQL_SAFE_UPDATES = 1;

-- Update Ravi Kumar's phone number in patient table
UPDATE patient
SET phone = '9999999999'
WHERE name = 'Ravi Kumar';

-- Check how many rows were updated
SELECT ROW_COUNT();

-- Add department_name column to doctor table
ALTER TABLE doctor
ADD COLUMN department_name VARCHAR(50);

-- Set department name for Cardiology doctors
UPDATE doctor
SET department_name = 'Cardiology Dept'
WHERE specialty = 'Cardiology';

-- Set department name for Orthopedic doctors
UPDATE doctor
SET department_name = 'Ortho Dept'
WHERE specialty = 'Orthopedic';

-- Set department name for Neurologist doctors
UPDATE doctor
SET department_name = 'Neuro Dept'
WHERE specialty = 'Neurologist';

-- Set department name for Dentist doctors
UPDATE doctor
SET department_name = 'Dentist Dept'
WHERE specialty = 'Dentist';

-- Show doctor table
SELECT * FROM doctor;

-- Remove department_name column
ALTER TABLE doctor
DROP COLUMN department_name;

-- Create department table
CREATE TABLE department (
    department_id INT PRIMARY KEY AUTO_INCREMENT,
    department_name VARCHAR(50) NOT NULL
);

-- Show department table
SELECT * FROM department;

-- Add department_id column to doctor table
ALTER TABLE doctor
ADD COLUMN department_id INT;

-- Show doctor table
SELECT * FROM doctor;

-- Add foreign key between doctor and department
ALTER TABLE doctor
ADD FOREIGN KEY (department_id)
REFERENCES department(department_id);

-- Insert department records
INSERT INTO department (department_name)
VALUES
('Cardiology Dept'),
('Ortho Dept'),
('Neurologist Dept'),
('Dentist');

-- Assign Cardiology department
UPDATE doctor
SET department_id = 1
WHERE specialty = 'Cardiology';

-- Assign Orthopedic department
UPDATE doctor
SET department_id = 2
WHERE specialty = 'Orthopedic';

-- Assign Neurologist department
UPDATE doctor
SET department_id = 3
WHERE specialty = 'Neurologist';

-- Assign Dentist department
UPDATE doctor
SET department_id = 4
WHERE specialty = 'Dentist';

-- Show updated doctor table
SELECT * FROM doctor;

-- Update department name
UPDATE department
SET department_name = 'Cardiology Department'
WHERE department_id = 1;

-- Show doctor details with department name
SELECT
    d.name,
    d.specialty,
    dep.department_name
FROM doctor d
JOIN department dep
ON d.department_id = dep.department_id;

-- Change delimiter for procedure
DELIMITER $$

-- Create procedure to insert random appointments
CREATE PROCEDURE seed_appointments(IN n INT)
BEGIN
    DECLARE i INT DEFAULT 0;

    WHILE i < n DO

        INSERT INTO appointment
        (
            patient_id,
            doctor_id,
            appointment_date,
            status
        )
        VALUES
        (
            1 + FLOOR(RAND() * 2),
            1 + FLOOR(RAND() * 2),
            DATE_ADD('2026-01-01', INTERVAL FLOOR(RAND() * 365) DAY),
            'Scheduled'
        );

        SET i = i + 1;

    END WHILE;
END$$

-- Restore default delimiter
DELIMITER ;

-- Show stored procedure
SHOW CREATE PROCEDURE seed_appointments;

-- Run the procedure
CALL seed_appointments(50000);

-- Show all appointments
SELECT * FROM appointment;

-- Show appointments of patient 1
SELECT *
FROM appointment
WHERE patient_id = 1;

-- Create index on patient_id
CREATE INDEX idx_appointment_patient
ON appointment(patient_id);

-- Check query execution plan
EXPLAIN
SELECT *
FROM appointment
WHERE patient_id = 1;

-- Check execution plan before creating composite index
EXPLAIN
SELECT *
FROM appointment
WHERE doctor_id = 1
AND appointment_date > '2026-06-01';

-- Create composite index
CREATE INDEX idx_doctor_date
ON appointment(doctor_id, appointment_date);

-- Check execution plan after creating composite index
EXPLAIN
SELECT *
FROM appointment
WHERE doctor_id = 1
AND appointment_date > '2026-06-01';
