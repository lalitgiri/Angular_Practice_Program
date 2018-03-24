package com.ecommerce.main.reposiotory;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.main.dao.EmployeeDetails;

public interface EmployeeDetailReposiotory extends CrudRepository<EmployeeDetails,Integer>{
/*	@Modifying(clearAutomatically = true)
    @Query("UPDATE EmployeeDetails c SET c.status = :status WHERE c.id = :employeeId")
    int updateAddress(@Param("employeeId") int companyId, @Param("status") String address);
*/}
