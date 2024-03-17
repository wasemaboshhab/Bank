package com.SpringCOurse.Bank.beans;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @OneToMany(mappedBy = "client" ,fetch = FetchType.EAGER)
    @ToString.Exclude
    @JsonIgnore
    private List<Account> accounts;


}
