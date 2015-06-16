package controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import model.Address;
import model.Order;
import model.User;
import model.UserFacade;

@ManagedBean
@SessionScoped
public class UserController {

	@ManagedProperty(value="#{param.id}")
	private String email;
	private String password;
	private String username;
	private User user;
	private Date dateOfBirth;
	private Date registrationDate;
	private Address address;
	private String street;
	private String city;	
	private String state;
	private String zipCode;
	private String country;
	private String day;
	private String month;
	private String year;
	private List<Order> orders;
	private Order currentOrder;
	@ManagedProperty(value="#{param.idOrdine}")
    private Long idOrdine;
	

	@EJB(name="uFacade")
	private UserFacade userFacade;
	

	public String createUser() {
		this.user= userFacade.createUser(email,password,username,street,city,state,zipCode,country,day,month,year);
		return "user.jsp";

	}

	public String loginUser() {
		this.user=this.userFacade.getUser(email, password);
		if (user==null)
			return "login.jsp"; // creare pagina errore login
		else{
			FacesContext context = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
			session.setAttribute("user", this.user);
		return "homepageU.jsp"; // magari nuova versione homepage dove ci sono dati utente
		}
	}
	
public String logout(){
	this.user=null;
	FacesContext context=FacesContext.getCurrentInstance();
	HttpSession session= (HttpSession) context.getExternalContext().getSession(true);
	session.removeAttribute("user");
	return "homepage";
}

public String findOrder() {
	this.currentOrder=this.userFacade.getOrder(idOrdine);
	return "dettaglioOrdineU";
}

public String manageOrders() {
	this.orders=this.userFacade.getAllOrders();
	return "listaOrdini";	
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Long getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(Long idOrdine) {
		this.idOrdine = idOrdine;
	}

	public UserFacade getUserFacade() {
		return userFacade;
	}

	public void setUserFacade(UserFacade userFacade) {
		this.userFacade = userFacade;
	}

	public Order getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}

	



}
