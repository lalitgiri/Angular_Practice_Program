package com.ecommerce.main.reposiotory;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.main.dao.CartDetails;

public interface CartDetailsReposiotory extends CrudRepository<CartDetails,Integer> {

}
