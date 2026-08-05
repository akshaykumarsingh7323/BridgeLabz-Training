-- Create a new database
CREATE DATABASE company;

-- Select the database
USE company;

-- Create Employee table
CREATE TABLE Employee (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50),
    department_id INT
);

-- Insert employee records
INSERT INTO Employee (emp_id, emp_name, department_id)
VALUES
(1, 'Akshay', 101),
(2, 'Avinash', 102),
(3, 'Aman', 103),
(4, 'Ram', 104),
(5, 'Shyam', NULL);

-- Display all employee records
SELECT * FROM Employee;

-- Create Department table
CREATE TABLE Department (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(50)
);

-- Insert department records
INSERT INTO Department (department_id, department_name)
VALUES
(101, 'HR'),
(102, 'IT'),
(103, 'Finance'),
(105, 'Sales');

-- Display all department records
SELECT * FROM Department;

-- Create a stored procedure to display all employees
DELIMITER //

CREATE PROCEDURE GetAllEmployees()
BEGIN
    SELECT * FROM Employee;
END //

DELIMITER ;

-- Execute the procedure to display all employees
CALL GetAllEmployees();

-- Create a stored procedure to display employees of a specific department
DELIMITER //

CREATE PROCEDURE GetEmployeeByDept(
    IN dept_id INT
)
BEGIN
    SELECT *
    FROM Employee
    WHERE department_id = dept_id;
END //

DELIMITER ;

-- Execute the procedure for department ID 102
CALL GetEmployeeByDept(102);

-- Create a stored procedure to count the total number of employees
DELIMITER //

CREATE PROCEDURE GetEmployeeCount(
    OUT total INT
)
BEGIN
    SELECT COUNT(*) INTO total
    FROM Employee;
END //

DELIMITER ;

-- Call the procedure and store the result in a variable
CALL GetEmployeeCount(@count);

-- Display the employee count
SELECT @count;

-- Create a stored procedure to demonstrate the INOUT parameter
DELIMITER //

CREATE PROCEDURE IncreaseDeptId(
    INOUT dept INT
)
BEGIN
    SET dept = dept + 1;
END //

DELIMITER ;

-- Assign an initial value to the variable
SET @dept = 101;

-- Call the procedure to increase the department ID
CALL IncreaseDeptId(@dept);

-- Display the updated department ID
SELECT @dept;

-- Create a stored procedure to display employees with their department names using INNER JOIN
DELIMITER //

CREATE PROCEDURE GetEmployeeDepartment()
BEGIN
    SELECT
        e.emp_id,
        e.emp_name,
        d.department_name
    FROM Employee e
    INNER JOIN Department d
    ON e.department_id = d.department_id;
END //

DELIMITER ;

-- Execute the procedure to display employee and department details
CALL GetEmployeeDepartment();

-- Create a stored procedure to insert a new employee
DELIMITER //

CREATE PROCEDURE AddEmployee(
    IN id INT,
    IN name VARCHAR(50),
    IN dept INT
)
BEGIN
    INSERT INTO Employee(emp_id, emp_name, department_id)
    VALUES(id, name, dept);
END //

DELIMITER ;

-- Add a new employee using the stored procedure
CALL AddEmployee(6, 'Ravi', 105);

-- Display the updated Employee table
SELECT * FROM Employee;