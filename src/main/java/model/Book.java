package model;



import java.math.BigDecimal;
//import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;
    
    @Column(name = "quantity",nullable = false)
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
    
    @Enumerated(EnumType.STRING)
    private CategoryName category;
    
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @OneToMany(mappedBy = "book")
    private List<OrderItem> orderItems;
    
    @Column(name = "image", nullable = false)
    private String image;
    

    
    // Constructors, getters, and setters
	

	public Long getId() {
        return id;
    }
	
	public Book() {
        // Default constructor
    }

	public Book(Long id, String title, int quantity, Author author, CategoryName category, String description,
			BigDecimal price, List<OrderItem> orderItems, String image) {
		super();
		this.id = id;
		this.title = title;
		this.quantity = quantity;
		this.author = author;
		this.category = category;
		this.description = description;
		this.price = price;
		this.orderItems = orderItems;
		this.image = image;
	}

	public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    
    public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public CategoryName getCategory() {
		return category;
	}

	public void setCategory(CategoryName category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public String getImage() {
	    return image;
	}

	public void setImage(String image) {
	    this.image = image;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", quantity=" + quantity + ", author=" + author + ", category="
				+ category + ", description=" + description + ", price=" + price + ", orderItems=" + orderItems
				+ ", image=" + image + "]";
	}

}
