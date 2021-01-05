package com.myshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.dto.CategoryDTO;
import com.myshop.service.CategoryService;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = "http://localhost:8080")
public class CategoryAPI {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("")
	public ResponseEntity<List<CategoryDTO>> getAll(){
		List<CategoryDTO> list = categoryService.getAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping("")
	public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO){
		CategoryDTO categoryDTO2 = categoryService.save(categoryDTO);
		if(categoryDTO2 == null) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(categoryDTO2, HttpStatus.OK);
	}
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<?> getCategoryById(@PathVariable("categoryId")int categoryId){
		CategoryDTO categoryDTO = categoryService.findByCategoryId(categoryId);
		if(categoryDTO == null)
			return ResponseEntity.notFound().build();
		else
			return new ResponseEntity<CategoryDTO>(categoryDTO, HttpStatus.OK);
	}
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<?> updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable("categoryId") int categoryId){
//		CategoryDTO categoryDTO3 = categoryService.findByCategoryId(categoryId);
////		categoryDTO.setCategoryId(categoryId);
//		CategoryDTO categoryDTO4 = new CategoryDTO();
//		categoryDTO4 = categoryDTO3;
//		categoryDTO4.setCategoryName(categoryDTO.getCategoryName());
//		categoryDTO4.setAccountId(categoryDTO.getAccountId());
		CategoryDTO categoryDTO2 = categoryService.save(categoryDTO);
		if(categoryDTO2 == null) 
			return ResponseEntity.ok().body("Thất bại!");
		else
			return new ResponseEntity<CategoryDTO>(categoryDTO2, HttpStatus.OK);
	}
	
	@DeleteMapping("/{categoryId}")
	public void deleteCategory(@PathVariable("categoryId")int categoryId){
		categoryService.deleteCategory(categoryId);
	}
}
