package fr.estia.mbds.account;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER")
public interface CustomerClient {

    @GetMapping("/customer/{id}")
    @CircuitBreaker(name = "customer", fallbackMethod = "getDefaultCustomer")
    public Customer getCustomerById(@PathVariable Long id);

    @GetMapping("/customers")
    @CircuitBreaker(name = "customer", fallbackMethod = "getDefaultCustomers")
    public List<Customer> getCustomers();

    default Customer getDefaultCustomer(Long id, Exception e)
    {
        return Customer.builder()
                .id(id)
                .firstname("not available")
                .lastname("not available")
                .email("not available")
                .build();
    }

    default List<Customer> getDefaultCustomers(Exception e) {
        return List.of();
    }
}
