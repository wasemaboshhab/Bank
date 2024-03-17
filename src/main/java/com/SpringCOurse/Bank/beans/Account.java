package com.SpringCOurse.Bank.beans;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Entity
@Builder
@Table(name = "accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "account")
    private Integer accountNumber;
    @Column(name = "bank")
    private Integer bankNumber;
    @Column(name = "branch")
    private Integer branchNumber;
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
    @ToString.Exclude
    @JsonIgnore
    private List<Loan> loans;



}
