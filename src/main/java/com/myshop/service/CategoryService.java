package com.myshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.converter.CategoryConverter;
import com.myshop.dto.CategoryDTO;
import com.myshop.entity.Category;
import com.myshop.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<CategoryDTO> getAll(){
		List<CategoryDTO> listDTO = new ArrayList<>();
		List<Category> list = categoryRepository.findAll();
		CategoryConverter categoryConverter = new CategoryConverter();
		for (Category category : list) {
			CategoryDTO categoryDTO = categoryConverter.toCategoryDTO(category);
			listDTO.add(categoryDTO);
		}
		return listDTO;
	}
	
	public CategoryDTO save(CategoryDTO categoryDTO) {
		Category category = new Category();
		Category oldCategoey = new Category();
		CategoryConverter categoryConverter = new CategoryConverter();
		if(categoryDTO.getCategoryId() != null) {
			oldCategoey = categoryRepository.findByCategoryId(categoryDTO.getCategoryId());
			category = categoryConverter.toCategoryEntity(oldCategoey, categoryDTO);
		}else {
			category = categoryConverter.toCategoryEntity(categoryDTO);
		}
		category = categoryRepository.save(category);
		return categoryConverter.toCategoryDTO(category);
	}
	
	public CategoryDTO findByCategoryId(int categoryId) {
		CategoryConverter categoryConverter = new CategoryConverter();
		Category category = categoryRepository.findByCategoryId(categoryId);
		CategoryDTO categoryDTO = categoryConverter.toCategoryDTO(category);
		return categoryDTO;
	}
	
	public void deleteCategory(int categoryId) {
		categoryRepository.deleteById(categoryId);
	}
	
}
