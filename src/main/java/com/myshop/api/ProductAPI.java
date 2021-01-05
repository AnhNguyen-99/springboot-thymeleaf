package com.myshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.dto.ProductDTO;
import com.myshop.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductAPI {

	@Autowired
	private ProductService productService;
	
	@GetMapping("")
	public ResponseEntity<List<ProductDTO>> getAll(){
		List<ProductDTO> list = productService.getAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<ProductDTO> findById(@PathVariable("productId")int productId){
		ProductDTO productDTO = productService.findById(productId);
		return ResponseEntity.ok().body(productDTO);
	}
}
