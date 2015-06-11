package model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class OrderLineFacade {
	
	@PersistenceContext(unitName ="unit-progettoSiw2015" )
	private EntityManager em;
	
	private ProductFacade productFacade;

	public OrderLine createOrderLine(Long id,int quantity) {
		Product p= this.productFacade.getProduct(id);
		OrderLine line=new OrderLine (p,quantity,p.getPrice());
		return line;
	}

}
