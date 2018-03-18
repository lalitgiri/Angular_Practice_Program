package com.ecommerce.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.main.dao.OrderDetails;
import com.ecommerce.main.reposiotory.OrderDetailsReposiotory;
import com.ecommerce.main.service.OrderDetailsService;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
	
	@Autowired
	private OrderDetailsReposiotory orderDetailsReposiotory;

	@Override
	public String addOrder(OrderDetails order) {
		orderDetailsReposiotory.save(order);
		return "Order Placed Sucessfully";
	}

	@Override
	public List<OrderDetails> getAllOrder() {
			List <OrderDetails> orderList = new ArrayList<OrderDetails>();
			orderDetailsReposiotory.findAll().forEach(orderList::add);
			if(orderList==null)
				return null;
			return orderList;
	}

	@Override
	public String deleteOrder(int id) {
		orderDetailsReposiotory.deleteById(id);
		return "Sucessfully Deleted";
	}

	@Override
	public Optional<OrderDetails> getOrderById(int id) {
		return orderDetailsReposiotory.findById(id);
		
	}

	@Override
	public String updateDeliveryAddress(OrderDetails order, int id) {
		if(orderDetailsReposiotory.existsById(id))
		{
			orderDetailsReposiotory.save(order);
			return "SucessFully Updated"; 
		}
		
		return "Illegal Modification";
	}
	
	

}
