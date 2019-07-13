package com.fyle.bankifsc.service;

import com.fyle.bankifsc.model.Bank;
import com.fyle.bankifsc.model.Branch;
import com.fyle.bankifsc.repository.BranchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BranchService {
	@Autowired
	BranchRepository branchRepository;
	@Autowired
	BranchRepository bankRepository;

	BankService bankService = new BankService();

	public Branch createBranchDetails(Branch branch) {
		return branchRepository.save(branch);
	}

	public Branch getBranchDetailsById(Integer ifsc) {
		Optional<Branch> branch = null;
		try {
			branch = branchRepository.findById(ifsc);
			return branch.get();
		} catch (Exception ex) {
			return null;
		}
	}

	

	@SuppressWarnings("unlikely-arg-type")
	public List<Branch> getAllBranchDetailsByNameandCity(String bankName, String city) {
		Bank bank = null;
		try {
			bank = bankService.findByName(bankName);
			int bankId = bank.getId();
			return branchRepository.findAll().stream().filter(branch -> branch.getBankId().equals(bankId))
					.collect(Collectors.toList());

		} catch (Exception ex) {
			return null;
		}
	}

	public Branch updateBranchDetails(Branch branch) {
		return createBranchDetails(branch);
	}

	public boolean deleteBranchDetailsByIfsc(Integer ifsc) {
		branchRepository.deleteById(ifsc);
		return Objects.isNull(getBranchDetailsById(ifsc));
	}

	/*
	 * public List<Bank> getAllBanksDetailsByNameAndCity(String name, String city) {
	 * return repository.findAll().stream().filter(bank ->
	 * bank.getName().equals(name) && bank.getCity().equals(city))
	 * .collect(Collectors.toList());
	 */
}