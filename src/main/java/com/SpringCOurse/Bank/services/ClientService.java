package com.SpringCOurse.Bank.services;
import com.SpringCOurse.Bank.beans.Account;
import com.SpringCOurse.Bank.beans.Client;
import com.SpringCOurse.Bank.daos.ClientDAO;
import com.SpringCOurse.Bank.exceptions.AccountNotFound;
import com.SpringCOurse.Bank.exceptions.ClientAlreadyExist;
import com.SpringCOurse.Bank.exceptions.ClientNotFound;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
@Service
public class ClientService {
    @Autowired
    private ClientDAO clientDAO;
    //    public AccountDAO;
    @Autowired
    private AccountService accountService;

    public Client addClient(Client client) throws ClientAlreadyExist {
        //1 validation
        if ( client.getId() != null && clientDAO.existsById(client.getId())) {
            throw new ClientAlreadyExist("client with  id " + client.getId() + " is already exist");
        }
        //2 authorization // when we sign in we don't need this part (skipped)
        //save
        clientDAO.save(client);
        return clientDAO.save(client);
    }

    @Transactional
    public void associatingAccountWithClient(int accountId, int clientId) throws ClientNotFound, AccountNotFound {
        //1: check if we have the Client we wanna association with
        Optional<Client> clientResult = this.clientDAO.findById(clientId);
        if (clientResult.isEmpty()) { //no client with id
            throw new ClientNotFound("Client with id: " + clientId + " not Found");
        }
        //2 associating with :
        Client client = clientResult.get();
        this.accountService.associatingAccountWithClient(accountId, client);
    }

    public Client findClientById(int id) throws ClientNotFound {
        Optional<Client> clientOptional = clientDAO.findById(id);
        if (clientOptional.isEmpty()) {
            throw new ClientNotFound("client with id : " + id + "not found");
        }
        return clientOptional.get();
    }


}
