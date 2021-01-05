package com.myshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.converter.NewsConverter;
import com.myshop.dto.NewsDTO;
import com.myshop.entity.News;
import com.myshop.repository.NewsRepository;

@Service
public class NewsService {

	@Autowired
	private NewsRepository newsRepository;
	
	public List<NewsDTO> getAll(){
		List<NewsDTO> listDTO = new ArrayList<>();
		List<News> list = newsRepository.findAll();
		NewsConverter newsConverter = new NewsConverter();
		for (News news : list) {
			NewsDTO newsDTO = newsConverter.toNewDTO(news);
			listDTO.add(newsDTO);
		}
		return listDTO;
	}
	
	public NewsDTO findByNewsId(int newsId) {
		NewsConverter newsConverter = new NewsConverter();
		News news = newsRepository.findByNewsId(newsId);
		return newsConverter.toNewDTO(news);
	}
	
	public NewsDTO save(NewsDTO newsDTO) {
		News news = new News();
		News oldNews = new News();
		NewsConverter newsConverter = new NewsConverter();
		if(newsDTO.getNewsId() != null) {
			oldNews = newsRepository.findByNewsId(newsDTO.getNewsId());
			news = newsConverter.toNewsEntity(oldNews, newsDTO);
		}else {
			news = newsConverter.toNewsEntity(newsDTO);
		}
		news = newsRepository.save(news);
		return newsConverter.toNewDTO(news);
	}
}
