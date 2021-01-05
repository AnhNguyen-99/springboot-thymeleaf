package com.myshop.converter;

import com.myshop.dto.ProducerDTO;
import com.myshop.entity.Account;
import com.myshop.entity.Producer;

public class ProducerConverter {

	public ProducerDTO toProducerDTO(Producer producer) {
		ProducerDTO producerDTO = new ProducerDTO();
		producerDTO.setProducerId(producer.getProducerId());
		producerDTO.setProducerName(producer.getProducerName());
		producerDTO.setAccountId(producer.getAccount().getAccountId());
		producerDTO.setStatus(producer.getStatus());
		producerDTO.setCreateDate(producer.getCreateDate());
		producerDTO.setUpdateDate(producer.getUpdateDate());
		return producerDTO;
	}
	
	public Producer toProducerEntity(ProducerDTO producerDTO) {
		Producer producer = new Producer();
//		producer.setProducerId(producerDTO.getProducerId());
		producer.setProducerName(producerDTO.getProducerName());
		Account account = new Account(producerDTO.getAccountId());
		producer.setAccount(account);
		producer.setStatus(producerDTO.getStatus());
		producer.setCreateDate(producerDTO.getCreateDate());
		producer.setUpdateDate(producerDTO.getUpdateDate());
		return producer;
	}
	
	public Producer toProducerEntity(Producer producer, ProducerDTO producerDTO) {
		producer.setProducerName(producerDTO.getProducerName());
		Account account = new Account(producerDTO.getAccountId());
		producer.setAccount(account);
		producer.setStatus(producerDTO.getStatus());
		producer.setCreateDate(producerDTO.getCreateDate());
		producer.setUpdateDate(producerDTO.getUpdateDate());
		return producer;
	}
}
