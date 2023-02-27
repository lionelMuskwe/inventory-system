package application;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class SearchController {
	@FXML
	private TextField searchTextField;
	@FXML
	private Button searchButton;
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
	
	public void searchBooks() {
		if (getBooks().size() > 0) {
			showBooks();
		}
		
	}
	
}














