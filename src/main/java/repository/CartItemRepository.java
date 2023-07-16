package repository;



import org.springframework.data.jpa.repository.JpaRepository;

import model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
	
    // You can add custom query methods or use the methods provided by JpaRepository
}
