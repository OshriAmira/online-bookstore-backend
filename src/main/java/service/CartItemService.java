package service;


import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controller.NotFoundException;
import model.CartItem;
import repository.CartItemRepository;

@Service
public class CartItemService {

    private final CartItemRepository cartItemRepository;

   //@Autowired
    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }
    
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public CartItem getCartItemById(Long id) {
        return cartItemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("CartItem not found with ID: " + id));
    }

    public CartItem createCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public CartItem updateCartItem(Long id, CartItem updatedCartItem) {
        return cartItemRepository.findById(id)
                .map(cartItem -> {
                 //   cartItem.setShoppingCart(updatedCartItem.getShoppingCart());
                    cartItem.setBook(updatedCartItem.getBook());
                    cartItem.setQuantity(updatedCartItem.getQuantity());
                    return cartItemRepository.save(cartItem);
                })
                .orElseThrow(() -> new NotFoundException("CartItem not found with ID: " + id));
    }

    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }
}

