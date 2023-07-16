package entitiesDTO;

import java.math.BigDecimal;

import model.CategoryName;
//import java.util.Arrays;

public class BookDTO {
    private Long id;
    private String title;
    private CategoryName category; 
    private String description;
    private BigDecimal price;
    private int quantity;
    private String authorName;
    private String image;
    
    // Constructors, getters, and setters
    
    public BookDTO() {
        // Default constructor
    }

	public BookDTO(Long id, String title, CategoryName category, String description, BigDecimal price, int quantity,
			String authorName, String image) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.authorName = authorName;
		this.image = image;
	}

	public Long getId() {
		return id;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "BookDTO [id=" + id + ", title=" + title + ", category=" + category + ", description=" + description
				+ ", price=" + price + ", quantity=" + quantity + ", authorName=" + authorName + ", image=" + image
				+ "]";
	}
	
}

