package com.myshop.converter;

import com.myshop.dto.BannerDTO;
import com.myshop.entity.Banner;

public class BannerConverter {

	public BannerDTO toBannerDTO(Banner banner) {
		BannerDTO bannerDTO = new BannerDTO();
		bannerDTO.setBannerId(banner.getBannerId());
		bannerDTO.setImage(banner.getImage());
		bannerDTO.setStatus(banner.getStatus());
		bannerDTO.setCreateDate(banner.getCreateDate());
		bannerDTO.setUpdateDate(banner.getUpdateDate());
		return bannerDTO;
	}
	
	public Banner toBannerEntity(BannerDTO bannerDTO) {
		Banner banner = new Banner();
//		banner.setBannerId(bannerDTO.getBannerId());
		banner.setImage(bannerDTO.getImage());
		banner.setStatus(bannerDTO.getStatus());
		banner.setCreateDate(bannerDTO.getCreateDate());
		banner.setUpdateDate(bannerDTO.getUpdateDate());
		return banner;
	}
	
	public Banner toBannerEntity(Banner banner, BannerDTO bannerDTO) {
		banner.setImage(bannerDTO.getImage());
		banner.setStatus(bannerDTO.getStatus());
		banner.setCreateDate(bannerDTO.getCreateDate());
		banner.setUpdateDate(bannerDTO.getUpdateDate());
		return banner;
	}
}
