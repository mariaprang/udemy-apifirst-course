package udemy.springframework.apifirstserver.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import udemy.springframework.apifirstserver.repositories.CustomerRepository;
import udemy.springframework.apifirstserver.services.CustomerService;
import udemy.springframework.model.Customer;

/**
 * CustomerService implementation
 */
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> listCustomers() {
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false).toList();
    }

    @Override
    public Customer getCustomerById(UUID customerId) {
        return customerRepository.findById(customerId).orElseThrow();
    }


}
