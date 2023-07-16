package entitiesDTO;

import java.util.List;

public class ShoppingCartDTO {
    
    private Long id;
    private Long userID;
    private String userName;
    private List<CartItemDTO> cartItems;
    
    // Constructors, getters, and setters
    
    public ShoppingCartDTO() {
        // Default constructor
    }
    public ShoppingCartDTO(Long id, Long userID, String userName, List<CartItemDTO> cartItems) {
		super();
		this.id = id;
		this.userID = userID;
		this.userName = userName;
		this.cartItems = cartItems;
	}

    // Getters and setters

	public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<CartItemDTO> getCartItems() {
        return cartItems;
    }
    
    public void setCartItems(List<CartItemDTO> cartItems) {
        this.cartItems = cartItems;
    }
    
}

