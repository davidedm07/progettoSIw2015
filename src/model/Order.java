package model;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@ManyToOne
	private User user;

	@OneToMany(fetch= FetchType.EAGER,cascade= {CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name="orders_id")
	//@OrderBy("creationDate asc")
	private List<OrderLine> orderLines;

	public Order() {

	}

	public Order(Date creation) {
		this.creationDate=creation;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", creationDate=" + creationDate
				+ ", customer=" +user + ", orderLines=" + orderLines + "]";
	}






}
