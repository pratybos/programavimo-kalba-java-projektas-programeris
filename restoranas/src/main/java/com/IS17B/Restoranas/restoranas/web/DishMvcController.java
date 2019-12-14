package com.IS17B.Restoranas.restoranas.web;

import com.IS17B.Restoranas.restoranas.exception.RecordNotFoundException;
import com.IS17B.Restoranas.restoranas.model.DishEntity;
import com.IS17B.Restoranas.restoranas.service.DishService;
import com.IS17B.Restoranas.restoranas.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/list-dishes")
public class DishMvcController
{
	@Autowired
	DishService service;

	@RequestMapping
	public String getAllDishes(Model model)
	{
		List<DishEntity> list = service.getAllDishes();

		model.addAttribute("dishes", list);
		return "list-dishes";
	}

	@RequestMapping(path = {"/dishedit", "/dishedit/{id}"})
	public String editDishById(Model model, @PathVariable("id") Optional<Long> id)
							throws RecordNotFoundException
	{
		if (id.isPresent()) {
			DishEntity entity = service.getDishById(id.get());
			model.addAttribute("dish", entity);
		} else {
			model.addAttribute("dish", new DishEntity());
		}
		return "add-edit-dish";
	}
	
	@RequestMapping(path = "/dishdelete/{id}")
	public String deleteDishById(Model model, @PathVariable("id") Long id)
							throws RecordNotFoundException 
	{
		service.deleteDishById(id);
		return "redirect:/list-dishes";
	}

	@RequestMapping(path = "/createDish", method = RequestMethod.POST)
	public String createOrUpdateDish(DishEntity dish)
	{
		service.createOrUpdateDish(dish);
		return "redirect:/list-dishes";
	}
}
