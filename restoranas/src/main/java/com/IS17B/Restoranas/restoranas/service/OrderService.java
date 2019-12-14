package com.IS17B.Restoranas.restoranas.service;

import com.IS17B.Restoranas.restoranas.exception.RecordNotFoundException;
import com.IS17B.Restoranas.restoranas.model.OrderEntity;
import com.IS17B.Restoranas.restoranas.repository.OrderRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository repository;
	
	public List<OrderEntity> getAllOrders()
	{
		List<OrderEntity> result = (List<OrderEntity>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<OrderEntity>();
		}
	}
	
	public OrderEntity getOrderById(Long id) throws RecordNotFoundException
	{
		Optional<OrderEntity> order = repository.findById(id);
		
		if(order.isPresent()) {
			return order.get();
		} else {
			throw new RecordNotFoundException("No order record exist for given id");
		}
	}
	
	public OrderEntity createOrUpdateOrder(OrderEntity entity)
	{
		if(entity.getId()  == null) 
		{
			entity = repository.save(entity);
			
			return entity;
		} 
		else 
		{
			Optional<OrderEntity> order = repository.findById(entity.getId());
			
			if(order.isPresent())
			{
				OrderEntity newEntity = order.get();
				newEntity.setOrderName(entity.getOrderName());
				newEntity.setClientName(entity.getClientName());
				newEntity.setPhoneNumber(entity.getPhoneNumber());
				newEntity.setFullPrice(entity.getFullPrice());
				newEntity = repository.save(newEntity);
				return newEntity;
			} else {
				entity = repository.save(entity);
				
				return entity;
			}
		}
	} 
	
	public void deleteOrderById(Long id) throws RecordNotFoundException
	{
		Optional<OrderEntity> order = repository.findById(id);
		
		if(order.isPresent())
		{
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No order record exist for given id");
		}
	} 
}