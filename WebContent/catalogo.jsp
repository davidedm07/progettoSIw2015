<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link href="./css/table.css" rel="stylesheet" />
<title>Products</title>
</head>
<body>
<f:view>

<h1 class="description">
  Catalogo Store
</h1>


<h:form>
<div class="box-table">
<table>

	<tr>
		<th>Name</th><th>Price</th><th>Code</th>
	</tr>
	<c:forEach var="product" items="#{productController.products}">
		<tr><td>
		<h:commandLink action="#{productController.findProduct}" value="#{product.name}">
			<f:param name="id" value="#{product.id}" />
		</h:commandLink>
		</td><td>${product.price}</td><td>${product.code}</td></tr>

	</c:forEach>
</table>
<br>
<br>
<br>
<h3><a href="homepage.jsp" > Homepage</a> </h3>
</h:form>

</f:view>
</body>
</html>