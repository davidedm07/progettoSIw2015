package model;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MainProva {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-progettoSiw2015");
		EntityManager em = emf.createEntityManager();

//		Product product = new Product();
//		product.setName("KRIDDIGAY");
//		product.setPrice(3.5F);
//		product.setDescription("A wonderful bla bla");
//		product.setCode("9781853262715-AA");
//
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//		em.persist(product);
//		tx.commit();
		Query q=em.createQuery("SELECT p From Product p");
		List<Product> products=q.getResultList();
		for(Product prod:products){
			System.out.println("");
			System.out.print(prod.getName());
			System.out.print(prod.getPrice());
		}
		em.close();
		emf.close();
		
		
		
	}
}
