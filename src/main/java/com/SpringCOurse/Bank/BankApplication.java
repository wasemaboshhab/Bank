package com.SpringCOurse.Bank;

import com.SpringCOurse.Bank.beans.Account;
import com.SpringCOurse.Bank.beans.Client;
import com.SpringCOurse.Bank.beans.Loan;
import com.SpringCOurse.Bank.services.AccountService;
import com.SpringCOurse.Bank.services.ClientService;
import com.SpringCOurse.Bank.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;


@SpringBootApplication
@EnableJpaAuditing
public class BankApplication implements CommandLineRunner {
	@Autowired
	private ClientService clientService;
	@Autowired
	private AccountService accountService;

	@Autowired
	private LoanService loanService;

	public static void main(String[] args)  {
		 SpringApplication.run(BankApplication.class, args);
		System.out.println("app started:");

	}

	@Override
	public void run(String... args) throws Exception {

		Client client1 = Client.builder()
				.email("Wasem@gmail.com")
				.username("wasem")
				.token("wasemIph")
				.build();

		Client client2 = Client.builder()
				.email("mohamed@gmail.com")
				.username("mohamedhsa")
				.token("mohamedipd")
				.build();
		this.clientService.addClient(client1);
		this.clientService.addClient(client2);


		Account account1= Account.builder()
				.accountNumber(567890)
				.bankNumber(12)
				.balance(30_000)
				.branchNumber(484)
				.build();

		Account account2 = Account.builder()
				.accountNumber(321321)
				.bankNumber(12)
				.balance(20_000)
				.branchNumber(484)
				.build();
		this.accountService.addAccount(account1);
		this.accountService.addAccount(account2);

		this.clientService.associatingAccountWithClient(account1.getId(), client1.getId());

		Loan loan1 = Loan.builder()
				.monthsOfLoans(2)
				.amount(1000.)
				.interestRate(5.8)
				.monthlyRepayment(5002.8)
				.build();
		loanService.addLoan(loan1);

		this.accountService.associatingLoanWithAccount(account1.getId(), loan1.getId());




	}
}
