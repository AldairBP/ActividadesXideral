<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Guardar vehículo</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Vehículos Xideral</h2>
		</div>
	</div>

	<div id="container">
		<h3>Guardar vehículo</h3>
	
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Modelo:</label></td>
						<td><form:input path="modelo" /></td>
					</tr>
				
					<tr>
						<td><label>Marca:</label></td>
						<td><form:input path="marca" /></td>
					</tr>

					<tr>
						<td><label>Matrícula:</label></td>
						<td><form:input path="matricula" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Guardar" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Regresar a la lista</a>
		</p>
	
	</div>

</body>

</html>










