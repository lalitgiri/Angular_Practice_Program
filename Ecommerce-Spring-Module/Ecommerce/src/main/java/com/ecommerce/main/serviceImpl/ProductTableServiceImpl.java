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
		if(productTableRepository.existsById(id)){
			productTableRepository.deleteById(id);
			return "SucessFully Deleted";
		}
		return "Product NotFound";
		
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
	
	public List<String> getAllProductCategory(){
	  /*List<ProductTable> productList = (List<ProductTable>) productTableRepository.findAll();
	  List<String> categories = new ArrayList<>();
	  productList.forEach(p -> {
		  	if(!categories.contains(p.getProductCategory())) {
		  		categories.add(p.getProductCategory());
		  	}
	  });
	  return categories;*/
		return productTableRepository.findCategory();
	}


	@Override
	public List<ProductTable> getProductByCategory(String category) {
		return productTableRepository.findByproductCategory(category);
	}
	
}
