package com.codingdojo.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;
import com.codingdojo.products.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository cRepo;
	
	// Display All
		public List<Category> AllCategorys(){
			return this.cRepo.findAll();
		}
		
		// Create
		public Category createCategory(Category category) {
			return this.cRepo.save(category);
		}
		
		// Read
		public Category getOneCategory(Long id) {
			return this.cRepo.findById(id).orElse(null);
		}
		
		// Update
		public Category updateCategory(Category category) {
			return this.cRepo.save(category);
		}
		
		// Delete
		public String deleteCategory(Long id) {
			this.cRepo.deleteById(id);
			return "Category " + id + " has been deleted.";
		}
		
		// Product to Category
		public void addProduct(Category category, Product product) {
			List<Product> currentProducts = category.getProducts();
			currentProducts.add(product);
			this.cRepo.save(category);
		}
}
