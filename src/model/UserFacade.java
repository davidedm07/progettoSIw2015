package model;

import java.util.List;

import javax.persistence.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

@Stateless(name="uFacade")
public class UserFacade {
	
	@PersistenceContext(unitName ="unit-progettoSiw2015" )
	private EntityManager em;

	public User createUser(String email, String password,String username) {
		User user= new User(email,password,username);
		em.persist(user);
		return user;
	}
	
	public User getUser(String email,String password) {
		Query q=this.em.createQuery("SELECT p From User p");
		List<User> us=q.getResultList();
		int c=0;
		for(User u:us){
			c++;
			if(u.getEmail().equals(email) && u.getPassword().equals(password));
			System.out.println(c);
			return u;
		}
		return null;
	}

	public List<User> getAllUsers() {
		CriteriaQuery<User> cq = em.getCriteriaBuilder().createQuery(User.class);
		cq.select(cq.from(User.class));
		List<User> users = em.createQuery(cq).getResultList();
		return users;
	}

	public void updateUser(User user) {
		em.merge(user);
	}

	private void deleteUser(User user) {
		em.remove(user);
	}

	public void deleteProduct(String email) {
		User user= em.find(User.class, email);
		deleteUser(user);
	}
}
