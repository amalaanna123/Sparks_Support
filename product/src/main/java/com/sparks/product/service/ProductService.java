package com.sparks.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sparks.product.entity.Product;
import com.sparks.product.exception.ProductNotFoundException;
import com.sparks.product.repository.ProductRepository;
import com.sparks.product.repository.SaleRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private SaleRepository saleRepository;

	public Product getProductById(int id) throws ProductNotFoundException {
		return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));	
	}

	public Page<Product> getAllProducts(int size, int pageNumber) {
		PageRequest pageable = PageRequest.of(pageNumber, size);
		return productRepository.findAll(pageable);
	}
	
	public Product addProduct(Product product) {
		
		 if (productRepository.existsByName(product.getName())) {
	            throw new IllegalArgumentException("Product name must be unique.");
	        }
		return productRepository.save(product);
	}

	public Product updateProduct(int id, Product updatedProduct) throws ProductNotFoundException {
		//Product product = getProductById(id);
		Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
		product.setName(updatedProduct.getName());
		product.setDescription(updatedProduct.getDescription());
		product.setPrice(updatedProduct.getPrice());
		product.setQuantity(updatedProduct.getQuantity());
		return productRepository.save(product);
	}

	public void deleteProduct(int id) throws ProductNotFoundException {
		Product product = productRepository.findById(id)
	            .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));
	    productRepository.delete(product);
	}

	public double getTotalRevenue() {
		return saleRepository.findAll().stream().mapToDouble(sale -> sale.getQuantity() * sale.getProduct().getPrice())
				.sum();
	}
	
	public double getRevenueByProduct(int productId) {
		    return saleRepository.findAll().stream()
		            .filter(sale -> sale.getProduct().getId() == productId)
		            .mapToDouble(sale -> sale.getQuantity() * sale.getProduct().getPrice())
		            .sum();
		}

	}


