package com.fyle.bankifsc.service;

import com.fyle.bankifsc.model.Branch;
import com.fyle.bankifsc.repository.BankRepository;
import com.fyle.bankifsc.repository.BranchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {
	@Autowired
	BranchRepository branchRepository;

	@Autowired
	BankRepository bankRepository;

	public Branch createBranchDetails(Branch branch) {
		return branchRepository.save(branch);
	}

	public Branch getBranchDetailsByIFSC(Integer ifsc) {
		return branchRepository.findById(ifsc).get();
	}

	public List<Branch> getAllBranchDetailsByNameAndCity(String bankName, String city) {
		System.out.println(bankName + " " + city);
		int bankId = bankRepository.getBankDetailsByName(bankName).getId();

		return branchRepository.getBankDetailsByNameandCity(bankId, city);
	}

	/*
	 * public boolean deleteBranchDetailsByIfsc(Integer ifsc) {
	 * branchRepository.deleteById(ifsc); return
	 * Objects.isNull(getBranchDetailsByIFSC(ifsc)); }
	 */

	/*
	 * public Branch updateBranchDetails(Branch branch) { return
	 * createBranchDetails(branch); }
	 */

	/*
	 * public List<Bank> getAllBanksDetailsByNameAndCity(String name, String city) {
	 * return repository.findAll().stream().filter(bank ->
	 * bank.getName().equals(name) && bank.getCity().equals(city))
	 * .collect(Collectors.toList());
	 */
}