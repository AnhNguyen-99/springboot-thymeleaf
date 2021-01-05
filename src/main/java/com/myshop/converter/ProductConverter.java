package com.myshop.converter;

import com.myshop.dto.ProductDTO;
import com.myshop.entity.Account;
import com.myshop.entity.Category;
import com.myshop.entity.Producer;
import com.myshop.entity.Product;

public class ProductConverter {

	public ProductDTO toProductDTO(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductId(product.getProductId());
		productDTO.setProductName(product.getProductName());
		productDTO.setProductImage(product.getProductImage());
		productDTO.setProductPrice(product.getProductPrice());
		productDTO.setProductSale(product.getProductSale());
		productDTO.setContent(product.getContent());
		productDTO.setProductDescription(product.getProductDescription());
		productDTO.setStatus(product.getStatus());
		productDTO.setCreateDate(product.getCreateDate());
		productDTO.setUpdateDate(product.getUpdateDate());
		productDTO.setAccountId(product.getAccount().getAccountId());
		productDTO.setProducerId(product.getProducer().getProducerId());
		productDTO.setCategoryId(product.getCategory().getCategoryId());
		return productDTO;
	}
	
	public Product toProductEntity(ProductDTO productDTO) {
		Product product = new Product();
		product.setProductId(productDTO.getProductId());
		product.setProductName(productDTO.getProductName());
		product.setProductImage(productDTO.getProductImage());
		product.setProductPrice(productDTO.getProductPrice());
		product.setProductSale(productDTO.getProductSale());
		product.setContent(productDTO.getContent());
		product.setCreateDate(productDTO.getCreateDate());
		product.setUpdateDate(productDTO.getUpdateDate());
		Account account = new Account(productDTO.getAccountId());
		product.setAccount(account);
		Category category = new Category(productDTO.getCategoryId());
		product.setCategory(category);
		Producer producer = new Producer(productDTO.getProducerId());
		product.setProducer(producer);
		return product;
	}
}
