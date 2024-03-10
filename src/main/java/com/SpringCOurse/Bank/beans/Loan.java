package com.SpringCOurse.Bank.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@Table(name = "loans")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @CreatedDate()
    @Column(name = "date")
    @JsonFormat()
    private LocalDate date;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "interest_rate")
    private Double interestRate;
    @Column(name = "monthly_repayment")
    private Double monthlyRepayment;
    @Column(name = "months_of_loans")
    private Integer monthsOfLoans;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

}
