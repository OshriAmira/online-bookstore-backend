package entitiesDTO;

import java.math.BigDecimal;

public class OrderItemDTO {
    
    private Long id;
    private Long orderId;
    private String book;
    private Integer quantity;
    private BigDecimal price;
    // Constructors, getters, and setters

    // Default constructor
    public OrderItemDTO() {
    }

    // Constructor
	public OrderItemDTO(Long id, Long orderId, String book, Integer quantity, BigDecimal price) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.book = book;
		this.quantity = quantity;
		this.price = price;
	}

    // Getters and setters
    public Long getId() {
        return id;
    }

	public void setId(Long id) {
        this.id = id;
    }

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
