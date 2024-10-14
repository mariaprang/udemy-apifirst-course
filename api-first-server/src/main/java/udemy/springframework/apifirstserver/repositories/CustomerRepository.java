package udemy.springframework.apifirstserver.repositories;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import udemy.springframework.model.Customer;

/**
 * Created by jt, Spring Framework Guru.
 */
public interface CustomerRepository extends CrudRepository<Customer, UUID> {
}