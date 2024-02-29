package com.SpringCOurse.Bank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

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
