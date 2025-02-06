package fr.estia.mbds.account;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "customer", url = "http://localhost:8091/")
public interface CustomerClient {

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable Long id);

    @GetMapping("/customers")
    public List<Customer> getCustomers();
}
