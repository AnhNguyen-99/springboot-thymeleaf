package com.myshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.dto.OrderDTO;
import com.myshop.service.OrderService;

@RestController
@RequestMapping(value = "/api/order")
@CrossOrigin(origins = "http://localhost:8080")
public class OrderAPI {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("")
	public ResponseEntity<List<OrderDTO>> getAll(){
		List<OrderDTO> list = orderService.getAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<?> getCategoryById(@PathVariable("orderId")int orderId){
		OrderDTO orderDTO = orderService.findById(orderId);
		if(orderDTO == null)
			return ResponseEntity.notFound().build();
		else
			return new ResponseEntity<OrderDTO>(orderDTO, HttpStatus.OK);
	}
	
	@GetMapping("/totalrecord")
	public ResponseEntity<?> totalRecord(){
		List<OrderDTO> list = orderService.getAll();
		int size = list.size();
		return ResponseEntity.ok().body(size);
	}
}
