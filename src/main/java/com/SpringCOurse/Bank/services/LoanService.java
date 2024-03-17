package com.SpringCOurse.Bank.services;

import com.SpringCOurse.Bank.beans.Account;
import com.SpringCOurse.Bank.beans.Loan;
import com.SpringCOurse.Bank.daos.LoanDAO;
import com.SpringCOurse.Bank.exceptions.LoanAlreadyExist;
import com.SpringCOurse.Bank.exceptions.LoanNotFound;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoanService {
    @Autowired
    private LoanDAO loanDAO;




    public void addLoan(Loan loan) throws LoanAlreadyExist {
        if (loan.getId() != null && this.loanDAO.existsById(loan.getId())) {
            throw new LoanAlreadyExist("loan with id: " + loan.getId() + " already exists");
        }
        this.loanDAO.save(loan);
    }


    @Transactional
    public void associatingLoanWithAccount(int loanId,Account account) throws LoanNotFound {

        Optional<Loan> loanOptional = this.loanDAO.findById(loanId);
        if (loanOptional.isEmpty()) {
            throw new LoanNotFound("loan with id: " + loanId + " Not Found");
        }
        Loan loan = loanOptional.get();
        loan.setAccount(account);
    }
}
