package udemy.springframework.apifirstserver.services;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import udemy.springframework.model.Product;

@Service
public interface ProductService {

    List<Product> listProducts();

    Product getCustomerById(UUID customerId);
}
