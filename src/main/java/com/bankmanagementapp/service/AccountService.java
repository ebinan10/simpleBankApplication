package com.bankmanagementapp.service;

import com.bankmanagementapp.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    public Account createAccount(Account account);

    public Account getAccountDetailsByAccountNumber(Long account_number);

    public List<Account> getAllAccountDetails();

    public Account depositAmount(Long accountNumber, Double amount);

    public Account withdrawAmount(Long accountNumber, Double amount);

    public void closeAccount(Long accountNumber);

    Account getAccountDetailsByAccountName(String accountName);
}
