package com.IS17B.Restoranas.restoranas.Repository;

import com.IS17B.Restoranas.restoranas.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class NamedParameterJdbcEmployeeRepository extends JdbcEmployeeRepository{
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public int update(Employee employee){
        return namedParameterJdbcTemplate.update(
                "UPDATE employee SET phoneNumber = ? WHERE id = :id",
                new BeanPropertySqlParameterSource(employee));
    }
    @Override
    public Optional<Employee> findById(Integer id){
        return namedParameterJdbcTemplate.queryForObject("SELECT * FROM employee WHERE id = :id",
                new MapSqlParameterSource("id", id),
                (rs,rowNum) -> Optional.of(new Employee(rs.getInt("id"), rs.getString("firstName"),
                        rs.getString("lastName"), rs.getString("email"),
                        rs.getInt("phoneNumber"), rs.getDouble("salary"))));
    }
}
