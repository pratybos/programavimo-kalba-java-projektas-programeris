package com.IS17B.Restoranas.restoranas.repository;

import com.IS17B.Restoranas.restoranas.model.DishEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository
			extends CrudRepository<DishEntity, Long> {

}
