package com.ecommerce.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.main.dao.EmployeeDetails;
import com.ecommerce.main.dao.UserDetails;

public interface EmployeeDetailRepository extends CrudRepository<EmployeeDetails,Integer>{

	EmployeeDetails findByemployeeNameAndPassword(String UserName, String password);
/*	@Modifying(clearAutomatically = true)
    @Query("UPDATE EmployeeDetails c SET c.status = :status WHERE c.id = :employeeId")
    int updateAddress(@Param("employeeId") int companyId, @Param("status") String address);
*/}
