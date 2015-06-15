package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import controller.ProductController;

@Stateless(name="orderFacade")
public class OrderFacade {

	@PersistenceContext(unitName ="unit-progettoSiw2015" )
	private EntityManager em;


	public Order createOrder(User user) {
		Date creationDate=new Date();
		Order o= new Order(creationDate);
		o.setOrderLines(null);
		o.setUser(user);
		em.persist(o);
		return o;

	}

	public OrderLine createOrderLine(Long id,int quantity) {
		Product p = em.find(Product.class, id);
		OrderLine line=new OrderLine (p,quantity,p.getPrice());
		return line;
	}

	public Product getProduct(Long id) {
		Product product = em.find(Product.class, id);
		return product;
	}

	public Order getOrder(Long id) {
		Order o=em.find(Order.class, id);
		return o;

	}
	public List<Product> getAllProducts() {
		Query q=this.em.createQuery("SELECT p FROM Product p");
		List<Product> products=q.getResultList();
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		session.setAttribute("catalogo", products);
		return products;
	}

	public Order confirmOrder(Order o) {
		o.setClosingDate(new Date());
		em.merge(o);
		return o;
	}

	public List<Order> getAllOrders() {
		Query q=this.em.createQuery("SELECT o FROM Order o");
		List<Order> orders=q.getResultList();
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		session.setAttribute("ordini",orders);
		return orders;

	}

	public void updateOrder(Order order) {
		em.merge(order);
	}

	public void deleteOrder(Long id) {
		deleteOrder(getOrder(id));		
	}

	public void deleteOrder(Order order) {
		em.remove(order);
	}



}
