package com.myshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.converter.BannerConverter;
import com.myshop.dto.BannerDTO;
import com.myshop.entity.Banner;
import com.myshop.repository.BannerRepository;

@Service
public class BannerService {

	@Autowired
	private BannerRepository bannerRepository;
	
	public List<BannerDTO> getAll(){
		List<BannerDTO> listDTO = new ArrayList<>();
		List<Banner> list = bannerRepository.findAll();
		BannerConverter bannerConverter = new BannerConverter();
		for (Banner banner : list) {
			BannerDTO bannerDTO = bannerConverter.toBannerDTO(banner);
			listDTO.add(bannerDTO);
		}
		return listDTO;
	}
	
	public BannerDTO findByBannerId(int bannerId) {
		BannerConverter bannerConverter = new BannerConverter();
		Banner banner = bannerRepository.findByBannerId(bannerId);
		return bannerConverter.toBannerDTO(banner);
	}
	
	public BannerDTO save(BannerDTO bannerDTO) {
		Banner banner = new Banner();
		Banner oldBanner = new Banner();
		BannerConverter bannerConverter = new BannerConverter();
		if(bannerDTO.getBannerId() != null) {
			oldBanner = bannerRepository.findByBannerId(banner.getBannerId());
			banner = bannerConverter.toBannerEntity(oldBanner, bannerDTO);
		}else {
			banner = bannerConverter.toBannerEntity(bannerDTO);
		}
		banner = bannerRepository.save(banner);
		return bannerConverter.toBannerDTO(banner);
	}
}
