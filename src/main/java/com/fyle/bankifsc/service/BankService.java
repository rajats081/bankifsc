package com.fyle.bankifsc.service;

import com.fyle.bankifsc.model.Bank;
import com.fyle.bankifsc.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BankService {
    @Autowired
    BankRepository repository;

    public Bank createBankDetails(Bank bank) {
        return repository.save(bank);
    }

    public Bank getBankDetailsByIFSCCode(Integer IFSCCode) {
        Optional<Bank> bank = null;
        try {
            bank = repository.findById(IFSCCode);
            return bank.get();
        } catch (Exception ex) {
            return null;
        }
    }

    public Bank updateBankDetails(Bank bank) {
        return createBankDetails(bank);
    }

    public boolean deleteBankDetailsByIFSCCode(Integer id) {
        repository.deleteById(id);
        return Objects.isNull(getBankDetailsByIFSCCode(id));
    }

    public List<Bank> getAllBanksDetailsByNameAndCity(String name, String city) {
        return repository.findAll()
                .stream()
                .filter(bank -> bank.getName().equals(name)
                        && bank.getCity().equals(city))
                .collect(Collectors.toList());
    }
}