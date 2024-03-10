package com.SpringCOurse.Bank.services;

import com.SpringCOurse.Bank.beans.Account;
import com.SpringCOurse.Bank.beans.Client;
import com.SpringCOurse.Bank.daos.AccountDAO;
import com.SpringCOurse.Bank.exceptions.AccountAlreadyExist;
import com.SpringCOurse.Bank.exceptions.AccountNotFound;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountDAO accountDAO;

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



}
