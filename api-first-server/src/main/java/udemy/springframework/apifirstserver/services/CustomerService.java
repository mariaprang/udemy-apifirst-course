package udemy.springframework.apifirstserver.services;

import java.util.List;
import org.springframework.stereotype.Service;
import udemy.springframework.model.Customer;

@Service
public interface CustomerService {

    List<Customer> listCustomers();
}
