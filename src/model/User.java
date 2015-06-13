package model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
	
	@Id 
	private String email;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String username;
	@OneToMany(mappedBy="costumer")
	private List<Order> orders;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationDate;
	
	@OneToOne(cascade= {CascadeType.ALL})
	private Address address;

	
	public User(String email, String password,String username) {
		this.email=email;
		this.password=password;
		this.username=username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	public boolean checkPassword(String psw) {
		if (this.password!=psw)
			return false;
		else
			return true;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public void addOrder(Order o) {
		this.orders.add(o);	
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	

}