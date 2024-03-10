package com.SpringCOurse.Bank.daos;

import com.SpringCOurse.Bank.beans.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanDAO extends JpaRepository<Loan, Integer> {

}
