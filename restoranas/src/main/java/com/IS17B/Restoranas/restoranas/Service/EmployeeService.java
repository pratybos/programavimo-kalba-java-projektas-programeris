package com.IS17B.Restoranas.restoranas.Service;

import com.IS17B.Restoranas.restoranas.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
JdbcTemplate jdbcTemplate;
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee";
        RowMapper<Employee> rm = new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee employee = new Employee(resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("email"),
                        resultSet.getInt("phoneNumber"),
                        resultSet.getDouble("salary"));
                return employee;
            }
        };
        return jdbcTemplate.query(sql, rm);
    }
}
