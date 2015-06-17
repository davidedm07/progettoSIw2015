package model;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

@Stateless
public class StoreHouseLineFacade {

	@PersistenceContext(unitName ="unit-progettoSiw2015" )
	private EntityManager em;

	public StoreHouseLine createStoreHouseLine(Product p, Long quantity) {
		StoreHouseLine sl =p.getQuantita();
		if(sl==null){
			StoreHouseLine str= new StoreHouseLine(p,quantity);
			p.setQuantita(str);
			em.merge(str);
			return str;}
		else{
			Long g=sl.getQuantity();
			g=g+quantity;
			sl.setQuantity(g);
			em.merge(sl);
			return sl;
		}


	}

	public StoreHouseLine getStoreHouseLine(Long id) {
		StoreHouseLine str= em.find(StoreHouseLine.class, id);
		return str;
	}

	public List<StoreHouseLine> getAllStoreHouseLines() {
		Query q=this.em.createQuery("SELECT s FROM StoreHouseLine s");
		List<StoreHouseLine> lines=q.getResultList();
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		session.setAttribute("elencoMagazzino", lines);
		return lines;
	}

	public void updateStoreHouseLine(StoreHouseLine str) {
		em.merge(str);
	}

	public void updateStoreHouseLine(StoreHouseLine str, Long quantity) {
		str.setQuantity(quantity);
		updateStoreHouseLine(str);

	}

	public void deleteStoreHouseLine(StoreHouseLine str) {
		em.remove(str);
	}

	public void deleteStoreHouseLine(Long id) {
		StoreHouseLine str=getStoreHouseLine(id);
		deleteStoreHouseLine(str);
	}

	public Product getProduct(Long idProdotto) {
		Product p= em.find(Product.class,idProdotto);
		return p;
	}




}
