<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Concesionaria Xideral</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Concesionaria Xideral</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Student -->
			
			<input type="button" value="Agregar automovil" 
				   onclick="window.location.href='add-auto-form.jsp'; return false;"
				   class="add-auto-button"
			/>
			
			<table>
			
				<tr>
					<th>Modelo</th>
					<th>Marca</th>
					<th>Matrícula</th>
					<th>Acción</th>
				</tr>
				
				<c:forEach var="tempAuto" items="${AUTO_LIST}">
					
					<!-- set up a link for each student -->
					<c:url var="tempLink" value="AutoControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="autoId" value="${tempAuto.id}" />
					</c:url>

					<!--  set up a link to delete a student -->
					<c:url var="deleteLink" value="AutoControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="autoId" value="${tempAuto.id}" />
					</c:url>
																		
					<tr>
						<td> ${tempAuto.modelo} </td>
						<td> ${tempAuto.marca} </td>
						<td> ${tempAuto.matricula} </td>
						<td> 
							<a href="${tempLink}">Actualizar</a> 
							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('¿Estás seguro que quieres eliminar este automovil?'))) return false">
							Eliminar</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








