package com.myshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myshop.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	Account findByAccountName(String accountName);
	Account findByAccountId(Integer accountId);
	
	@Query(value = "SELECT e FROM Account e WHERE e.accountName = :accountName and e.accountPass = :accountPass")
	Account login(@Param("accountName") String accountName, @Param("accountPass") String accountPass);
}
