package com.IS17B.Restoranas.restoranas.Repository;

import com.IS17B.Restoranas.restoranas.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public class JdbcEmployeeRepository implements EmployeeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM employee", Integer.class);
    }

    @Override
    public int save(Employee employee) {
        return jdbcTemplate.update("INSERT  INTO employee (id, firstName, lastName, email, " +
                        "phoneNumber, salary) " + "VALUES (?, ?, ?, ?, ?, ?)", employee.getId(),
                employee.getFirstName(), employee.getLastName(), employee.getEmail(),
                employee.getPhoneNumber(), employee.getSalary());
    }

    @Override
    public int update(Employee employee) {
        return jdbcTemplate.update("UPDATE employee SET firstName = ?, lastName = ?," +
                "email = ?, phoneNumber = ?, salary = ? WHERE id =?");
    }

    @Override
    public int deleteById(Integer id) {
        return jdbcTemplate.update("DELETE FROM " +
                "employee WHERE id = ?", id);
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM employee",
                (rs,rowNum) -> new Employee(rs.getInt("id"), rs.getString("firstName"),
                        rs.getString("lastName"), rs.getString("email"),
                        rs.getInt("phoneNumber"), rs.getDouble("salary")));
    }

    @Override
    public List<Employee> findByNameAndId(String name, Integer Id) {
        return null;
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public String getFirstNameById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT firstName FROM employee WHERE id = ?",
                new Object[]{id}, String.class);
    }
}
