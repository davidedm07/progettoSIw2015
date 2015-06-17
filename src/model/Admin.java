package model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="admin")
public class Admin {

	@Id 
	private String email;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String username;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationDate;


	public Admin(String email, String password,String username) {
		this.email=email;
		this.password=password;
		this.username=username;
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

	public boolean checkPassword(String psw) {
		if (this.password!=psw)
			return false;
		else
			return true;
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




}