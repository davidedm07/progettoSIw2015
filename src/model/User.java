package model;

import java.util.List;

import javax.persistence.*;

@Entity
public class User {
	
	@Id
	private String email;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String username;
	
	@OneToMany(mappedBy="users")
	private List<Order> orders;

	
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

}
