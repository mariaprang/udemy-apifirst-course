package udemy.springframework.apifirstserver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import udemy.springframework.apifirstserver.repositories.CustomerRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApiFirstServerApplicationTests {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testDataLoad(){
        assertThat(customerRepository.count()).isGreaterThan(0L);
    }
}
