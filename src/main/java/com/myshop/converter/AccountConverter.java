package com.myshop.converter;

import com.myshop.dto.AccountDTO;
import com.myshop.entity.Account;

public class AccountConverter {

	public AccountDTO toAccountDTO(Account account) {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountId(account.getAccountId());
		accountDTO.setAccountName(account.getAccountName());
		accountDTO.setAccountPass(account.getAccountPass());
		accountDTO.setAddress(account.getAddress());
		accountDTO.setFullName(account.getFullName());
		accountDTO.setMobile(account.getMobile());
		accountDTO.setMail(account.getMail());
		accountDTO.setStatus(account.getStatus());
		accountDTO.setCreateDate(account.getCreateDate());
		accountDTO.setUpdateDate(account.getUpdateDate());
		return accountDTO;
	}
	
	public Account toAccountEntity(AccountDTO accountDTO) {
		Account account = new Account();
		account.setAccountName(accountDTO.getAccountName());
		account.setAccountPass(accountDTO.getAccountPass());
		account.setFullName(accountDTO.getFullName());
		account.setAddress(accountDTO.getAddress());
		account.setMail(accountDTO.getMail());
		account.setMobile(accountDTO.getMobile());
		account.setStatus(accountDTO.getStatus());
		account.setCreateDate(accountDTO.getCreateDate());
		account.setUpdateDate(accountDTO.getUpdateDate());
		return account;
	}
	
	public Account toAccountEntity(Account account, AccountDTO accountDTO) {
		account.setAccountName(accountDTO.getAccountName());
		account.setAccountPass(accountDTO.getAccountPass());
		account.setFullName(accountDTO.getFullName());
		account.setAddress(accountDTO.getAddress());
		account.setMail(accountDTO.getMail());
		account.setMobile(accountDTO.getMobile());
		account.setStatus(accountDTO.getStatus());
		account.setCreateDate(accountDTO.getCreateDate());
		account.setUpdateDate(accountDTO.getUpdateDate());
		return account;
	}
}
