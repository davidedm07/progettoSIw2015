<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Product</title>
</head>
<body>

	<f:view>
		<h1>${orderLineController.product.name}</h1>
		<h2>Details</h2>
		<div>Code: ${orderLineController.product.code}</div>
		<div>Price: ${orderLineController.product.price}</div>
		<div>Description: ${orderLineController.product.description}</div>
		<br>
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