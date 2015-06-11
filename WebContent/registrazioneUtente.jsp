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
<link href="./css/bootstrap.min.css"
	rel="stylesheet" />
<link href="./css/custom.css"
	rel="stylesheet" />
<title>Registrati</title>
</head>
<body>
	<f:view>
		<h:form>
		
		<!-- Navigation -->
			<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="homepage.jsp">Home</a>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="#">About</a></li>
						<li><a href="login.jsp">Login</a></li>
						<li><a href="registrazioneUtente.jsp">Register</a></li>
						<li><a href="newProduct.jsp">Prodotto</a></li>
						<li><h:commandLink action="#{productController.listProducts}"
						value =" Catalogo"></h:commandLink></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container --> </nav>
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

						<div class="col-sm-6">
							<input type="checkbox" class="checkbox" />Sign up for our
							newsletter
						</div>

					</div>


					<div class="col-md-6">
						<h3 class="dark-grey">Terms and Conditions</h3>
						<p>By clicking on "Register" you agree to The Company's' Terms
							and Conditions</p>
						<p>While rare, prices are subject to change based on exchange
							rate fluctuations - should such a fluctuation happen, we may
							request an additional payment. You have the option to request a
							full refund or to pay the new price. (Paragraph 13.5.8)</p>
						<p>Should there be an error in the description or pricing of a
							product, we will provide you with a full refund (Paragraph
							13.5.6)</p>
						<p>Acceptance of an order by us is dependent on our suppliers
							ability to provide the product. (Paragraph 13.5.6)</p>


						<h:commandButton value="Register"
							action="#{userController.createUser}" />

					</div>
				</div>
				</section>
			</div>
		</h:form>
	</f:view>
</body>
</html>