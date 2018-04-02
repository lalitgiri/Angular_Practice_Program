package com.ecommerce.main.reposiotory;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.main.dao.UserDetails;

public interface UserDetailsReposiotory extends CrudRepository<UserDetails, Long> {

	public UserDetails findByemailIdAndPassword(String emailId,String password);
}
