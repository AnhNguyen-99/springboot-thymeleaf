package com.myshop.converter;

import java.util.Calendar;

import com.myshop.dto.CategoryDTO;
import com.myshop.entity.Account;
import com.myshop.entity.Category;

public class CategoryConverter {

	public CategoryDTO toCategoryDTO(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO();
		Calendar calendar = Calendar.getInstance();
		category.setCreateDate(calendar.getTime());
		category.setUpdateDate(calendar.getTime());
		categoryDTO.setCategoryId(category.getCategoryId());
		categoryDTO.setCategoryName(category.getCategoryName());
		categoryDTO.setAccountId(category.getAccount().getAccountId());
		categoryDTO.setAccountName(category.getAccount().getAccountName());
		categoryDTO.setStatus(category.getStatus());
		categoryDTO.setCreateDate(category.getCreateDate());
		categoryDTO.setUpdateDate(category.getUpdateDate());
		return categoryDTO;
	}
	
	public Category toCategoryEntity(CategoryDTO categoryDTO) {
		Category category = new Category();
		category.setCategoryName(categoryDTO.getCategoryName());
		Account account = new Account(categoryDTO.getAccountId());
		category.setAccount(account);
		Calendar calendar = Calendar.getInstance();
		category.setCreateDate(calendar.getTime());
		category.setUpdateDate(calendar.getTime());
		return category;
	}
	
	public Category toCategoryEntity(Category category, CategoryDTO categoryDTO) {
		category.setCategoryName(categoryDTO.getCategoryName());
		Account account = new Account(categoryDTO.getAccountId());
		category.setAccount(account);
		category.setCreateDate(categoryDTO.getCreateDate());
		Calendar calendar = Calendar.getInstance();
		category.setUpdateDate(calendar.getTime());
		return category;
	}
	
}
