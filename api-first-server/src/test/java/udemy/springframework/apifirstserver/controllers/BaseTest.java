package udemy.springframework.apifirstserver.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import udemy.springframework.apifirstserver.repositories.CustomerRepository;
import udemy.springframework.apifirstserver.repositories.OrderRepository;
import udemy.springframework.apifirstserver.repositories.ProductRepository;
import udemy.springframework.model.Customer;

@SpringBootTest
@TestConfiguration
public class BaseTest {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    public MockMvc mockMvc;

    @Autowired
    WebApplicationContext wac;

    Customer testCustomer;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        testCustomer = customerRepository.findAll().iterator().next();
    }

}
