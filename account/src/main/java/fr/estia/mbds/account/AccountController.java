package fr.estia.mbds.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class AccountController {
    private AccountRepository accountRepository;
    private CustomerClient customerClient;

    @Autowired
    public AccountController(AccountRepository accountRepository, CustomerClient customerClient) {
        this.accountRepository = accountRepository;
        this.customerClient = customerClient;
    }

        @GetMapping("/accounts")
        public List<Account> getAllAccounts()
        {
            List<Account> accounts = accountRepository.findAll();
            accounts.forEach(account -> {
                account.setCustomer(customerClient.getCustomerById(account.getCustomerId()));
            });
            return accounts;
        }

        @GetMapping("/account/{id}")
        public Account getAccountById(@PathVariable String id)
        {
            Account account = accountRepository.findById(id).orElse(null);
            account.setCustomer(customerClient.getCustomerById(account.getCustomerId()));
            return account;
        }
}
