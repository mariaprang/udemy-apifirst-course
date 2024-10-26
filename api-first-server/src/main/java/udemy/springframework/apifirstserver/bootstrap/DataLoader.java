package udemy.springframework.apifirstserver.bootstrap;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import udemy.springframework.apifirstserver.repositories.CustomerRepository;
import udemy.springframework.apifirstserver.repositories.ProductRepository;
import udemy.springframework.model.Address;
import udemy.springframework.model.Category;
import udemy.springframework.model.Customer;
import udemy.springframework.model.Dimensions;
import udemy.springframework.model.Image;
import udemy.springframework.model.Name;
import udemy.springframework.model.PaymentMethod;
import udemy.springframework.model.Product;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

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

        Dimensions dimensions = Dimensions.builder()
            .length(10)
            .width(10)
            .height(10)
            .description("Product Dimensions")
            .build();

        Category category = Category.builder()
            .category("Electronics")
            .description("Electronics Category")
            .dateCreated(OffsetDateTime.now())
            .dateUpdated(OffsetDateTime.now())
            .build();

        Image image = Image.builder()
            .url("https://example.png").build();

        Product product = Product.builder()
            .id(UUID.randomUUID())
            .title("Product 1")
            .cost("10.0")
            .price("20.0")
            .dimensions(dimensions)
            .categories(List.of(category))
            .images(List.of(image))
            .build();


        productRepository.save(product);
        customerRepository.save(customer);
    }

}
