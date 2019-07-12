package com.fyle.bankifsc.service;

import com.fyle.bankifsc.model.Bank;
import com.fyle.bankifsc.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BankService {
    @Autowired
    BankRepository repository;

    public Bank createBankDetails(Bank bank) {
        return repository.save(bank);
    }

    public Optional<Bank> getBankDetailsByIFSCCode(String IFSCCode) {
        return repository.findById(IFSCCode);
    }

    public Bank updateBankDetails(Bank bank) {
        return createBankDetails(bank);
    }

    public boolean deleteBankDetailsByIFSCCode(String id) {
        repository.deleteById(id);
        return !getBankDetailsByIFSCCode(id).isPresent();
    }

    public List<Bank> getAllBanksDetailsByNameAndCity(String name, String city) {
        return repository.findAll()
                .stream()
                .filter(bank -> bank.getName().equals(name)
                        && bank.getCity().equals(city))
                .collect(Collectors.toList());
    }
}