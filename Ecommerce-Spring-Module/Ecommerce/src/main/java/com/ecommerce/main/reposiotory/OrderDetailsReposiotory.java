package com.ecommerce.main.reposiotory;


import org.springframework.data.repository.CrudRepository;

import com.ecommerce.main.dao.OrderDetails;

public interface OrderDetailsReposiotory extends CrudRepository<OrderDetails,Integer>{

	/* @Modifying(clearAutomatically = true)
	    @Query("UPDATE OrdersDetails c SET c.address = :address WHERE c.id = :orderId")
	    int updateAddress(@Param("orderId") int companyId, @Param("address") String address);
	 */
}
