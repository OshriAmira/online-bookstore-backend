package service;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ShoppingCartRepository;
import model.ShoppingCart;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    //@Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public List<ShoppingCart> getAllShoppingCarts() {
        return shoppingCartRepository.findAll();
    }

    public Optional<ShoppingCart> getShoppingCartById(Long id) {
        return shoppingCartRepository.findById(id);
    }

    public ShoppingCart createShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    public Optional<ShoppingCart> updateShoppingCart(Long id, ShoppingCart updatedShoppingCart) {
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(id);
        if (shoppingCartOptional.isPresent()) {
            ShoppingCart shoppingCart = shoppingCartOptional.get();
            // Update the shopping cart properties as needed
            return Optional.of(shoppingCartRepository.save(shoppingCart));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteShoppingCart(Long id) {
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(id);
        if (shoppingCartOptional.isPresent()) {
            shoppingCartRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    // Add any additional methods as needed

}

