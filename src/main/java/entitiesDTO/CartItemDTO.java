package entitiesDTO;

public class CartItemDTO {
    private Long id;
    private Long shoppingCartID;
    private String book;
    private Integer quantity;

    // Constructors, getters, and setters

    // Default constructor
    public CartItemDTO() {
    }
    public CartItemDTO(Long id, Long shoppingCartID, String book, Integer quantity) {
		super();
		this.id = id;
		this.shoppingCartID = shoppingCartID;
		this.book = book;
		this.quantity = quantity;
	}

	// Getters and setters

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public Long getShoppingCartID() {
		return shoppingCartID;
	}
	public void setShoppingCartID(Long shoppingCartID) {
		this.shoppingCartID = shoppingCartID;
	}
	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

