package controller;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import model.Order;
import model.OrderFacade;
import model.OrderLine;
import model.OrderLineFacade;
import model.User;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.faces.application.FacesMessage;

import model.*;


@ManagedBean

public class OrderLineController {

	@ManagedProperty(value="#{param.id}")
	private Long idProdotto;
	private int quantity;
	private Product product;
	private OrderLine ol;
	private Order order;

	private Long id; // id riga ordine
	@EJB(name="orderLineFacade")
	private OrderLineFacade orderLineFacade;
	
	public String createOrderLine() {

		this.ol= this.orderLineFacade.createOrderLine(this.idProdotto,this.quantity);
		List<OrderLine> list=new LinkedList<>();
		//		list.add(orderLine);
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		Order o=(Order) session.getAttribute("order");
		if(o.getOrderLines()==null){
			//			List<OrderLine> list=new LinkedList<>();
			list.add(this.ol);
		}
		else{
			list=o.getOrderLines();
			list.add(ol);
		}
		o.setOrderLines(list);
		session.setAttribute("order", o);
		return "riga";

	}

	public String findProduct() {
		this.product = orderLineFacade.getProduct(idProdotto);
		return "productO";
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



	public Long getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(Long idProdotto) {
		this.idProdotto = idProdotto;
	}


	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public OrderLine getOl() {
		return ol;
	}

	public void setOl(OrderLine ol) {
		this.ol = ol;
	}

	public OrderLineFacade getOrderLineFacade() {
		return orderLineFacade;
	}

	public void setOrderLineFacade(OrderLineFacade orderLineFacade) {
		this.orderLineFacade = orderLineFacade;
	}

	}
