package controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ResponseStatusException;


import entitiesDTO.CartItemDTO;

import model.CartItem;
import repository.CartItemRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/cartItems")
public class CartItemController {

    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemController(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }
    
    @GetMapping
    public List<CartItemDTO> getAllCartItems() {
    	List<CartItem> cartItems = cartItemRepository.findAll();
    	 return cartItems.stream()
                 .map(this::convertToDTO)
                 .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CartItemDTO getCartItemById(@PathVariable("id") Long id) {
    	CartItem cartItem = cartItemRepository.findById(id)    			
    			.orElseThrow(() -> new NotFoundException("CartItem not found with ID: " + id));
        return convertToDTO(cartItem);
    }

    @PostMapping("/")
    public CartItem createCartItem(@RequestBody CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @PutMapping("/{id}")
    public CartItem updateCartItem(@PathVariable("id") Long id, @RequestBody CartItem updatedCartItem) {
        return cartItemRepository.findById(id)
                .map(cartItem -> {
                    cartItem.setShoppingCart(updatedCartItem.getShoppingCart());
                    cartItem.setBook(updatedCartItem.getBook());
                    cartItem.setQuantity(updatedCartItem.getQuantity());
                    return cartItemRepository.save(cartItem);
                })
                .orElseThrow(() -> new NotFoundException("CartItem not found with ID: " + id));
    }


    @DeleteMapping("/{id}")
    public void deleteCartItem(@PathVariable("id") Long id) {
        cartItemRepository.deleteById(id);
    }
    
    private CartItemDTO convertToDTO(CartItem cartItem) {
        CartItemDTO dto = new CartItemDTO();
        dto.setId(cartItem.getId());
        dto.setShoppingCartID(cartItem.getShoppingCart().getId());
        dto.setBook(cartItem.getBook().getTitle());
        dto.setQuantity(cartItem.getQuantity());
        return dto;
    }
    
}
