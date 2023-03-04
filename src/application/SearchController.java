package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TableColumn;

public class SearchController {
	@FXML
	private TextField searchTextField;
	@FXML
	private Button searchButton;
	@FXML
	private Button updateButton;
	@FXML
	private TableView<Books> tvBooks;
	@FXML
	private TableColumn<Books, Integer> colID;
	@FXML
	private TableColumn<Books, String> colTitle;
	@FXML
	private TableColumn<Books, String> colDescription;
	@FXML
	private TableColumn<Books, Double> colPrice;
	@FXML
	private TableColumn<Books, Date> colPubDate;
	
	@FXML
    private Button deleteRecordBtn;

    @FXML
    private Button insertRecordBtn;

    @FXML
    private TextField tfAuthor;

    @FXML
    private TextField tfCategoryID;

    @FXML
    private TextField tfDatePublished;

    @FXML
    private TextArea tfDescription;

    @FXML
    private TextField tfID;

    @FXML
    private TextField tfISBN;

    @FXML
    private TextField tfInventoryID;

    @FXML
    private TextField tfPrice;

    @FXML
    private TextField tfPublisher;

    @FXML
    private TextField tfTitle;
    
    @FXML
    private Button clearSidePanel;

    @FXML
    private Button updateRecordBtn;

	
	
	public ObservableList<Books> getBooks(){
		ObservableList<Books> bookList = FXCollections.observableArrayList();
		String searchWord = "%" + searchTextField.getText() + "%";
		String query = String.format("SELECT * FROM products where title like '%s' ", searchWord);
		
		Statement statement;
		ResultSet resultSet;
		
		try {
			statement = DatabaseConnection.getInstance().createStatement();
			resultSet = statement.executeQuery(query);
			Books book;
			while (resultSet.next()) {
				book = new Books(
						resultSet.getInt("id"),
						resultSet.getString("title"),
						resultSet.getString("author"),
						resultSet.getString("description"),
						resultSet.getDouble("price"),
						resultSet.getDate("date_published"),
						resultSet.getString("publisher"),
						resultSet.getInt("inventory_id"),
						resultSet.getInt("category_id")
						);
				bookList.add(book);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;
	}
	
	public void showBooks() {
		ObservableList<Books> list = getBooks();
		
		this.colID.setCellValueFactory(new PropertyValueFactory<Books, Integer>("id"));
		this.colTitle.setCellValueFactory(new PropertyValueFactory<Books, String>("title"));
		this.colDescription.setCellValueFactory(new PropertyValueFactory<Books, String>("description"));
		this.colPrice.setCellValueFactory(new PropertyValueFactory<Books, Double>("price"));
		this.colPubDate.setCellValueFactory(new PropertyValueFactory<Books, Date>("datePub"));
		
		this.tvBooks.setItems(list);
	}
	
	@FXML
	public void searchBooks() {
		if (getBooks().size() > 0) {
			showBooks();
		} else {
			this.tvBooks.setItems(null);
		}
		
	}
	
	@FXML 
	public void insertRecord() {
		String query = String.format("INSERT INTO `products`( `ISBN`, `title`, `author`, `description`, `image`, `price`,`date_published`, `publisher`, `inventory_id`, `category_id`) VALUES "
				+ "('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')", tfISBN.getText(), tfTitle.getText(), tfAuthor.getText(),tfDescription.getText(),"https://developers.elementor.com/docs/assets/img/elementor-placeholder-image.png", 
				tfPrice.getText(),tfDatePublished.getText(), tfPublisher.getText(), tfInventoryID.getText(), tfCategoryID.getText());
		executeQuery(query);
		System.out.println("-Notification: New Product Created");
	}
	
	@FXML
	public void updateRecord() {
		String query = 
				"UPDATE `products` SET title = '" + tfTitle.getText() + 
				"', `ISBN` = '" + tfISBN.getText() +
				"', `title` = '" + tfTitle.getText() +
				"', `author` = '" + tfAuthor.getText() +
				"', `description` = '" + tfDescription.getText() +
				"', `price` = '" + tfPrice.getText() +
				"', `date_published` = '" + tfDatePublished.getText() +
				"', `publisher` = '" + tfPublisher.getText() +
				"', `inventory_id` = '" + tfInventoryID.getText() +
				"', `category_id` = '" + tfCategoryID.getText() +
				"' WHERE id = " + tfID.getText() ;
		System.out.println("--Notification: Product updated !");
		executeQuery(query);
						
	}
	
	@FXML 
	public void deleteRecord() {
		String query = 
				String.format("Delete from products where id = %s", tfID.getText());
				System.out.println(query);
		executeQuery(query);
		System.out.println("--Notification: Product deleted !");
	}
	
	@FXML 
	public void passDetailsToTextfields() {
		Books selectedBook = this.tvBooks.getSelectionModel().getSelectedItem();
		tfTitle.setText(selectedBook.getTitle());
		tfAuthor.setText(selectedBook.getAuthor());
		tfDescription.setText(selectedBook.getDescription());
		tfPrice.setText(selectedBook.getPrice());
		tfPublisher.setText(selectedBook.getPublisher());
		tfDatePublished.setText(selectedBook.getDatePub());
		tfISBN.setText(selectedBook.getISBN());
		tfID.setText(selectedBook.getId());
		tfInventoryID.setText(selectedBook.getInventoryID());
		tfCategoryID.setText(selectedBook.getCategoryID());
		

	}
	
	@FXML
	public void clearSidePanel() {
		tfTitle.clear();
		tfAuthor.clear();
		tfDescription.clear();
		tfPrice.clear();
		tfPublisher.clear();
		tfDatePublished.clear();
		tfISBN.clear();
		tfID.clear();
		tfInventoryID.clear();
		tfCategoryID.clear();
	}
	
	private void executeQuery(String query) {
		Connection conn = DatabaseConnection.getInstance();
		Statement st;
		try	{
			st = conn.createStatement();
			st.execute(query);
			searchBooks();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}













