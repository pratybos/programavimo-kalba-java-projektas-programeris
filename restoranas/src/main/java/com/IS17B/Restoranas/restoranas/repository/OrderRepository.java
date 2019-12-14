package com.IS17B.Restoranas.restoranas.repository;

import com.IS17B.Restoranas.restoranas.model.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository
			extends CrudRepository<OrderEntity, Long> {
}
