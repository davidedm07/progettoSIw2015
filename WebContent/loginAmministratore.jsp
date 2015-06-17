<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./css/loginAmministratore.css" rel="stylesheet" />
<link href="./css/bootstrap.min.css" rel="stylesheet" />
<title>Login Amministratore</title>
</head>
<body>
	<f:view>
		<h:form>
			<div class="container">
				<div class="card card-container">
					<!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
					<img id="profile-img" class="profile-img-card"
						src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
					<p id="profile-name" class="profile-name-card"></p>
					<span id="reauth-email" class="reauth-email"></span> Email<font
						color="red"><h:inputText value="#{adminController.email}"
							required="true" requiredMessage="Email is mandatory" id="email" />
						<h:message for="email" /> </font> Password<font color="red"><h:inputSecret
							value="#{adminController.password}" required="true"
							requiredMessage="Password is mandatory" id="password" /> <h:message
							for="password" />
						<div id="remember" class="checkbox">
							<label> <input type="checkbox" value="remember-me">
								Remember me
							</label>
						</div> <h:commandButton action="#{adminController.loginAdmin }"
							value="Login">
						</h:commandButton> <a href="registrazioneAdmin.jsp">Registrati Come Admin</a> <a
						href="homepage.jsp">Homepage</a>
				</div>
				<!-- /card-container -->
			</div>
			<!-- /container -->
		</h:form>
	</f:view>
</body>
</html>