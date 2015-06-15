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
<title>Gestione Ordini</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>
	<f:view>
		<h1>Ordini</h1>
		<div class="container">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Codice</th>
						<th>Data Apertura </th>
						<th>Data Chiusura </th>
						<th>Cliente </th>
						<th>Evadi</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="ordine" items="#{adminController.orders}">
						<h:form>
							<tr>
								<td><h:commandLink action="#{adminController.findOrder}"
										value="#{ordine.id}">
										<f:param name="id" value="#{ordine.id}" />
									</h:commandLink></td>
								<td>${ordine.creationDate }</td>
								<td>${ordine.closingDate} </td>
								<td>${ordine.user.username } </td>
								<td><h:commandButton action="#{adminController.evadeOrder }" value="Evadi">
								<f:param name="idProdotto" value="#{order.id}" /></h:commandButton></td>
							</tr>
						</h:form>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<h:form>
			<div>	
				<h3><a href="homepage.jsp" > Homepage</a> </h3>
			</div>
		</h:form>
	</f:view>
</body>
</html>