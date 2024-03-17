package com.SpringCOurse.Bank.services;

import com.SpringCOurse.Bank.beans.Account;
import com.SpringCOurse.Bank.beans.Client;
import com.SpringCOurse.Bank.daos.AccountDAO;
import com.SpringCOurse.Bank.exceptions.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountDAO accountDAO;
    @Autowired
    private LoanService loanService;

    public void addAccount (Account account) throws AccountAlreadyExist {
        if (account.getId()!=null && accountDAO.existsById(account.getId())) {
            throw new AccountAlreadyExist("account with id " + account.getId() + " already Exist");
        }
        //2 authorizations : when we loginn not creating
        //3 save it
        this.accountDAO.save(account);
    }

    @Transactional
    public void associatingAccountWithClient(int accountId, Client client) throws AccountNotFound {
        Optional<Account> accountOptional = this.accountDAO.findById(accountId);
        if (accountOptional.isEmpty()) {
            throw new AccountNotFound("account with id: " + accountId + " Not found");
        }
        Account account = accountOptional.get();
        account.setClient(client);

    }

    @Transactional
    public void associatingLoanWithAccount(int accountId, int loanId) throws AccountNotFound, LoanNotFound {
        Optional<Account> accountOptional = this.accountDAO.findById(accountId);
        if (accountOptional.isEmpty()) {
            throw new AccountNotFound("account with id: " + accountId + " Not found");
        }
        Account account = accountOptional.get();
        this.loanService.associatingLoanWithAccount(loanId, account);
    }

    private Account findAccountById(int accountId) throws AccountNotFound {
        Optional<Account> accountOptional = this.accountDAO.findById(accountId);
        if (accountOptional.isEmpty()) {
            throw new AccountNotFound("account with id: " + accountId + " Not found");
        }
        return accountOptional.get();
    }

    @Transactional
    public Account limitAccount(int accountId) throws AccountNotFound {
        Account account = findAccountById(accountId);
        account.setLimited(true);
        return account;
    }

    @Transactional
    public Account delayAccount(int accountId) throws AccountNotFound {
        Account account = findAccountById(accountId);
        account.setDelay(true);
        return account;
    }

    public Integer balanceInquiry(int accountId) throws AccountNotFound {
        Account account = findAccountById(accountId);
        return account.getBalance();
    }

    @Transactional
    public Integer deposit(int accountId , int amountToDeposit) throws AccountNotFound {
        Account account = findAccountById(accountId);
        account.setBalance(account.getBalance() + amountToDeposit);
        return balanceInquiry(account.getId());
    }

    @Transactional
    public Integer withdrawal(int accountId, int amount) throws AccountNotFound, NotAllowToWithdrawal, NoEnoughBalanceToWithdrawal {
        Account account = findAccountById(accountId);
        boolean allowToWithdrawal = !(account.isDelay() && account.isLimited());
        if (!allowToWithdrawal) {
            throw new NotAllowToWithdrawal("account with id: " + accountId + " not Allowed to withdrawal , the account delayed or limited");
        }
        boolean enoughBalanceToWithdrawal = account.getBalance() - amount >= 0;
        if (!enoughBalanceToWithdrawal) {
            throw new NoEnoughBalanceToWithdrawal("account: " + account.getAccountNumber() + " can not withdrawal: " + amount + " current Balance: " + account.getBalance());
        }
        account.setBalance(account.getBalance() - amount);
        return balanceInquiry(account.getId());
    }

}
