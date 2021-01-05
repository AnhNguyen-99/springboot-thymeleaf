package com.myshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.dto.ProducerDTO;
import com.myshop.service.ProducerService;

@RestController
@RequestMapping("/api/producer")
public class ProducerAPI {

	@Autowired
	private ProducerService producerService;
	
	@GetMapping("")
	public ResponseEntity<List<ProducerDTO>> getAll(){
		List<ProducerDTO> list = producerService.getAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping("")
	public ResponseEntity<?> createProducer(@RequestBody ProducerDTO producerDTO){
		ProducerDTO producerDTO2 = producerService.save(producerDTO);
		if(producerDTO2 != null)
			return ResponseEntity.ok().body("Thành công!!");
		else
			return ResponseEntity.ok().body("Thất bại!!!");
	}
	
	@GetMapping("/{producerId}")
	public ResponseEntity<ProducerDTO> findByProducerId(@PathVariable("producerId") int producerId){
		ProducerDTO producerDTO = producerService.findByProducerId(producerId);
		return ResponseEntity.ok().body(producerDTO);
	}
	
	@PutMapping("/{producerId}")
	public ResponseEntity<?> updateProducer(@RequestBody ProducerDTO producerDTO, @PathVariable("producerId") int producerId){
		producerDTO.setProducerId(producerId);
		ProducerDTO producerDTO2 = producerService.save(producerDTO);
		if(producerDTO2 != null)
			return ResponseEntity.ok().body("Thành công !!!");
		else
			return ResponseEntity.ok().body("Thất bại!!!");
	}
}
