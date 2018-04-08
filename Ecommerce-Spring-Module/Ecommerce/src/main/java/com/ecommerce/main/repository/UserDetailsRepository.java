package com.ecommerce.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.main.dao.UserDetails;

public interface UserDetailsRepository extends CrudRepository<UserDetails, Long> {

	public UserDetails findByemailIdAndPassword(String emailId,String password);
	public UserDetails findByemailId(String emailId);
}
