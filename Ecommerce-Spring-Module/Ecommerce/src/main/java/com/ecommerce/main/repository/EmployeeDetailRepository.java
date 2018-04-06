package com.ecommerce.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.main.dao.EmployeeDetails;

public interface EmployeeDetailRepository extends CrudRepository<EmployeeDetails,Integer>{
/*	@Modifying(clearAutomatically = true)
    @Query("UPDATE EmployeeDetails c SET c.status = :status WHERE c.id = :employeeId")
    int updateAddress(@Param("employeeId") int companyId, @Param("status") String address);
*/}
