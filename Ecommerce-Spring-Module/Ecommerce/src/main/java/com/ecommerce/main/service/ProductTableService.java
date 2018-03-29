package com.ecommerce.main.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.main.dao.ProductTable;

public interface ProductTableService {


	public String addProduct(ProductTable product) throws Exception ;
	
	public String deleteProduct(int id[]);
	public Optional<ProductTable> getProductDetails(int id);
	public String updateProductDetails(ProductTable product,long id) ;
	public List<ProductTable> getAllProducts();
	public List<String> getAllProductCategory();

	public List<ProductTable> getProductByCategory(String category);
}
