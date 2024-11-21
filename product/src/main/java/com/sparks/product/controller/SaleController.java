package com.sparks.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparks.product.entity.Sale;
import com.sparks.product.exception.ProductNotFoundException;
import com.sparks.product.exception.SaleNotFoundException;
import com.sparks.product.service.SaleService;

@RestController
@RequestMapping("/api/sales")
public class SaleController {
	@Autowired
	private SaleService saleService;

	@GetMapping("/{id}")
	public Sale getSaleById(@PathVariable int id) throws SaleNotFoundException {
		return saleService.getSaleById(id);
	}
	
	@PostMapping("/")
	public Sale addSale(@RequestBody Sale sale) throws SaleNotFoundException, ProductNotFoundException {
		return saleService.addSale(sale);
	}



}
