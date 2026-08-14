package com.employeepayrollsystem.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.employeepayrollsystem.entity.Department;

@Repository
public class DepartmentRepository {

    private final JdbcTemplate jdbcTemplate;

    public DepartmentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CREATE
    public Department save(Department department) {

        String sql = """
                INSERT INTO department (name, description)
                VALUES (?, ?)
                """;

        jdbcTemplate.update(
                sql,
                department.getName(),
                department.getDescription()
        );

        Long id = jdbcTemplate.queryForObject(
                "SELECT MAX(id) FROM department",
                Long.class
        );

        department.setId(id);

        return department;
    }

    // GET ALL
    public List<Department> findAll() {

        String sql = "SELECT * FROM department";

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new Department(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("description")
                )
        );
    }

    // GET BY ID
    public Department findById(Long id) {

        String sql = """
                SELECT * FROM department
                WHERE id = ?
                """;

        List<Department> departments =
                jdbcTemplate.query(
                        sql,
                        (rs, rowNum) -> new Department(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("description")
                        ),
                        id
                );

        return departments.isEmpty()
                ? null
                : departments.get(0);
    }

    // UPDATE
    public Department update(
            Long id,
            Department department) {

        String sql = """
                UPDATE department
                SET name = ?,
                    description = ?
                WHERE id = ?
                """;

        jdbcTemplate.update(
                sql,
                department.getName(),
                department.getDescription(),
                id
        );

        return findById(id);
    }

    // DELETE
    public boolean deleteById(Long id) {

        String sql = """
                DELETE FROM department
                WHERE id = ?
                """;

        int rows = jdbcTemplate.update(sql, id);

        return rows > 0;
    }
}