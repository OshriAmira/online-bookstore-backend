package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    // Additional custom query methods can be defined here if needed
}
