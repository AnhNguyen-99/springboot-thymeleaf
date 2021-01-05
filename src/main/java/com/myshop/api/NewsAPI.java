package com.myshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.dto.NewsDTO;
import com.myshop.service.NewsService;

@RestController
@RequestMapping("/api/news")
public class NewsAPI {

	@Autowired
	private NewsService newsService;
	
	@GetMapping("")
	public ResponseEntity<List<NewsDTO>> getAll(){
		List<NewsDTO> list = newsService.getAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{newsId}")
	public ResponseEntity<NewsDTO> findById(@PathVariable("newsId")int newsId){
		NewsDTO newsDTO = newsService.findByNewsId(newsId);
		return ResponseEntity.ok().body(newsDTO);
	}
}
