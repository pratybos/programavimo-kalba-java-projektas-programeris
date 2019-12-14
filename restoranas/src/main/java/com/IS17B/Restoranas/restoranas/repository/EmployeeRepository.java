package com.IS17B.Restoranas.restoranas.repository;

import com.IS17B.Restoranas.restoranas.model.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository 
			extends CrudRepository<EmployeeEntity, Long> {

}
