<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="bootstrap-3.3.4-dist/css/bootstrap.min.css">
<link href="./css/bootstrap.min.css" rel="stylesheet" />
<link href="./css/custom.css" rel="stylesheet" />
<title>Registrazione</title>
</head>
<body>
	<f:view>
		<h:form>
			<div class="container-fluid">
				<section class="container">
				<div class="container-page">
					<div class="col-md-6">
						<h3 class="dark-grey">Registration</h3>

						<div class="form-group col-lg-12">
							<label>Username</label>
							<h:inputText value="#{adminController.username}" required="true"
								requiredMessage="Username is mandatory" id="username" />
							<h:message for="username" />
						</div>

						<div class="form-group col-lg-12">
							<label>Password</label>
							<h:inputText value="#{adminController.password}" required="true"
								requiredMessage="Password is mandatory" id="password" />
							<h:message for="password" />
						</div>

						<div class="form-group col-lg-12">
							<label>Email Address</label>
							<h:inputText value="#{adminController.email}" required="true"
								requiredMessage="Email is mandatory" id="email" />
							<h:message for="email" />
						</div>
						<p>
							<strong>Birthday </strong>
						</p>

						<div class="form-group col-lg-12">
							<label>Day</label>
							<h:inputText value="#{adminController.day}" required="true"
								requiredMessage="day is mandatory"
								converterMessage="day must be a number" id="day" />
							<h:message for="day" />
						</div>

						<div class="form-group col-lg-12">
							<label>Month</label>
							<h:inputText value="#{adminController.month}" required="true"
								requiredMessage="month is mandatory"
								converterMessage="month must be a number" id="month" />
							<h:message for="month" />
						</div>

						<div class="form-group col-lg-12">
							<label>Year</label>
							<h:inputText value="#{adminController.year}" required="true"
								requiredMessage="year is mandatory"
								converterMessage="zipCode must be a number" id="year" />
							<h:message for="year" />
						</div>

					</div>
				</div>


				<div class="col-md-12">


					<h:commandButton value="Register"
						action="#{adminController.createAdmin}" />
					<br> <br> <a href="homepage.jsp"><strong>Homepage</strong></a>

				</div>
			</div>
			</section>
			</div>
		</h:form>
	</f:view>
</body>
</html>