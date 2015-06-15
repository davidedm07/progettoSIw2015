package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

@Stateless
public class AdminFacade {

	@PersistenceContext(unitName ="unit-progettoSiw2015" )
	private EntityManager em;


	public Admin loginAdmin(String email, String password) {
		Admin admin= em.find(Admin.class, email);
		if (admin.checkPassword(password)!=true)
			return null;	
		return admin;
	}


	public Admin createAdmin(String email, String password, String username,
			String day, String month, String year)  {

		Admin admin= new Admin(email,password,username);
		Date registrationDate= new Date();
		admin.setRegistrationDate(registrationDate);
		DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		Date dateofBirth=null;
		try {
			dateofBirth = formatter.parse(day+"/"+month+"/"+year+"");
		} catch (ParseException e) {
			// new Date cambia alcuni valori, questo andrà aggiustato 
			e.printStackTrace();
		}
		admin.setDateOfBirth(dateofBirth);
		em.persist(admin);
		return admin;
	}

	public Admin getAdmin(String email,String password) {
		Query q=this.em.createQuery("SELECT p From User p");
		List<Admin> admin=q.getResultList();
		//int c=0;
		for(Admin ad:admin){
			//c++;
			if(ad.getEmail().equals(email) && ad.getPassword().equals(password))
				return ad;
		}
		return null;
	}

	public void updateAdmin(Admin admin) {
		em.merge(admin);
	}

	public void deleteAdmin(Admin admin) {
		em.remove(admin);
	}

	public void deleteAdmin(Long id) {
		Admin admin=em.find(Admin.class, id);
		deleteAdmin(admin);

	}

	public List<Order> getAllOrders() {
		Query q=this.em.createQuery("SELECT o FROM Order o"); // aggiungere controllo data chiusura (forse non serve)
		List<Order> orders=q.getResultList();
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		session.setAttribute("ordini",orders);
		return orders;

	}

	public Order getOrder(Long id) {
		Order o=em.find(Order.class, id);
		return o;

	}
	
	public void updateOrder(Order order) {
		em.merge(order);
	}

	public void evadeOrder(Order order) {
		order.setEvasionDate(new Date());
		updateOrder(order);

	}
}
