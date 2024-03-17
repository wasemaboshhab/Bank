package com.SpringCOurse.Bank.controllers;

import com.SpringCOurse.Bank.beans.Account;
import com.SpringCOurse.Bank.exceptions.AccountNotFound;
import com.SpringCOurse.Bank.exceptions.ClientNotFound;
import com.SpringCOurse.Bank.exceptions.NoEnoughBalanceToWithdrawal;
import com.SpringCOurse.Bank.exceptions.NotAllowToWithdrawal;
import com.SpringCOurse.Bank.services.AccountService;
import com.SpringCOurse.Bank.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Bank")
public class BankController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private ClientService clientService;


    @PutMapping("/account/limit")
    public Account limitAccount(int accountId) throws AccountNotFound {
        return this.accountService.limitAccount(accountId);
    }


    @PutMapping("/account/delay")
    public Account delayAccount(int accountId) throws AccountNotFound {
        return this.accountService.delayAccount(accountId);
    }


    @GetMapping("account/balance")
    public Integer balanceInquiry(int accountId) throws AccountNotFound {
        return this.accountService.balanceInquiry(accountId);
    }


    @PutMapping("account/deposit")
    public Integer deposit(int accountId, int amount) throws AccountNotFound {
        return this.accountService.deposit(accountId,amount);
    }

    @PutMapping("account/withdrawal")
    public Integer withdrawal(int accountId, int amount) throws NoEnoughBalanceToWithdrawal, NotAllowToWithdrawal, AccountNotFound {
        return this.accountService.withdrawal(accountId,amount);
    }







}
