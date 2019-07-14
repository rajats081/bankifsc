package com.fyle.bankifsc.repository;

import com.fyle.bankifsc.model.Branch;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {

	@Query("select b from Branch b where b.id = ?1 and b.city = ?2")
	public List<Branch> getBankDetailsByNameandCity(int Id, String city);

}