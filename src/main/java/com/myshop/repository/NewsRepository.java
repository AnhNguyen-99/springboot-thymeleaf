package com.myshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myshop.entity.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer>{

	News findByNewsId(int newsId);
}
