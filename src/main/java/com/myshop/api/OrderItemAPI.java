package com.myshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.dto.OrderItemDTO;
import com.myshop.service.OrderItemService;

@RestController
@RequestMapping(value = "/api/orderItem")
@CrossOrigin(origins = "http://localhost:8080")
public class OrderItemAPI {

	@Autowired
	private OrderItemService orderItemService;
	
	@GetMapping("/{orderId}")
	public ResponseEntity<List<OrderItemDTO>> getAll(@PathVariable("orderId") int orderId){
		List<OrderItemDTO> list = orderItemService.findByOrderId(orderId);
		return ResponseEntity.ok().body(list);
	}
}
