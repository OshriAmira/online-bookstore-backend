package controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import entitiesDTO.CartItemDTO;
import entitiesDTO.ShoppingCartDTO;
import repository.ShoppingCartRepository;
import model.CartItem;
import model.ShoppingCart;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/shoppingCarts")
public class ShoppingCartController {

    private final ShoppingCartRepository shoppingCartRepository;

    //@Autowired
    public ShoppingCartController(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @GetMapping
    public List<ShoppingCartDTO> getAllShoppingCarts() {
    	List<ShoppingCart> shoppingCart = shoppingCartRepository.findAll();
    	return shoppingCart.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ShoppingCartDTO getShoppingCartById(@PathVariable Long id) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(id)
        		 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return convertToDTO(shoppingCart);
    }

    @PostMapping
    public ShoppingCart createShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShoppingCart> updateShoppingCart(@PathVariable Long id, @RequestBody ShoppingCart updatedShoppingCart) {
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(id);
        if (shoppingCartOptional.isPresent()) {
            ShoppingCart shoppingCart = shoppingCartOptional.get();
            // Update the shopping cart properties as needed
            return ResponseEntity.ok(shoppingCartRepository.save(shoppingCart));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShoppingCart(@PathVariable Long id) {
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(id);
        if (shoppingCartOptional.isPresent()) {
            shoppingCartRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    protected ShoppingCartDTO convertToDTO(ShoppingCart shoppingCart) {
        ShoppingCartDTO dto = new ShoppingCartDTO();
        dto.setId(shoppingCart.getId());
        dto.setUserID(shoppingCart.getUser().getId());
        dto.setUserName(shoppingCart.getUser().getFirstName() + " " + shoppingCart.getUser().getLastName());
        dto.setCartItems(convertCartItemsToDTOs(shoppingCart.getCartItems()));
        return dto;
    }
    
    private List<CartItemDTO> convertCartItemsToDTOs(List<CartItem> cartItems) {
        return cartItems.stream()
                .map(this::convertCartItemToDTO)
                .collect(Collectors.toList());
    }
    
    private CartItemDTO convertCartItemToDTO(CartItem cartItem) {
        CartItemDTO dto = new CartItemDTO();
        dto.setId(cartItem.getId());
        dto.setShoppingCartID(cartItem.getShoppingCart().getId());
        dto.setBook(cartItem.getBook().getTitle());
        dto.setQuantity(cartItem.getQuantity());
        return dto;
    }
    
    
}

