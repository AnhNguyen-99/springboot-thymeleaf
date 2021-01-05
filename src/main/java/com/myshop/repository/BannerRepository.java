package com.myshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myshop.entity.Banner;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Integer>{

	Banner findByBannerId(int bannerId);
	
}
