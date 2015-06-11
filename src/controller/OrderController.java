package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import model.Order;
import model.OrderFacade;
import model.OrderLine;
import model.OrderLineFacade;
import model.User;


@ManagedBean
@SessionScoped
public class OrderController {
	
	@ManagedProperty(value="#{param.id}")
	private Date creationDate;
	private User user;
	private List<OrderLine> orderLines;
	private int quantity;
	private Long id;
	private Order order;
	
	@EJB(name="orderFacade")
	private OrderFacade orderFacade;
	@EJB(name="OrderLineFacade")
	private OrderLineFacade orderLineFacade;
	
	public String createOrder() {
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.creationDate= new Date();
		this.order=this.orderFacade.createOrder(creationDate,orderLines,user);
		return "catalogo.jsp"; 
		
	}
	
	public String createOrderLine() {
		OrderLine orderLine= this.orderLineFacade.createOrderLine(this.id,this.quantity);
		this.orderLines.add(orderLine);
		return "catalogo.jsp";
		
	}
	
	public String confirmOrder() {
		this.orderFacade.confirmOrder(order, orderLines);
		return "riepilogoOrdine.jsp";
	}
	
	public String annullOrder() {
		this.orderFacade.deleteOrder(id);
		return "homepage.html";
	}
	
	public String findOrder(Long id) {
		this.orderFacade.getOrder(id);
		return "order.jsp";
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public OrderFacade getOrderFacade() {
		return orderFacade;
	}

	public void setOrderFacade(OrderFacade orderFacade) {
		this.orderFacade = orderFacade;
	}

	public OrderLineFacade getOrderLineFacade() {
		return orderLineFacade;
	}

	public void setOrderLineFacade(OrderLineFacade orderLineFacade) {
		this.orderLineFacade = orderLineFacade;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	

}