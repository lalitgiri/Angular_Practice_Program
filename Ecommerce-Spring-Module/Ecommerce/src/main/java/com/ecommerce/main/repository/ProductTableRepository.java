package com.ecommerce.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ecommerce.main.dao.ProductTable;

public interface ProductTableRepository extends CrudRepository<ProductTable,Integer>{

	public static final String FIND_CATEGORY = "SELECT DISTINCT product_category FROM product_table";
											
														//SELECT DISTINCT  * FROM product_table WHERE product_category='Bicycle'
	//public static final String FIND_PRODUCT_BY_CATEGORY = "SELECT DISTINCT * FROM product_table WHERE product_category=?1";
	@Query(value = FIND_CATEGORY, nativeQuery = true)
	public List<String> findCategory();	
	/*
	@Query(value = FIND_PRODUCT_BY_CATEGORY, nativeQuery = true)
	public List<ProductTable> findProductByCategory(String category);
	*/
	public List<ProductTable> findByproductCategory(String category);
	
	public static final String COUNT_ROWS = "SELECT count(*)  FROM product_table";
	@Query(value = COUNT_ROWS, nativeQuery = true)
	public int CountRow();
	
	
	public static final String FIND_BY_STATUS = "SELECT * FROM product_table where status=true";
	@Query(value =FIND_BY_STATUS, nativeQuery = true)
	public Iterable<ProductTable> findByStatus();
}
