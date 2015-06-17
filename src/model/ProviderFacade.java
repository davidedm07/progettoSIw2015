package model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



@Stateless(name="pFacade")
public class ProviderFacade  {

	@PersistenceContext(unitName ="unit-progettoSiw2015" )
	private EntityManager em;

	public Provider createProvider(String name, String email, String phoneNumber,
			String vatin, String street, String city, String state,
			String zipCode, String country) {

		Address address= new Address(street,city,state,zipCode,country);
		Provider provider= new Provider(name,email,phoneNumber,vatin, address);
		em.persist(provider);
		return provider;


	}

	public Provider getProvider(Long id) {
		Provider provider = em.find(Provider.class, id);
		return provider;
	}

	public List<Provider> getAllProvider() {
		Query q=this.em.createQuery("SELECT p FROM Provider p");
		List<Provider> provider=q.getResultList();
		return provider;
	}

	public void updateProvider(Provider provider) {
		em.merge(provider);
	}

	private void deleteProvider(Provider provider) {
		em.remove(provider);
	}

	public void deleteProvider(Long id) {
		Provider provider = em.find(Provider.class, id);
		deleteProvider(provider);
	}


}
