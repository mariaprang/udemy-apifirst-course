package udemy.springframework.apifirstserver.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import udemy.springframework.apifirstserver.repositories.ProductRepository;
import udemy.springframework.apifirstserver.services.ProductService;
import udemy.springframework.model.Product;

/**
 * CustomerService implementation
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    @Override
    public List<Product> listProducts() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false).toList();
    }

    @Override
    public Product getCustomerById(UUID customerId) {
        return productRepository.findById(customerId).orElseThrow();
    }


}
