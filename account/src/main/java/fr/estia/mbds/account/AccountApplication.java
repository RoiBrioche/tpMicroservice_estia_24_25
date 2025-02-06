package fr.estia.mbds.account;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository, CustomerClient customerClient) {
        return args -> {
            customerClient.getCustomers().forEach(customer -> {
                Account accountInstance = Account.builder()
                        .id(UUID.randomUUID().toString())
                        .balance(Math.random()*1000)
                        .currency(CurrencyType.EUR)
                        .customerId(customer.getId())
                        .build();
                accountRepository.save(accountInstance);
            });
        };
    }

}
