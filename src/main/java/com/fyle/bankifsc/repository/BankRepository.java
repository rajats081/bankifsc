package com.fyle.bankifsc.repository;

import com.fyle.bankifsc.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {

	@Query("select b from Bank b where b.name = ?1")
	public Bank getBankDetailsByName(String Name);

}