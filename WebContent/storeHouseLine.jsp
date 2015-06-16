<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Riga Magazzino</title>
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
				<td>${storeHouseLineController.product.price }</td>
				<td>${storeHouseLineController.quantity } </td>
				</tr>
			</tbody>
		</table>
	</f:view>

	<button onclick="goBack()">Torna al catalogo</button>

	<script>
		function goBack() {
			window.history.back();
		}
	</script>
</body>
</html>