package model;

import javax.persistence.*;

@Entity
@Table(name="order_lines")
public class OrderLine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column (nullable=false)
	private Float unitPrice;

	@Column(nullable=false)
	private Integer quantity;

	@OneToOne (cascade= {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
	private Product product;

	public OrderLine() {

	}

	public OrderLine(Product p, int quantity, Float unitPrice) {
		this.product=p;
		this.quantity=quantity;
		this.unitPrice=unitPrice;
	}

	public Long getId() {
		return id;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", unitPrice=" + unitPrice
				+ ", quantity=" + quantity + ", product=" + product + "]";
	}



}
