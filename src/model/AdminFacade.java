package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
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


	//	public Admin loginAdmin(String email, String password) {
	//		Admin admin= em.find(Admin.class, email);
	//		if (admin.checkPassword(password)!=true)
	//			return null;	
	//		return admin;
	//	}
	public Admin loginAdmin(String email, String password) {
		Query q=this.em.createQuery("SELECT a From Admin a");
		List<Admin> ad=q.getResultList();

		for(Admin a:ad){

			if(a.getEmail().equals(email) && a.getPassword().equals(password))
				return a;
		}
		return null;
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
	
	public List<Order> getEvasionOrders() {
		Query q=this.em.createQuery("SELECT o FROM Order o"); // aggiungere controllo data chiusura (forse non serve)
		List<Order> orders=q.getResultList();
		List<Order> or= new LinkedList<>();
		for(Order o: orders ){
			if(o.getEvasionDate() == null )
				or.add(o);
		}
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		session.setAttribute("ordini",orders);
		return or;

	}

	public Order getOrder(Long id) {
		Order o=em.find(Order.class, id);
		return o;

	}
	public User getUser(String id) {
		User u=em.find(User.class, id);
		return u;

	}

	public void updateOrder(Order order) {
		em.merge(order);
	}

	public boolean evadeOrder(Order order) {
		boolean checkPossible=checkEvasion(order);
		if (checkPossible) {
            updateQuantities(order);
			order.setEvasionDate(new Date());
			updateOrder(order);
			return true;
		}
		return false;

	}

	private void updateQuantities(Order order) {
		for (OrderLine l : order.getOrderLines()) {
			StoreHouseLine str=l.getProduct().getQuantita();
			Long quantity=str.getQuantity()- l.getQuantity();
			str.setQuantity(quantity);
			em.merge(str);
		}
	}

	private boolean checkEvasion(Order order) {
		for (OrderLine l : order.getOrderLines()) {
			StoreHouseLine str=l.getProduct().getQuantita();
			Long quantity=str.getQuantity()- l.getQuantity();
			if (quantity<0)
				return false;
		}
		return true;
	}

}
