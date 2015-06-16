package model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="providers")
public class Provider {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@Column (nullable=false)
	private String name;
	private String email;
	private String phoneNumber;
	private String vatin;

	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	private Address address;

	@ManyToMany
	private List<Product> products;

	public Provider() {

	}
	public Provider(String name, String email, String phoneNumber,
			String vatin, Address address) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.vatin = vatin;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getVatin() {
		return vatin;
	}

	public void setVatin(String vatin) {
		this.vatin = vatin;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void setAddress(Address x) {
		this.address=x;
	}

	@Override
	public String toString() {
		return "Provider [id=" + id + ", name=" + name + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", vatin=" + vatin
				+ ", address=" + address + ", products=" + products + "]";
	}
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		if (this.products==null) 
			this.products=new LinkedList<Product> ();
		this.products.add(product);


	}



}
