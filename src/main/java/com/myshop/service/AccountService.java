package com.myshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.converter.AccountConverter;
import com.myshop.dto.AccountDTO;
import com.myshop.entity.Account;
import com.myshop.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	public List<AccountDTO> getAll() {
		List<AccountDTO> listDTO = new ArrayList<>();
		List<Account> list = accountRepository.findAll();
		AccountConverter accountConverter = new AccountConverter();
		for (Account account : list) {
			AccountDTO accountDTO = accountConverter.toAccountDTO(account);
			listDTO.add(accountDTO);
		}
		return listDTO;
	}
	
	public AccountDTO findByAccountId(int accountId) {
		AccountConverter accountConverter = new AccountConverter();
		Account account = accountRepository.findByAccountId(accountId);
		return accountConverter.toAccountDTO(account);
	}
}
