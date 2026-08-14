package com.employeepayrollsystem.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.employeepayrollsystem.entity.Employee;

@Repository
public class EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CREATE
    public Employee save(Employee employee) {

        String sql = """
                INSERT INTO employee
                (
                    name,
                    email,
                    phone,
                    department_id,
                    designation,
                    salary,
                    joining_date
                )
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        jdbcTemplate.update(
                sql,
                employee.getName(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getDepartmentId(),
                employee.getDesignation(),
                employee.getSalary(),
                Date.valueOf(employee.getJoiningDate())
        );

        Long id = jdbcTemplate.queryForObject(
                "SELECT MAX(id) FROM employee",
                Long.class
        );

        employee.setId(id);

        return employee;
    }

    // GET ALL
    public List<Employee> findAll() {

        String sql = "SELECT * FROM employee";

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> mapEmployee(rs)
        );
    }

    // GET BY ID
    public Employee findById(Long id) {

        String sql = """
                SELECT * FROM employee
                WHERE id = ?
                """;

        List<Employee> employees =
                jdbcTemplate.query(
                        sql,
                        (rs, rowNum) -> mapEmployee(rs),
                        id
                );

        return employees.isEmpty()
                ? null
                : employees.get(0);
    }

    // UPDATE
    public Employee update(
            Long id,
            Employee employee) {

        String sql = """
                UPDATE employee
                SET name = ?,
                    email = ?,
                    phone = ?,
                    department_id = ?,
                    designation = ?,
                    salary = ?,
                    joining_date = ?
                WHERE id = ?
                """;

        jdbcTemplate.update(
                sql,
                employee.getName(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getDepartmentId(),
                employee.getDesignation(),
                employee.getSalary(),
                Date.valueOf(employee.getJoiningDate()),
                id
        );

        return findById(id);
    }

    // DELETE
    public boolean deleteById(Long id) {

        String sql = """
                DELETE FROM employee
                WHERE id = ?
                """;

        int rows = jdbcTemplate.update(sql, id);

        return rows > 0;
    }

    // Row Mapper
    private Employee mapEmployee(
            java.sql.ResultSet rs)
            throws java.sql.SQLException {

        Date joiningDate =
                rs.getDate("joining_date");

        return new Employee(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("phone"),
                rs.getLong("department_id"),
                rs.getString("designation"),
                rs.getDouble("salary"),
                joiningDate != null
                        ? joiningDate.toLocalDate()
                        : null
        );
    }
}