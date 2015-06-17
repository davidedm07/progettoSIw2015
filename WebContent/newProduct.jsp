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
<title>New Product</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
	<f:view>
		<h:form>


			<h2>Details</h2>
			<table class="table table-striped">
				<thead>
					<tr>

						<th>Name</th>
						<th>Code</th>
						<th>Price</th>
						<th>Description</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><h:inputText value="#{productController.name}"
								required="true" requiredMessage="Name is mandatory" id="name" />
							<h:message for="name" /></td>
						<td><h:inputText value="#{productController.code}"
								required="true" requiredMessage="Code is mandatory" id="code" />
							<h:message for="code" /></td>
						<td><h:inputText value="#{productController.price}"
								required="true" requiredMessage="Price is mandatory"
								converterMessage="Price must be a number" id="price" /> <h:message
								for="price" /></td>
						<td><h:inputTextarea value="#{productController.description}"
								required="false" cols="20" rows="5" /></td>
					</tr>
				</tbody>
			</table>



			<div>
				<h:commandButton value="Submit"
					action="#{productController.createProduct}" />
			</div>
			<div>
				<a href="homepageAmministratore.jsp">HomePage</a>
			</div>
		</h:form>
	</f:view>
</body>
</html>