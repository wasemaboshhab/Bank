package com.SpringCOurse.Bank;

import com.SpringCOurse.Bank.beans.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class BankApplication implements CommandLineRunner {

	public static void main(String[] args)  {
		 SpringApplication.run(BankApplication.class, args);
		System.out.println("app started:");

	}

	@Override
	public void run(String... args) throws Exception {

	}
}
