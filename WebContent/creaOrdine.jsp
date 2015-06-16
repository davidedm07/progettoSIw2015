
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="bootstrap-3.3.4-dist/css/bootstrap.min.css">
<link href="./css/bootstrap.min.css" rel="stylesheet" />
<link href="./css/custom.css" rel="stylesheet" />
<title>Products</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>
	<f:view>
		<h1>New Order</h1>
		<div class="container">
			<table class="table table-striped">
				<thead>
					<tr>

						<th>Name</th>
						<th>Code</th>
						<th>Price</th>
						<th>Quantity:</th>
						<th>Conferma</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="product" items="#{orderController.catalogo}">
						<h:form>
							<tr>
								<td><h:commandLink action="#{orderLineController.findProduct}"
										value="#{product.name}">
										<f:param name="id" value="#{product.id}" />
									</h:commandLink></td>
								<td>${product.id}</td>
								<td>${product.price}</td>
								<td><h:inputText value="#{orderLineController.quantity}"
										id="quantity" /></td>
								<td><h:commandButton
										action="#{orderLineController.createOrderLine}" value="Aggiungi">

										<f:param name="id" value="#{product.id}" />
									</h:commandButton></td>
							</tr>
						</h:form>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<h:form>
			<div>
				<h:commandButton action="#{orderController.confirmOrder}"
					value="Conferma">
				</h:commandButton><td><td>
				<h:commandButton action="#{orderController.annullOrder}"
					value="Anulla">
				</h:commandButton>
				<td><td><h3><a href="homepageU.jsp" > Homepage</a> </h3>
			</div>
		</h:form>
	</f:view>
</body>
</html>

