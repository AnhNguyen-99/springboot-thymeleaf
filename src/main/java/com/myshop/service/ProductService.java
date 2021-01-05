package com.myshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.converter.ProductConverter;
import com.myshop.dto.ProductDTO;
import com.myshop.entity.Product;
import com.myshop.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductDTO> getAll(){
		List<ProductDTO> listDTO = new ArrayList<>();
		List<Product> list = productRepository.findAll();
		ProductConverter productConverter = new ProductConverter();
		for (Product product : list) {
			ProductDTO productDTO = productConverter.toProductDTO(product);
			listDTO.add(productDTO);
		}
		return listDTO;
	}
	
	public ProductDTO findById(int productId) {
		ProductConverter productConverter = new ProductConverter();
		Product product = productRepository.findByProductId(productId);
		return productConverter.toProductDTO(product);
	}
	
}
