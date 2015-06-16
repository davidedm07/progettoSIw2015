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
<title>Ordini</title>
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
				<!--vri campi <th>Data</th> -->		
					<!-- <th>User</th> -->	
				<!--  	<th>Customer</th> Andra implementato?-->
				<!--  	<th>Stato</th> Andra implementato penso per veedere se l'ordine è evaso o completato-->
						<th>Evadi</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="ordine" items="#{orderController.orders}">
						<h:form>
							<tr>
								<td><h:commandLink action="#{orderController.findOrder}"
										value="#{ordine.id}">
										<f:param name="id" value="#{ordine.id}" />
									</h:commandLink></td>
								<!--  vari campi da stampare<td>${ordine.(nomecampodata)}</td>
								<td>${ordine.(nomecampocliente per esempio)}</td>-->
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

