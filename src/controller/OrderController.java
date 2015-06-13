package controller;


import java.util.Date;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


import model.Order;
import model.OrderFacade;
import model.OrderLine;
import model.OrderLineFacade;
import model.User;


@ManagedBean
public class OrderController {
	
	@ManagedProperty(value="#{param.id}")
	private Date creationDate;
	private User user;
	private List<OrderLine> orderLines ;
	private Long id; // id dell'ordine
	private int quantity;
	private Long idProdotto;
	private Order order;
	
	@EJB(name="orderFacade")
	private OrderFacade orderFacade;

	
	public String createOrder() {
		
					
		this.creationDate=new Date();
		this.order=this.orderFacade.createOrder();
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
	
			session.setAttribute("order", this.order);
		
		
		return "ordine"; 
		
	}
	
	public String createOrderLine() {


		OrderLine orderLine= this.orderFacade.createOrderLine(this.idProdotto,this.quantity);
				List<OrderLine> list=new LinkedList<>();
		//		list.add(orderLine);
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		Order o=(Order) session.getAttribute("order");
		if(o.getOrderLines()==null){
//			List<OrderLine> list=new LinkedList<>();
			list.add(orderLine);
		}
		else{
			list=o.getOrderLines();
			list.add(orderLine);
		}
		o.setOrderLines(list);
		session.setAttribute("order", o);
		return "riga";

	}
	
	public String confirmOrder() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		this.orderFacade.confirmOrder((Order) session.getAttribute("order"));

		return "ordine";

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