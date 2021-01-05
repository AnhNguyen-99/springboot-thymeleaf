package com.myshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.converter.ProducerConverter;
import com.myshop.dto.ProducerDTO;
import com.myshop.entity.Producer;
import com.myshop.repository.ProducerRepository;

@Service
public class ProducerService {

	@Autowired
	private ProducerRepository producerRepository;
	
	public List<ProducerDTO> getAll(){
		List<ProducerDTO> listDTO = new ArrayList<>();
		List<Producer> list = producerRepository.findAll();
		ProducerConverter producerConverter = new ProducerConverter();
		for (Producer producer : list) {
			ProducerDTO producerDTO = producerConverter.toProducerDTO(producer);
			listDTO.add(producerDTO);
		}
		return listDTO;
	}
	
	public ProducerDTO findByProducerId(int producerId) {
		ProducerConverter producerConverter = new ProducerConverter();
		Producer producer = producerRepository.findByProducerId(producerId);
		ProducerDTO producerDTO = producerConverter.toProducerDTO(producer);
		return producerDTO;
	}
	
	public ProducerDTO save(ProducerDTO producerDTO) {
		Producer producer = new Producer();
		Producer oldProducer = new Producer();
		ProducerConverter producerConverter = new ProducerConverter();
		if(producerDTO.getProducerId() != null) {
			oldProducer = producerRepository.findByProducerId(producerDTO.getProducerId());
			producer = producerConverter.toProducerEntity(oldProducer, producerDTO);
		}else {
			producer = producerConverter.toProducerEntity(producerDTO);
		}
		producer = producerRepository.save(producer);
		return producerConverter.toProducerDTO(producer);
	}
	
}
