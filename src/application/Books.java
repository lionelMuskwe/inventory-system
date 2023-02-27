package application;
import java.util.Date;

public class Books {
	private int id;
	private String title;
	private String author;
	private String description;
	private double price;
	private Date datePub;
	private String publisher;
	private int inventoryID;
	private int categoryID;
	
	public Books(int id, String title, String author, String description, double price, Date datePub, String publisher,
			int inventoryID, int categoryID) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.description = description;
		this.price = price;
		this.datePub = datePub;
		this.publisher = publisher;
		this.inventoryID = inventoryID;
		this.categoryID = categoryID;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDatePub() {
		return datePub;
	}

	public void setDatePub(Date datePub) {
		this.datePub = datePub;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getInventoryID() {
		return inventoryID;
	}

	public void setInventoryID(int inventoryID) {
		this.inventoryID = inventoryID;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
}
