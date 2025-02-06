package fr.estia.mbds.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {

            List<Customer> customersList = List.of(
                    Customer.builder()
                            .firstname("Elodie").lastname("Bentos")
                            .email("elodie.bantos@etu.univ-cotedazur.fr")
                            .build(),
                    Customer.builder()
                            .firstname("Yue").lastname("Guo")
                            .email("yue.guo@etu.univ-cotedazur.fr")
                            .build(),
                    Customer.builder()
                            .firstname("Valeria").lastname("Lashing")
                            .email("valeriia.lapshina@etu.univ-cotedazur.fr")
                            .build(),
                    Customer.builder()
                            .firstname("Dounia").lastname("Zoubid")
                            .email("dounia.zoubid@etu.univ-cotedazur.fr")
                            .build()
            );
            customerRepository.saveAll(customersList);

        };
    }


}
