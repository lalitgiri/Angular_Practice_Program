package com.ecommerce.main.reposiotory;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.main.dao.OrderDetails;

public interface OrderDetailsReposiotory extends CrudRepository<OrderDetails,Integer>{

}
