package com.myshop.converter;

import com.myshop.dto.NewsDTO;
import com.myshop.entity.Account;
import com.myshop.entity.News;

public class NewsConverter {

	public NewsDTO toNewDTO(News news) {
		NewsDTO newsDTO = new NewsDTO();
		newsDTO.setNewsId(news.getNewsId());
		newsDTO.setTitle(news.getTitle());
		newsDTO.setContent(news.getContent());
		newsDTO.setImage(news.getImage());
		newsDTO.setStatus(news.getStatus());
		newsDTO.setCreateDate(news.getCreateDate());
		newsDTO.setAccountId(news.getAccount().getAccountId());
		newsDTO.setAccountName(news.getAccount().getAccountName());
		return newsDTO;
	}
	
	public News toNewsEntity(NewsDTO newsDTO) {
		News news = new News();
		news.setTitle(news.getTitle());
		news.setContent(news.getContent());
		news.setImage(news.getImage());
		news.setStatus(news.getStatus());
		news.setCreateDate(news.getCreateDate());
		Account account = new Account();
		news.setAccount(account);
		return news;
	}
	
	public News toNewsEntity(News news, NewsDTO newsDTO) {
		news.setTitle(news.getTitle());
		news.setContent(news.getContent());
		news.setImage(news.getImage());
		news.setStatus(news.getStatus());
		news.setCreateDate(news.getCreateDate());
		Account account = new Account();
		news.setAccount(account);
		return news;
	}
}
