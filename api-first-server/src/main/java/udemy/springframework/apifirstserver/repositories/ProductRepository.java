package udemy.springframework.apifirstserver.repositories;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import udemy.springframework.model.Product;

/**
 * Created by jt, Spring Framework Guru.
 */
public interface ProductRepository extends CrudRepository<Product, UUID> {
}