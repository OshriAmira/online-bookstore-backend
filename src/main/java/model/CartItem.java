package model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_items")
public class CartItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;
    
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    
    private Integer quantity;
    
    // Constructors, getters, and setters

    // Default constructor for Hibernate
    public CartItem() {
    }

    // Constructor without ID for convenience
    public CartItem(ShoppingCart shoppingCart, Book book, Integer quantity) {
       // this.shoppingCart = shoppingCart;
        this.book = book;
        this.quantity = quantity;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", shoppingCart=" + shoppingCart + ", book=" + book + ", quantity=" + quantity
				+ "]";
	}
	
	
    

    
}
