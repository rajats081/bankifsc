package com.fyle.bankifsc.web;

import com.fyle.bankifsc.model.Bank;
import com.fyle.bankifsc.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    BankService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/banks")
    public Bank createBank(@RequestBody Bank bank) {
        return service.createBank(bank);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/banks/{IFSCCode}")
    public Optional<Bank> createBank(@PathVariable String IFSCCode) {
        return service.getBankByIFSCCode(IFSCCode);
    }
}
