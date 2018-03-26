package com.ecommerce.main.reposiotory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ecommerce.main.dao.ProductTable;

public interface ProductTableReposiotory extends CrudRepository<ProductTable,Integer>{

	public static final String FIND_CATEGORY = "SELECT DISTINCT product_category FROM product_table";
											
														//SELECT DISTINCT  * FROM product_table WHERE product_category='Bicycle'
	public static final String FIND_PRODUCT_BY_CATEGORY = "SELECT DISTINCT * FROM product_table WHERE product_category=?1";
	@Query(value = FIND_CATEGORY, nativeQuery = true)
	public List<String> findCategory();	
	/*
	@Query(value = FIND_PRODUCT_BY_CATEGORY, nativeQuery = true)
	public List<ProductTable> findProductByCategory(String category);
	*/
	public List<ProductTable> findByproductCategory(String category);
}
