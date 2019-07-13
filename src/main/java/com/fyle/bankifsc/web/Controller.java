package com.fyle.bankifsc.web;

import com.fyle.bankifsc.model.Bank;
import com.fyle.bankifsc.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    BankService service;

    //Create bank
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/banks")
    public Bank createBankDetails(@RequestBody Bank bank) {
        return service.createBankDetails(bank);
    }

    //Fetch by id
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/banks/{IFSCCode}")
    public Bank getBankByIFSCCode(@PathVariable Integer  IFSCCode) {
        return service.getBankDetailsByIFSCCode(IFSCCode);
    }

    //Update bank details
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/banks")
    public Bank updateBankDetails(@RequestBody Bank bank) {
        return service.updateBankDetails(bank);
    }

    //Fetch all banks by name and city
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/banks")
    public List<Bank> getAllBanksDetailsNameAndCity(@RequestParam(name = "name") String name,
                                                    @RequestParam(name = "city") String city) {
        return service.getAllBanksDetailsByNameAndCity(name, city);
    }

    //Remove bank by IFSC code
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/banks/{IFSCCode}")
    public Boolean deleteBankDetailsByIFSCCode(@PathVariable Integer IFSCCode) {
        return service.deleteBankDetailsByIFSCCode(IFSCCode);
    }
}