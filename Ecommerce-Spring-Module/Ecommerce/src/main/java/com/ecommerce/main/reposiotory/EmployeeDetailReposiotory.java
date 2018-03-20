package com.ecommerce.main.reposiotory;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ecommerce.main.dao.EmployeeDetails;

public interface EmployeeDetailReposiotory extends CrudRepository<EmployeeDetails,Integer>{
/*	@Modifying(clearAutomatically = true)
    @Query("UPDATE EmployeeDetails c SET c.status = :status WHERE c.id = :employeeId")
    int updateAddress(@Param("employeeId") int companyId, @Param("status") String address);
*/}
