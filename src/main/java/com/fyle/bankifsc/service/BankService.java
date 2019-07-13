package com.fyle.bankifsc.service;

import com.fyle.bankifsc.model.Bank;
import com.fyle.bankifsc.repository.BankRepository;
import com.fyle.bankifsc.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Service
public class BankService {
    @PersistenceContext
    private EntityManager entityManager;

    BranchRepository branchRepository;

    @Autowired
    BankRepository repository;

    public Bank createBankDetails(Bank bank) {
        return repository.save(bank);
    }

    public Bank getBankDetailsByIFSCCode(Integer ifscCode) {
        return branchRepository.findById(ifscCode).get().getBank();
    }

    public Bank getBankDetailsByName(String Name) {
        TypedQuery<Bank> query = entityManager.createQuery("select b from Bank b where b.name = ?1", Bank.class);
        query.setParameter(1, Name);

        return query.getSingleResult();
    }

    /*
    Bank getBankDetailsById(Integer Id) {
        return repository.findById(Id).get();
    }
    */

    /*
        Bank updateBankDetails(Bank bank) {
        return createBankDetails(bank);
    }
    */

    /*
        boolean deleteBankDetailsById(Integer id) {
        repository.deleteById(id);
        return Objects.isNull(getBankDetailsById(id));
    }
    */

    /*
     * public List<Bank> getAllBanksDetailsByNameAndCity(String name) {
     * Optional<Bank> bank = null; bank = repository.findOne(example); }
     */
}