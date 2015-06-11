<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:ui="http://java.sun.com/jsf/facelets">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link href="./css/bootstrap.min.css" rel="stylesheet" />
<link href="./css/custom.css" rel="stylesheet" />
<link href="./css/catalgo.css" rel="stylesheet" />
<title>Products</title>
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
								value=" Catalogo"></h:commandLink></li>
					</ul>
				</div>



				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container --> </nav>

			<div class="container">

				<h2>Catalogo</h2>

				<table>
					<tr>
						<th>Name</th>
						<th>Price</th>
					</tr>
					<c:forEach var="product" items="#{productController.products}">
						<tr>
							<td><h:commandLink action="#{productController.findProduct}"
									value="#{product.name}">
									<f:param name="id" value="#{product.id}" />
								</h:commandLink></td>
							<td>${product.price}</td>
						</tr>

					</c:forEach>
				</table>

			</div>
		</h:form>


	</f:view>
</body>
</html>