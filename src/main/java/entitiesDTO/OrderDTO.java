package entitiesDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import model.OrderStatus;

public class OrderDTO {
    private Long id;
    private Long userID;
    private String userName;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private BigDecimal totalPrice;
    private OrderStatus status;
    private List<OrderItemDTO> orderItems;
     
    // Constructors, getters, and setters

    // Default constructor
    public OrderDTO() {
    }

    // Constructor
	public OrderDTO(Long id, Long userID, String userName, LocalDateTime createdDate, LocalDateTime modifiedDate,
			BigDecimal totalPrice, OrderStatus status, List<OrderItemDTO> orderItems) {
		super();
		this.id = id;
		this.userID = userID;
		this.userName = userName;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.totalPrice = totalPrice;
		this.status = status;
		this.orderItems = orderItems;
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

	public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }
}
