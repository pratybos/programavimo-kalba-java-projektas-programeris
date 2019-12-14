package com.IS17B.Restoranas.restoranas.web;

import com.IS17B.Restoranas.restoranas.exception.RecordNotFoundException;
import com.IS17B.Restoranas.restoranas.model.OrderEntity;
import com.IS17B.Restoranas.restoranas.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/list-order")
public class OrderMvcController
{
	@Autowired
	OrderService service;

	@RequestMapping
	public String getAllOrders(Model model)
	{
		List<OrderEntity> list = service.getAllOrders();

		model.addAttribute("orders", list);
		return "list-order";
	}

	@RequestMapping(path = {"/orderedit", "/orderedit/{id}"})
	public String editOrderById(Model model, @PathVariable("id") Optional<Long> id)
							throws RecordNotFoundException
	{
		if (id.isPresent()) {
			OrderEntity entity = service.getOrderById(id.get());
			model.addAttribute("order", entity);
		} else {
			model.addAttribute("order", new OrderEntity());
		}
		return "add-edit-order";
	}
	
	@RequestMapping(path = "/orderdelete/{id}")
	public String deleteOrderById(Model model, @PathVariable("id") Long id)
							throws RecordNotFoundException 
	{
		service.deleteOrderById(id);
		return "redirect:/list-order";
	}

	@RequestMapping(path = "/createOrder", method = RequestMethod.POST)
	public String createOrUpdateOrder(OrderEntity order)
	{
		service.createOrUpdateOrder(order);
		return "redirect:/list-order";
	}
}