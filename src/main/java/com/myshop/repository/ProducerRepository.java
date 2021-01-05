package com.myshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myshop.entity.Producer;
@Repository
public interface ProducerRepository extends JpaRepository<Producer, Integer>{

	Producer findByProducerId(int producerId);
	Producer findByProducerName(String producerName);
	
}
