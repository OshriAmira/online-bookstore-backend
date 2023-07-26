package entitiesDTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import model.OrderStatus;

public class OrderDTO {
    private Long id;
    private Long userId;
    private String userName;
    private Date createdDate;
    private Date modifiedDate;
    private BigDecimal totalPrice;
    private OrderStatus status;
    private List<OrderItemDTO> orderItems;
     
    // Constructors, getters, and setters

    // Default constructor
    public OrderDTO() {
    }

    // Constructor
	public OrderDTO(Long id, Long userId, String userName, Date createdDate, Date modifiedDate,
			BigDecimal totalPrice, OrderStatus status, List<OrderItemDTO> orderItems) {
		super();
		this.id = id;
		this.userId = userId;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
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
