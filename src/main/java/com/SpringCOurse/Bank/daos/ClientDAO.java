package com.SpringCOurse.Bank.daos;

import com.SpringCOurse.Bank.beans.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDAO extends JpaRepository<Client,Integer> {
    public Client getClientByIdIs(int id);
}
