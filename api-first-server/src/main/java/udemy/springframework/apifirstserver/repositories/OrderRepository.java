package udemy.springframework.apifirstserver.repositories;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import udemy.springframework.model.Order;

/**
 * Created by jt, Spring Framework Guru.
 */
public interface OrderRepository extends CrudRepository<Order, UUID> {
}