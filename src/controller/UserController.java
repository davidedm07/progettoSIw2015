package controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import model.User;
import model.UserFacade;

@ManagedBean
//@SessionScoped
public class UserController {

	@ManagedProperty(value="#{param.id}")
	private String email;
	private String password;
	private String username;

	@EJB
	private UserFacade userFacade;

	public String createUser() {
		this.userFacade.createUser(email,password,username);
		return "homepage.jsp";

	}
	
	public String loginUser() {
		User user=this.userFacade.getUser(email, password);
		if (user.checkPassword(password)==false)
			return "errore"; // creare pagina errore login
		return "homepage.jsp"; // magari nuova versione homepage dove ci sono dati utente
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}




}
