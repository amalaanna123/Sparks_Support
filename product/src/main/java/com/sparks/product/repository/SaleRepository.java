package com.sparks.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sparks.product.entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {
	
}

