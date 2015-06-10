package controller;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

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
	private OrderFacade orderFacade;
	private OrderLineFacade orderLineFacade;
	
	public String createOrder() {
		this.orderFacade.createOrder(creationDate,orderLines,user);
		return "riepilogoOrdine.jsp"; 
		
	}
	
	public String createOrderLine(Long id) {
		OrderLine orderLine= this.orderLineFacade.createOrderLine(id);
		this.orderLines.add(orderLine);
		return "catalogo.jsp";
		
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
	
	

}
