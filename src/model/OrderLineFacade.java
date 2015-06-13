package model;
import model.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class OrderLineFacade {
	
	@PersistenceContext(unitName ="unit-progettoSiw2015")
	private EntityManager em;
	
	private ProductFacade productFacade;

	public OrderLine createOrderLine() {
		Product p=new Product("provariga", (float) 12, "daje", "tert");
OrderLine line=new OrderLine(p, 3, (float) 2);
		//		Product p= this.productFacade.getProduct(id);
//		OrderLine line=new OrderLine (p,quantity,p.getPrice());
		em.persist(line);
		return line;
	}
	
	public OrderLine getProduct(Long id) {
		OrderLine line = em.find(OrderLine.class, id);
		return line;
	}
	
	public void updateOrderLine(OrderLine line) {
		em.merge(line);
	}

	private void deleteOrderLine(OrderLine line) {
		em.remove(line);
	}

	public void deleteOrderLine(Long id) {
		OrderLine line = em.find(OrderLine.class, id);
		deleteOrderLine(line);
	}

}