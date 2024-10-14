package udemy.springframework.apifirstserver.services;

import java.util.List;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import udemy.springframework.apifirstserver.repositories.CustomerRepository;
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
}
