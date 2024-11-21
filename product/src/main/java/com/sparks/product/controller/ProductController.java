package com.sparks.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sparks.product.entity.Product;
import com.sparks.product.exception.ProductNotFoundException;
import com.sparks.product.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable int id) throws ProductNotFoundException {
		return productService.getProductById(id);
	}
	
	@GetMapping("/")
	public Page<Product> getAllProducts(@RequestParam int size, @RequestParam int pageNumber) {
		return productService.getAllProducts(size, pageNumber);
	}
	
	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable int id, @RequestBody Product product) throws ProductNotFoundException {
		return productService.updateProduct(id, product);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id) throws ProductNotFoundException {
		productService.deleteProduct(id);
		return ResponseEntity.ok("Product deleted successfully");
	}
	
	@GetMapping("/revenue")
	public double getTotalRevenue() {
		return productService.getTotalRevenue();
	}
	
	@GetMapping("/revenue/{id}")
	public double getRevenueByProduct(@PathVariable int id) {
		return productService.getRevenueByProduct(id);
	}
}
