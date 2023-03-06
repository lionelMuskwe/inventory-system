package application;

public class Users {
	private int id;
	private int age;
	private String username;
	private String firstName;
	private String lastName;
	private String fullAddress;
	private String telephone;
	private int role;
	
	public Users(int id, int age, String username, String firstName, String lastName, String fullAddress,String telephone, int role) {
		super();
		this.id = id;
		this.age = age;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullAddress = fullAddress;
		this.telephone = telephone;
		this.role = role;
	}

	public String getId() {
		return Integer.toString(id);
	}

	public String getAge() {
		return Integer.toString(age);
	}

	public String getUsername() {
		return username;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getTelephone() {
		return telephone;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public String getRole() {
		return Integer.toString(role);
	}
	
	
	
	
}
