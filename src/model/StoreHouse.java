package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="magazzino")
public class StoreHouse {
	
	@Column(nullable=false)
	private int quantity; // quantità merci
	
	@Column(nullable=false)
	@OneToOne
	private Product product;
	
	public StoreHouse(Product p, int quantity) {
		this.product=p;
		this.quantity=quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	

}
