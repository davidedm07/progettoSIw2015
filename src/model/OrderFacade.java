package model;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class OrderFacade {
	
	@PersistenceContext(unitName ="unit-progettoSiw2015" )
	private EntityManager em;

	public Order createOrder(Date creationDate, List<OrderLine> orderLines,User user) {
		Order o= new Order(creationDate);
		o.setOrderLines(orderLines);
		user.addOrder(o);
		o.setUser(user);
		em.persist(o);
		return o;
		
	}

	public Order getOrder(Long id) {
		Order o=em.find(Order.class, id);
		return o;
		
	}
	public Order confirmOrder(Order order, List<OrderLine> lines) {
		order.setOrderLines(lines);
		em.merge(order);
		return order;
	}

	public void deleteOrder(Long id) {
		deleteOrder(getOrder(id));		
	}
	
	public void deleteOrder(Order order) {
		em.remove(order);
	}
	

}