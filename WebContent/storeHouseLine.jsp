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
<title>Riga Magazzino</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
	<f:view>
		<h2>${storeHouseLineController.idProdotto}</h2>
		<h2>Details</h2>
		<table class="table table-striped">
			<thead>
				<tr>

					<th>Name</th>
					<th>Code</th>
					<th>Price</th>
					<th>Quantita in Magazzino</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${storeHouseLineController.product.name }</td>
					<td>${storeHouseLineController.product.code }</td>
					<td>${storeHouseLineController.product.price }</td>
					<td>${storeHouseLineController.quantity }</td>
				</tr>
			</tbody>
		</table>
	</f:view>

	<button onclick="goBack()">indietro</button>

	<script>
		function goBack() {
			window.history.back();
		}
	</script>
	<a href="homepageAmministratore.jsp">Home</a>
</body>
</html>