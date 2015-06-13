package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
