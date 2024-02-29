package com.SpringCOurse.Bank.beans;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "accounts")
@Data
public class Account {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name = "bank")
    private Integer bankNumber;
    @Column(name = "branch")
    private Integer branchNumber;
    @Column(name = "account")
    private Integer accountNumber;
    @Column(name = "balance")
    private Integer balance;
    @Column(name = "delay")
    private boolean delay;
    @Column(name = "limited")
    private boolean limited;
    // loans should be entity account have many loans - loan could  belong to one account




}
