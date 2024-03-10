package com.SpringCOurse.Bank.daos;

import com.SpringCOurse.Bank.beans.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDAO extends JpaRepository<Account, Integer> {

}
