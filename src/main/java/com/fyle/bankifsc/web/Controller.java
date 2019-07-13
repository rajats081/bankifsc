package com.fyle.bankifsc.web;

import com.fyle.bankifsc.model.Bank;
import com.fyle.bankifsc.model.Branch;
import com.fyle.bankifsc.service.BankService;
import com.fyle.bankifsc.service.BranchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    BankService bankService;
    
    @Autowired
    BranchService branchService;
    
    //Create bank
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/banks")
    public Bank createBankDetails(@RequestBody Bank bank) {
        return bankService.createBankDetails(bank);
    }
    
    //create branch
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/branch")
    public Branch createBankDetails(@RequestBody Branch branch) {
       return branchService.createBranchDetails(branch);
    }
    
    //Fetch by id
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/banks/{IFSCCode}")
    public Bank getBankByIFSCCode(@PathVariable Integer  IFSCCode) {
        return bankService.getBankDetailsByIFSCCode(IFSCCode);
    }

    //Update bank details
	/*
	 * @ResponseStatus(HttpStatus.OK)
	 * 
	 * @PutMapping("/banks") public Bank updateBankDetails(@RequestBody Bank bank) {
	 * return bankService.updateBankDetails(bank); }
	 */
    
    
    //Fetch all banks by name and city
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/banks")
    public List<Branch> getAllBranchDetailsNameAndCity(@RequestParam(name = "name") String name,
                                                    @RequestParam(name = "city") String city) {
        return branchService.getAllBranchDetailsByNameandCity(name, city);
    }

    //Remove bank by IFSC code
	/*
	 * @ResponseStatus(HttpStatus.OK)
	 * 
	 * @DeleteMapping("/banks/{IFSCCode}") public Boolean
	 * deleteBankDetailsByIFSCCode(@PathVariable Integer IFSCCode) { return
	 * branchService.deleteBranchDetailsByIfsc(IFSCCode); }
	 */
}