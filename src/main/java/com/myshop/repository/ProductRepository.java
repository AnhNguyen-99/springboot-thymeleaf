package com.myshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myshop.entity.Category;
import com.myshop.entity.Producer;
import com.myshop.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByProductId(int productId);
	Product findByProductName(String productName);
	List<Product> findByProducer(Producer producer);
	List<Category> findByCategory(Category category);
	
}
