package com.sparks.product.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparks.product.entity.Product;
import com.sparks.product.entity.Sale;
import com.sparks.product.exception.ProductNotFoundException;
import com.sparks.product.exception.SaleNotFoundException;
import com.sparks.product.repository.ProductRepository;
import com.sparks.product.repository.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository saleRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductService productService;

	public Sale getSaleById(int id) throws SaleNotFoundException {
		return saleRepository.findById(id).orElseThrow(() -> new SaleNotFoundException("Sale not found"));	
	}

	public Sale addSale(Sale sale) throws ProductNotFoundException {

		sale.setSaleDate(LocalDate.now());

		Product product = productService.getProductById(sale.getProduct().getId());

		if (sale.getQuantity() > product.getQuantity()) {
			throw new IllegalArgumentException("Sale quantity exceeds available product quantity");
		}

		product.setQuantity(product.getQuantity() - sale.getQuantity());

		productRepository.save(product);

		sale.setProduct(product);

		return saleRepository.save(sale);
	}

}