package com.SpringCOurse.Bank.beans;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class Bank {
    private List<Client> clients; // get from db

}
