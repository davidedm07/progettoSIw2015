package controller;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Admin;
import model.AdminFacade;
import model.Order;
import model.User;


@ManagedBean

public class AdminController {


	@ManagedProperty(value="#{param.id}")
	private String email;
	private String password;
	private String username;
	private Date dateOfBirth;
	private String day;
	private String month;
	private String year;
	private Admin admin;
	private User user;
	@ManagedProperty(value="#{param.idUser}")
	private String emailUS;
	private List<Order> orders;
	@ManagedProperty(value="#{param.idOrdine}")
	private Long idOrdine;
	@EJB(name="adFacade")
	private AdminFacade adminFacade;
	private Order currentOrder;

	public String createAdmin() {
		this.admin=this.adminFacade.createAdmin(email,password,username,day,month,year);
		return "loginAmministratore"; 
	}

	public String loginAdmin() {
		this.admin=this.adminFacade.loginAdmin(email,password);
		if (admin==null)
			return "loginAmministratore.jsp"; 
		else{
			FacesContext context = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
			session.setAttribute("admin", this.admin);
			return "homepageAmministratore"; }

	}

	public String logout(){
		this.admin=null;
		FacesContext context=FacesContext.getCurrentInstance();
		HttpSession session= (HttpSession) context.getExternalContext().getSession(true);
		session.removeAttribute("admin");
		return "homepage";
	}

	public String manageOrders() {
		this.orders=this.adminFacade.getAllOrders();
		return "tuttiOrdini";	
	}
	public String manageOrdersEvasion() {
		this.orders=this.adminFacade.getEvasionOrders();
		return "gestioneOrdini";	
	}

	public String evadeOrder() {
		this.currentOrder=this.adminFacade.getOrder(idOrdine);
		boolean done=this.adminFacade.evadeOrder(this.currentOrder);
		if (done==true)
			return "evasioneCompletata";
		else
			return "erroreEvasione";

	}
	public String findOrder() {
		this.currentOrder=this.adminFacade.getOrder(idOrdine);
		return "dettaglioOrdine";
	}

	public String findUser() {
		this.user=this.adminFacade.getUser(emailUS);
		return "dettaglioUtente";
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public AdminFacade getAdminFacade() {
		return adminFacade;
	}

	public void setAdminFacade(AdminFacade adminFacade) {
		this.adminFacade = adminFacade;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
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

	public Order getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getEmailUS() {
		return emailUS;
	}

	public void setEmailUS(String emailUS) {
		this.emailUS = emailUS;
	}




}
