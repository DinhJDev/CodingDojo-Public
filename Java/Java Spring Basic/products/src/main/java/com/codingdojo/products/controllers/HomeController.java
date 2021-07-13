package com.codingdojo.products.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;
import com.codingdojo.products.services.CategoryService;
import com.codingdojo.products.services.ProductService;

@Controller
public class HomeController {
	@Autowired
	private ProductService pService;
	@Autowired
	private CategoryService cService;
	
	@GetMapping("/products/new")
	public String newProduct(Model model) {
		model.addAttribute("product", new Product());
		return "newProductPage.jsp";
	}

	@PostMapping("/addProduct")
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "newProductPage.jsp";
		}
		this.pService.createProduct(product);
		return "redirect:/";
	}
	
	@GetMapping("/categories/new")
	public String newCategory(Model model) {
		model.addAttribute("category", new Category());
		return "newCategoryPage.jsp";
	}

	@PostMapping("/addCategory")
	public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "newCategoryPage.jsp";
		}
		this.cService.createCategory(category);
		return "redirect:/";
	}
	
	@GetMapping("/products/{id}")
	public String getProduct(@PathVariable("id") Long id, Model model) {
		model.addAttribute("product", this.pService.getOneProduct(id));
		model.addAttribute("allCategories", this.cService.AllCategorys());
		return "productPage.jsp";
	}
	@PostMapping("/setCategory/{id}")
	public String setCategory(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model, @RequestParam(value="categories") Long cId, @PathVariable("id") Long id) {
		Category categoryForProduct = this.cService.getOneCategory(cId);
		Product currentProduct = this.pService.getOneProduct(id);
		this.pService.addCategory(currentProduct, categoryForProduct);		
		return "redirect:/products/" + id;
	}
	
	@GetMapping("categories/{id}")
	public String getCategory(@PathVariable("id") Long id, Model model) {
		model.addAttribute("category", this.cService.getOneCategory(id));
		model.addAttribute("allProducts", this.pService.AllProducts());
		return "categoryPage.jsp";
	}
	@PostMapping("/setProduct/{id}")
	public String setProduct(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model, @RequestParam(value="products") Long pId, @PathVariable("id") Long id) {
		Product productForCategory = this.pService.getOneProduct(pId);
		Category currentCategory = this.cService.getOneCategory(id);
		this.cService.addProduct(currentCategory, productForCategory);
		return "redirect:/categories/" + id;
	}
}
