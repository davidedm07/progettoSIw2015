<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registrati</title>
</head>
<body>
	<f:view>
		<h:form>
			<div>
				Email:
				<h:inputText value="#{userController.email}" required="true"
					requiredMessage="Email is mandatory" id="email" />
				<h:message for="email" />
			</div>
			<div>
				Password:
				<h:inputText value="#{userController.password}" required="true"
					requiredMessage="Password is mandatory" id="password" />
				<h:message for="password" />
			</div>
			<div>
				Username
				<h:inputText value="#{userController.username}" required="true"
					requiredMessage="Username is mandatory" id="username" />
				<h:message for="username" />
			</div>
			<div>
				<h:commandButton value="Submit"
					action="#{UserController.createUser}" />
			</div>
		</h:form>
	</f:view>
</body>
</html>