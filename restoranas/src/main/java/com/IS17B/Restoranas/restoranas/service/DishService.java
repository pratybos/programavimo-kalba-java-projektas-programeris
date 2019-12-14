package com.IS17B.Restoranas.restoranas.service;

import com.IS17B.Restoranas.restoranas.exception.RecordNotFoundException;
import com.IS17B.Restoranas.restoranas.model.DishEntity;
import com.IS17B.Restoranas.restoranas.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DishService {
	
	@Autowired
	DishRepository repository;
	
	public List<DishEntity> getAllDishes()
	{
		List<DishEntity> result = (List<DishEntity>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<DishEntity>();
		}
	}
	
	public DishEntity getDishById(Long id) throws RecordNotFoundException
	{
		Optional<DishEntity> dish = repository.findById(id);
		
		if(dish.isPresent()) {
			return dish.get();
		} else {
			throw new RecordNotFoundException("No Dish record exist for given id");
		}
	}
	
	public DishEntity createOrUpdateDish(DishEntity entity)
	{
		if(entity.getId()  == null) 
		{
			entity = repository.save(entity);
			
			return entity;
		} 
		else 
		{
			Optional<DishEntity> dish = repository.findById(entity.getId());
			
			if(dish.isPresent())
			{
				DishEntity newEntity = dish.get();
				newEntity.setDish_name(entity.getDish_name());
				newEntity.setPrice(entity.getPrice());

				newEntity = repository.save(newEntity);
				
				return newEntity;
			} else {
				entity = repository.save(entity);
				
				return entity;
			}
		}
	} 
	
	public void deleteDishById(Long id) throws RecordNotFoundException
	{
		Optional<DishEntity> dish = repository.findById(id);
		
		if(dish.isPresent())
		{
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No dish record exist for given id");
		}
	} 
}