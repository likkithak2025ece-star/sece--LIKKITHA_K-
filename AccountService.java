package com.sece.state1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sece.state1.Repository.AccountRepository;
import com.sece.state1.dto.Account;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Create account
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    // Get all accounts
    public List<Account> getAccount() {
        return accountRepository.findAll();
    }

    // Get one account
    public Account getOneAccount(Long id) {
        return accountRepository.findById(id).orElse(null);
    }
    public Account updateAccount(Long id, Account account) {

        Account existingAccount = accountRepository.findById(id).orElse(null);

        if (existingAccount != null) {
            existingAccount.setName(account.getName());
            existingAccount.setPhoneNo(account.getPhoneNo());

            return accountRepository.save(existingAccount);
        }

        return null;
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}