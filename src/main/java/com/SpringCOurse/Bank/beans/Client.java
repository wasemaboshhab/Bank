package com.SpringCOurse.Bank.beans;


import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "token")
    private String token;
    @Column(name = "email")
    private String email;

    // will add account latter


}
