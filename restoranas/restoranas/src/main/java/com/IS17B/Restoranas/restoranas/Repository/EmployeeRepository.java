package com.IS17B.Restoranas.restoranas.Repository;

import com.IS17B.Restoranas.restoranas.Model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    int count();
    int save(Employee employee);
    int update(Employee employee);
    int deleteById(Integer id);
    List<Employee> findAll();
    List<Employee> findByNameAndId(String name, Integer Id);
    Optional<Employee> findById(Integer id);
    String getFirstNameById(Integer id);
}
