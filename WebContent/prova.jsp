<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Product</title>
</head>
<body>

<f:view>
<h1>${orderController.line}</h1>


</f:view>
<button onclick="goBack()">Torna al catalogo</button>

<script>
function goBack() {
    window.history.back();
}
</script>
</body>
</html>