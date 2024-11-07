package com.bankmanagementapp.service;


import com.bankmanagementapp.entity.Account;
import com.bankmanagementapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AccountServiceImpl implements AccountService  {

    @Autowired
    private AccountRepository accountRepo;

    @Override
    public Account createAccount(Account account) {
       Account createAccount = accountRepo.save(account);
        return createAccount;
    }



    @Override
    public Account getAccountDetailsByAccountNumber(Long account_number) {
       Optional<Account> getAccount = accountRepo.findById(account_number);
        if(getAccount.isEmpty()){
            throw new RuntimeException("Account is not present");
        }
        Account account_found = getAccount.get();
        return account_found;
    }

    @Override
    public List<Account> getAllAccountDetails() {
        List<Account> getAllAccount = accountRepo.findAll();
        if(getAllAccount.isEmpty()){
            throw new RuntimeException("No Account is not present in DB");
        }
        return getAllAccount;
    }

    @Override
    public Account depositAmount(Long accountNumber, Double amount) {
        Optional<Account> accountDetail = accountRepo.findById(accountNumber);
        if(accountDetail.isEmpty()){
            throw new RuntimeException("Account is not present");
        }
        Account account = accountDetail.get();
        Double balance = account.getAccount_balance() + amount;
        account.setAccount_balance(balance);
        accountRepo.save(account);
        return account;
    }

    @Override
    public Account withdrawAmount(Long accountNumber, Double amount) {
        Optional<Account> accountDetail = accountRepo.findById(accountNumber);
        try{
            if(accountDetail.isEmpty()){
                throw new RuntimeException("User not found");
            }
            Account account = accountDetail.get();
        if(account.getAccount_balance() > amount){

        Double balance = account.getAccount_balance() - amount;
        account.setAccount_balance(balance);
        accountRepo.save(account);
        }
        else{

            throw new RuntimeException("Insufficient funds");
        }
        return account;
    } catch (MatchException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void closeAccount(Long accountNumber) {
        accountRepo.deleteById(accountNumber);
    }

    @Override
    public Account getAccountDetailsByAccountName(String accountName) {
      Account account = accountRepo.findByName(accountName);
        return account;
    }
}
