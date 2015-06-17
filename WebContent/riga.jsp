<%@page import="org.apache.openejb.math.stat.descriptive.summary.Sum"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Riga Ordine</title>
</head>
<body>

	<f:view>
		<h2>Codice Prodotto : ${orderLineController.idProdotto}</h2>
		<h2>Details</h2>
		<div>Quantity: ${orderLineController.ol.quantity}</div>
		<div>Price unitary: ${orderLineController.ol.unitPrice}</div>

		<br>
		<br>
		<br>

	</f:view>
	<button onclick="goBack()">Torna al catalogo</button>

	<script>
		function goBack() {
			window.history.back();
		}
	</script>
</body>
</html>