package controller;


import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import model.Order;
import model.OrderFacade;
import model.OrderLine;
import model.OrderLineFacade;
import model.User;


@ManagedBean
//@SessionScoped
public class OrderController {
	
	@ManagedProperty(value="#{param.id}")
	private Date creationDate;
	private User user;
	private List<OrderLine> orderLines;
	private Long id; // id dell'ordine
	private int quantity;
	private Long idProdotto;
	private Order order;
	
	@EJB(name="orderFacade")
	private OrderFacade orderFacade;
	@EJB(name="OrderLineFacade")
	private OrderLineFacade orderLineFacade;
	
	public String createOrder() {
		this.creationDate=new Date();
		this.order=this.orderFacade.createOrder();
		return "ordine"; 
		
	}
	
	
	public String createOrderLine() {
		FacesContext context = FacesContext.getCurrentInstance();
//		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
//		if (session.getAttribute("orderLines")== null) {
//			session.setAttribute("orderLines", this.orderLines);
//		}
//		this.orderLines=(List<OrderLine>) session.getAttribute("orderLines");			
//		OrderLine orderLine= this.orderLineFacade.createOrderLine(this.idProdotto,this.quantity);
//		this.orderLines.add(orderLine);
//		session.setAttribute("orderLines", this.orderLines);
		OrderLine orderLine= this.orderLineFacade.createOrderLine(this.idProdotto,this.quantity);
		this.orderLines.add(orderLine);
		context.getExternalContext().getSessionMap().put("orderLines", this.orderLines);
		
		return "ordine";
	}
	
	public String confirmOrder() {
		this.orderFacade.confirmOrder(order, orderLines);
		return "#";

	}
	
	public String annullOrder() {
		this.orderFacade.deleteOrder(id);
		return "homepage.html";
	}
	
	public String findOrder(Long id) {
		this.orderFacade.getOrder(id);
		return "order.jsp";
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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(Long idProdotto) {
		this.idProdotto = idProdotto;
	}
	
	

}
