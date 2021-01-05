package com.myshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.dto.BannerDTO;
import com.myshop.service.BannerService;

@RestController
@CrossOrigin(origins="*", maxAge = 3600)
@RequestMapping(value = "/api/banner")
public class BannerAPI {
	
	@Autowired
	private BannerService bannerService;

	@GetMapping("")
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<List<BannerDTO>> getAll(){
		List<BannerDTO> list = bannerService.getAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping("")
	public ResponseEntity<?> createBanner(@RequestBody BannerDTO bannerDTO){
		BannerDTO bannerDTO2 = bannerService.save(bannerDTO);
		if(bannerDTO2 != null)
			return ResponseEntity.ok().body("Thành công");
		else
			return ResponseEntity.ok().body("Thất bại");
	}
	
	@GetMapping("/{bannerId}")
	public ResponseEntity<BannerDTO> findByBannerId(@PathVariable("bannerId") int bannerId){
		BannerDTO bannerDTO = bannerService.findByBannerId(bannerId);
		return ResponseEntity.ok().body(bannerDTO);
	}
	
	@PutMapping("/{bannerId}")
	public ResponseEntity<?> updateBanner(@RequestBody BannerDTO bannerDTO, @PathVariable("bannerId") int bannerId){
		bannerDTO.setBannerId(bannerId);
		BannerDTO bannerDTO2 = bannerService.save(bannerDTO);
		if(bannerDTO2 != null)
			return ResponseEntity.ok().body("Thành công!!!");
		else
			return ResponseEntity.ok().body("Thất bại!!!");
	}
	
}
