package com.ecommerce.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.main.dao.ProductTable;
import com.ecommerce.main.reposiotory.ProductTableReposiotory;
import com.ecommerce.main.service.ProductTableService;

@Service
public class ProductTableServiceImpl implements ProductTableService {

	@Autowired
	private ProductTableReposiotory productTableRepository;
	
	public String addProduct(ProductTable product) throws Exception {
		productTableRepository.save(product);
		return "Sucessfully Added";
	}
	
	
	public String deleteProduct(int id){
		productTableRepository.deleteById(id);
		return "SucessFully Deleted";
	}
	
	public Optional<ProductTable> getProductDetails(int id) {
		
		return productTableRepository.findById(id);
	}
	
	public String updateProductDetails(ProductTable product,long id) {
		
		productTableRepository.save(product);
		return "SucessFully Updated";
	}
	
	public List<ProductTable> getAllProducts(){
		
		List <ProductTable> productList = new ArrayList<>();
		productTableRepository.findAll().
		forEach(productList::add);
		if(productList==null)
			return null;
		return productList;
	}
	
}
