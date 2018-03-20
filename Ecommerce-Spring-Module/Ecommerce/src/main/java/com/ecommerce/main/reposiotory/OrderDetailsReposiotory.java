package com.ecommerce.main.reposiotory;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ecommerce.main.dao.OrderDetails;

public interface OrderDetailsReposiotory extends CrudRepository<OrderDetails,Integer>{

	/* @Modifying(clearAutomatically = true)
	    @Query("UPDATE OrdersDetails c SET c.address = :address WHERE c.id = :orderId")
	    int updateAddress(@Param("orderId") int companyId, @Param("address") String address);
	 */
}
