package com.bankmanagementapp.controller;

import com.bankmanagementapp.entity.Account;
import com.bankmanagementapp.service.AccountService;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/account")
@ComponentScan(basePackages = {"com.bankmanagementapp.service"})
public class AccountController {


    @Autowired
    private AccountService service;

    @PostMapping("/new")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
         Account newAccount = service.createAccount(account);
            return ResponseEntity.status(HttpStatus.CREATED).body(newAccount);
    }

    @GetMapping("/all")
    public List<Account> getAllAccounts(){
        List<Account> getAllAccounts = service.getAllAccountDetails();
        return getAllAccounts;
    }

    @GetMapping("/{account_number}")
    public Account getAccount(@PathVariable Long account_number){
        Account get_account = service.getAccountDetailsByAccountNumber(account_number);
            return get_account;
    }

    @PatchMapping("/deposit/{accountNumber}/{amount}")
    public  Account depositAmount(@PathVariable Long accountNumber, @PathVariable Double amount){
        Account depositMoney = service.depositAmount(accountNumber, amount);
        return depositMoney;
    }

    @PutMapping("/withdraw/{accountNumber}/{amount}")
    public Account withdrawAmount(@PathVariable Long accountNumber, @PathVariable Double amount){
        Account withdrawMoney = service.withdrawAmount(accountNumber, amount);
        return withdrawMoney;
    }

    @DeleteMapping("/delete/{accountNumber}")
    public ResponseEntity<String> deleteAccount(@PathVariable  Long accountNumber){
        service.closeAccount(accountNumber);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account Closed");
     }

     @GetMapping("/name/{accountName}")
    public Account account(@PathVariable String accountName){
        Account account = service.getAccountDetailsByAccountName(accountName);
        return account;
     }

}
