package model;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.servlet.http.HttpSession;


@Stateless(name="pFacade")
public class ProductFacade  {

	@PersistenceContext(unitName ="unit-progettoSiw2015" )
	private EntityManager em;

	public Product createProduct(String name, String code, Float price, String description) {
		Product product = new Product(name, price, description, code);
		em.persist(product);
		return product;
	}

	public Product getProduct(Long id) {
		Product product = em.find(Product.class, id);
		return product;
	}

	public List<Product> getAllProducts() {
		Query q=this.em.createQuery("SELECT p FROM Product p");
		List<Product> products=q.getResultList();
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
	
			session.setAttribute("catalogo", products);
		return products;
	}

	public void updateProduct(Product product) {
		em.merge(product);
	}

	private void deleteProduct(Product product) {
		em.remove(product);
	}

	public void deleteProduct(Long id) {
		Product product = em.find(Product.class, id);
		deleteProduct(product);
	}
}
