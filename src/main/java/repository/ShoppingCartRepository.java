package repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
import model.ShoppingCart;

//@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

}

