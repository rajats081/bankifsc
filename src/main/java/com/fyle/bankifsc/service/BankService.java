package com.fyle.bankifsc.service;

import com.fyle.bankifsc.model.Bank;
import com.fyle.bankifsc.model.Branch;
import com.fyle.bankifsc.repository.BankRepository;
import com.fyle.bankifsc.repository.BranchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Service
public class BankService {
	
	@PersistenceContext
	private EntityManager em;
	BranchRepository branchRepository;
	@Autowired
	BankRepository repository;

	public Bank createBankDetails(Bank bank) {
		return repository.save(bank);
	}

	public Bank getBankDetailsById(Integer Id) {
		Optional<Bank> bank = null;
		try {
			bank = repository.findById(Id);
			return bank.get();
		} catch (Exception ex) {
			return null;
		}
	}
	
	public Bank getBankDetailsByIFSCCode(Integer ifscCode) {
		Optional<Branch> branch = null;
		Bank bank = null;
		try {
			branch = branchRepository.findById(ifscCode);
			bank = branch.get().getBankId();
			return bank;
		} catch (Exception ex) {
			return null;
		}
	}

	public Bank updateBankDetails(Bank bank) {
		return createBankDetails(bank);
	}

	public boolean deleteBankDetailsById(Integer id) {
		repository.deleteById(id);
		return Objects.isNull(getBankDetailsById(id));
	}

	/*
	 * public List<Bank> getAllBanksDetailsByNameAndCity(String name) {
	 * Optional<Bank> bank = null; bank = repository.findOne(example); }
	 */
	  public Bank findByName(String Name) {
	    TypedQuery<Bank> query = em.createQuery("select b from Bank b where b.name = ?1", Bank.class);
	    query.setParameter(1, Name);
	    return query.getSingleResult();
	  }
	
	

}