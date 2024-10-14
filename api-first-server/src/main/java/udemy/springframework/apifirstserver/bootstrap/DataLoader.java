package udemy.springframework.apifirstserver.bootstrap;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import udemy.springframework.apifirstserver.repositories.CustomerRepository;
import udemy.springframework.model.Address;
import udemy.springframework.model.Customer;
import udemy.springframework.model.Name;
import udemy.springframework.model.PaymentMethod;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading data...");

        UUID id = UUID.randomUUID();

        Address address1 = Address.builder()
            .addressLine1("123 Main St")
            .city("Springfield")
            .state("IL")
            .zipCode("62701")
            .dateCreated(OffsetDateTime.now())
            .build();

        Customer customer = Customer.builder()
            .id(id)
            .name(Name.builder()
                .firstName("John")
                .lastName("Doe")
                .build())
            .shipToAddress(address1)
            .billToAddress(address1)
            .email("johndoe@gmail.com")
            .dateCreated(OffsetDateTime.now())
            .dateUpdated(OffsetDateTime.now())
            .paymentMethods(List.of(PaymentMethod.builder()
                .cardNumber("1234567890123456")
                .expiryMonth(12)
                .displayName("My Visa Card")
                .cvv("123")
                .build()))
            .build();

        customerRepository.save(customer);
    }

}
