package repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
import model.Order;

//@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // You can add custom query methods or use the default methods provided by JpaRepository
}
