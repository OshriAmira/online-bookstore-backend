package model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    private Date createdDate;
    
    private Date modifiedDate;
    
    private BigDecimal totalPrice;
    
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
    
    // Constructors, getters, and setters

    public Order() {
        // Default constructor for Hibernate
    }
    
    public Order(User user, Date createdDate, Date modifiedDate, BigDecimal totalPrice, OrderStatus status, List<OrderItem> orderItems) {
        this.user = user;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.totalPrice = calculateTotalPrice(orderItems);
        this.status = status;
        this.orderItems = orderItems;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public void setTotalPrice() {
        if (orderItems != null && !orderItems.isEmpty()) {
            BigDecimal totalPrice = BigDecimal.ZERO;
            
            for (OrderItem orderItem : orderItems) {
                BigDecimal itemPrice = orderItem.getPrice();
                int quantity = orderItem.getQuantity();
                
                if (itemPrice != null && quantity > 0) {
                    BigDecimal itemTotalPrice = itemPrice.multiply(BigDecimal.valueOf(quantity));
                    totalPrice = totalPrice.add(itemTotalPrice);
                }
            }
            
            this.totalPrice = totalPrice;
        } else {
            this.totalPrice = BigDecimal.ZERO;
        }
    }

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", user=" + user + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate
				+ ", totalPrice=" + totalPrice + ", status=" + status + ", orderItems=" + orderItems + "]";
	}
	

	public BigDecimal calculateTotalPrice(List<OrderItem> orderItems) {
	    BigDecimal total = BigDecimal.ZERO;
	    for (OrderItem orderItem : orderItems) {
	        BigDecimal quantity = BigDecimal.valueOf(orderItem.getQuantity());
	        BigDecimal price = orderItem.getPrice();
	        total = total.add(quantity.multiply(price));
	    }
	    return total;
	}


    
}





