-- Create and use database
CREATE DATABASE company;
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

-- View Employee table
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

-- View Department table
SELECT * FROM Department;

-- INNER JOIN: Show only matching records
SELECT
    e.emp_id,
    e.emp_name,
    d.department_name
FROM Employee e
INNER JOIN Department d
ON e.department_id = d.department_id;

-- LEFT JOIN: Show all employees and matching departments
SELECT
    e.emp_id,
    e.emp_name,
    e.department_id,
    d.department_name
FROM Employee e
LEFT JOIN Department d
ON e.department_id = d.department_id;

-- RIGHT JOIN: Show all departments and matching employees
SELECT
    e.emp_id,
    e.emp_name,
    d.department_id,
    d.department_name
FROM Employee e
RIGHT JOIN Department d
ON e.department_id = d.department_id;

-- FULL OUTER JOIN: Show all matched and unmatched records
SELECT
    e.emp_id,
    e.emp_name,
    d.department_name
FROM Employee e
LEFT JOIN Department d
ON e.department_id = d.department_id

UNION

SELECT
    e.emp_id,
    e.emp_name,
    d.department_name
FROM Employee e
RIGHT JOIN Department d
ON e.department_id = d.department_id;

-- LEFT EXCLUSIVE JOIN: Employees without matching department
SELECT
    e.emp_id,
    e.emp_name,
    e.department_id
FROM Employee e
LEFT JOIN Department d
ON e.department_id = d.department_id
WHERE d.department_id IS NULL;

-- RIGHT EXCLUSIVE JOIN: Departments without employees
SELECT
    d.department_id,
    d.department_name
FROM Employee e
RIGHT JOIN Department d
ON e.department_id = d.department_id
WHERE e.emp_id IS NULL;

-- CROSS JOIN: Every employee with every department
SELECT
    e.emp_name,
    d.department_name
FROM Employee e
CROSS JOIN Department d;