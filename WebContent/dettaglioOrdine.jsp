<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="bootstrap-3.3.4-dist/css/bootstrap.min.css">
<link href="./css/bootstrap.min.css" rel="stylesheet" />
<link href="./css/custom.css" rel="stylesheet" />
<title>Dettaglio Ordine</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
<f:view>
<h2>Dettaglio Ordine ${adminController.currentOrder.id}</h2>


			<table class="table table-striped">
				<thead>
					<tr>
						<th>Codice</th>
						<th>Codice prodotto</th>
						<th>Nome prodotto</th>
						<th>Quantita </th>
						<th>Prezzo Unitario </th>
					</tr>
				</thead>
				<tbody>
<c:forEach var="ordine" items="#{adminController.currentOrder.orderLines}">
<tr>
								<td>${ordine.id} </td>
								<td>${ordine.product.id }</td>
								<td>${ordine.product.name }</td>
								<td>${ordine.quantity }</td>
								<td>${ordine.unitPrice} </td><tr>
								
					
					</c:forEach>
				</tbody>
			</table>
		

</f:view>
<button onclick="goBack()">Torna agli ordini</button>

<script>
function goBack() {
    window.history.back();
}
</script>
</body>
</html>