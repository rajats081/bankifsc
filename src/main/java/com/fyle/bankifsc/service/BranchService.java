package com.fyle.bankifsc.service;

import com.fyle.bankifsc.model.Bank;
import com.fyle.bankifsc.model.Branch;
import com.fyle.bankifsc.repository.BankRepository;
import com.fyle.bankifsc.repository.BranchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchService {
    @Autowired
    BranchRepository branchRepository;

    BankService bankService = new BankService();

    public Branch createBranchDetails(Branch branch) {
        return branchRepository.save(branch);
    }

    public Branch getBranchDetailsByIFSC(Integer ifsc) {
        return branchRepository.findById(ifsc).get();
    }

    public List<Branch> getAllBranchDetailsByNameAndCity(String bankName, String city) {
        int bankId = bankService.getBankDetailsByName(bankName)
                .getId();

        return branchRepository.findAll()
                .stream()
                .filter(branch -> branch
                        .getBank()
                        .equals(bankId))
                .collect(Collectors
                        .toList());
    }

    /*
    public boolean deleteBranchDetailsByIfsc(Integer ifsc) {
        branchRepository.deleteById(ifsc);
        return Objects.isNull(getBranchDetailsByIFSC(ifsc));
    }
    */

     /*
    public Branch updateBranchDetails(Branch branch) {
        return createBranchDetails(branch);
    }
    */

    /*
     * public List<Bank> getAllBanksDetailsByNameAndCity(String name, String city) {
     * return repository.findAll().stream().filter(bank ->
     * bank.getName().equals(name) && bank.getCity().equals(city))
     * .collect(Collectors.toList());
     */
}