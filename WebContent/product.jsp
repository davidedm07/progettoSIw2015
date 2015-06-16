<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html>
<head>
<title>Product</title>
</head>
<body>

<f:view>
<h1>${productController.product.name}</h1>
<h2>Details</h2>
<div>Code: ${productController.product.code}</div>
<div>Price: ${productController.product.price}</div>
<div>Description: ${productController.product.description}</div>
<br><br><br><br>

<h:form>
<div><h:inputText value= "#{storeHouseLineController.quantity }" /> </div>

<div> <h:commandButton value="Inserisci Quantità in Magazzino" action ="#{storeHouseLineController.createStoreHouseLine}">
<f:param name= "product" value="#{productController.product}" />
</h:commandButton></div>

</h:form>
</f:view>

<br><br><br>
<button onclick="goBack()">Torna al catalogo</button>

<script>
function goBack() {
    window.history.back();
}
</script>
</body>
</html>