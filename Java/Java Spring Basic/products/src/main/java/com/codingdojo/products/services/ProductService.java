package com.codingdojo.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;
import com.codingdojo.products.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository pRepo;
	
	// Display All
	public List<Product> AllProducts(){
		return this.pRepo.findAll();
	}
	
	// Create
	public Product createProduct(Product product) {
		return this.pRepo.save(product);
	}
	
	// Read
	public Product getOneProduct(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	// Update
	public Product updateProduct(Product product) {
		return this.pRepo.save(product);
	}

	// Delete
	public String deleteProduct(Long id) {
		this.pRepo.deleteById(id);
		return "Product " + id + " has been deleted.";
	}
	
	// Add Category to Product
	public void addCategory(Product product, Category category) {
		List<Category> currentCategories = product.getCategories();
		currentCategories.add(category);
		this.pRepo.save(product);
	}
}
