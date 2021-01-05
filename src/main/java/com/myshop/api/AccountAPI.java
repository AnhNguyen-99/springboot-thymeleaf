package com.myshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.dto.AccountDTO;
import com.myshop.service.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountAPI {

	@Autowired
	private AccountService accountService;
	
	@GetMapping("")
	public ResponseEntity<List<AccountDTO>> getAll(){
		List<AccountDTO> list = accountService.getAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{accountId}")
	public ResponseEntity<AccountDTO> findByAccountId(@PathVariable("accountId") int accountId){
		AccountDTO accountDTO = accountService.findByAccountId(accountId);
		return ResponseEntity.ok().body(accountDTO);
	}
	
	@RequestMapping("/totalrecord")
	public ResponseEntity<?> totalRecord(){
		List<AccountDTO> list = accountService.getAll();
		int size = list.size();
		return ResponseEntity.ok().body(size);
	}

}
