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
<title>Registrati</title>
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
							<h:inputText value="#{userController.username}" required="true"
								requiredMessage="Username is mandatory" id="username" />
							<h:message for="username" />
						</div>

						<div class="form-group col-lg-12">
							<label>Password</label>
							<h:inputText value="#{userController.password}" required="true"
								requiredMessage="Password is mandatory" id="password" />
							<h:message for="password" />
						</div>

						<div class="form-group col-lg-12">
							<label>Email Address</label>
							<h:inputText value="#{userController.email}" required="true"
								requiredMessage="Email is mandatory" id="email" />
							<h:message for="email" />
						</div>
						<p>
							<strong>Birthday </strong>
						</p>

						<div class="form-group col-lg-12">
							<label>Day</label>
							<h:inputText value="#{userController.day}" required="true"
								requiredMessage="day is mandatory"
								converterMessage="day must be a number" id="day" />
							<h:message for="day" />
						</div>

						<div class="form-group col-lg-12">
							<label>Month</label>
							<h:inputText value="#{userController.month}" required="true"
								requiredMessage="month is mandatory"
								converterMessage="month must be a number" id="month" />
							<h:message for="month" />
						</div>

						<div class="form-group col-lg-12">
							<label>Year</label>
							<h:inputText value="#{userController.year}" required="true"
								requiredMessage="year is mandatory"
								converterMessage="zipCode must be a number" id="year" />
							<h:message for="year" />
						</div>


						<p>
							<strong>Address </strong>
						</p>

						<div class="form-group col-lg-12">
							<label>Street</label>
							<h:inputText value="#{userController.street}" required="true"
								requiredMessage="street is mandatory" id="street" />
							<h:message for="street" />
						</div>

						<div class="form-group col-lg-12">
							<label>City</label>
							<h:inputText value="#{userController.city}" required="true"
								requiredMessage="city is mandatory" id="city" />
							<h:message for="city" />
						</div>

						<div class="form-group col-lg-12">
							<label>State</label>
							<h:inputText value="#{userController.state}" required="true"
								requiredMessage="state is mandatory" id="state" />
							<h:message for="state" />
						</div>

						<div class="form-group col-lg-12">
							<label>ZipCode</label>
							<h:inputText value="#{userController.zipCode}" required="true"
								requiredMessage="zipCode is mandatory"
								converterMessage="zipCode must be a number" id="zipCode" />
							<h:message for="zipCode" />
						</div>

						<div class="form-group col-lg-12">
							<label>Country</label>
							<h:inputText value="#{userController.country}" required="true"
								requiredMessage="country is mandatory" id="country" />
							<h:message for="country" />
						</div>



					</div>
				</div>


				<div class="col-md-12">
					<h3 class="dark-grey">Terms and Conditions</h3>
					<p>By clicking on "Register" you agree to The Company's' Terms
						and Conditions</p>
					<p>While rare, prices are subject to change based on exchange
						rate fluctuations - should such a fluctuation happen, we may
						request an additional payment. You have the option to request a
						full refund or to pay the new price. (Paragraph 13.5.8)</p>
					<p>Should there be an error in the description or pricing of a
						product, we will provide you with a full refund (Paragraph 13.5.6)</p>
					<p>Acceptance of an order by us is dependent on our suppliers
						ability to provide the product. (Paragraph 13.5.6)</p>


					<h:commandButton value="Register"
						action="#{userController.createUser}" />
					<br> <br> <a href="homepage.jsp"><strong>Homepage</strong></a>

				</div>
			</div>
			</section>
			</div>
		</h:form>
	</f:view>
</body>
</html>