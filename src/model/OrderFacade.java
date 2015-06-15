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

@Stateless
public class OrderFacade {
	
	@PersistenceContext(unitName ="unit-progettoSiw2015" )
	private EntityManager em;
	

	public Order createOrder() {
		Date creationDate=new Date();
		Order o= new Order(creationDate);
		o.setOrderLines(null);
//      o.setOrderLines(orderLines);
//		user.addOrder(o);
//		o.setUser(user);
		em.persist(o);
		return o;
		
	}
//	public OrderLine createOrderLine() {
//		Product p=new Product("provariga", (float) 12, "daje", "tert");
//OrderLine line=new OrderLine(p, 3, (float) 2);
//		em.persist(line);
//		return line;
//	}
	public OrderLine createOrderLine(Long id,int quantity) {
		Product p = em.find(Product.class, id);
		OrderLine line=new OrderLine (p,quantity,p.getPrice());
		return line;
	}
	public Product getProduct(Long id) {
		Product product = em.find(Product.class, id);
		return product;}
	
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
//		Product p=new Product("prova",(float) 3,"23","156");
//		List<OrderLine> list=new LinkedList<>();
//		list.add(new OrderLine(p, 3, (float) 14));
//		o.setOrderLines(list);
		
		em.merge(o);
		return o;
	}

	public void deleteOrder(Long id) {
		deleteOrder(getOrder(id));		
	}
	
	public void deleteOrder(Order order) {
		em.remove(order);
	}
	

}
