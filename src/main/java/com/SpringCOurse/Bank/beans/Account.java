package com.SpringCOurse.Bank.beans;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Array;

import java.util.List;

@Entity
@Builder
@Table(name = "accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToMany(mappedBy = "account")
    private List<Loan> loans;
    // loans should be entity account have many loans - loan could  belong to one account


}
