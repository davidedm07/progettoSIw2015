package model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class OrderLineFacade {
	
	@PersistenceContext(unitName ="unit-progettoSiw2015" )
	private EntityManager em;
	
	private ProductFacade productFacade;

	public OrderLine createOrderLine(Long id) {
		Product p= this.productFacade.getProduct(id);
		
		
		return null;
	}

}
