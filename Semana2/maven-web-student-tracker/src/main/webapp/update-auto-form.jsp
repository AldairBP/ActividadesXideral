<!DOCTYPE html>
<html>

<head>
	<title>Actualizar automovil</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Consecionaria Xideral</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Actualizar automovil</h3>
		
		<form action="AutoControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="autoId" value="${THE_AUTO.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Modelo:</label></td>
						<td><input type="text" name="modelo" 
								   value="${THE_AUTO.modelo}" /></td>
					</tr>

					<tr>
						<td><label>Marca:</label></td>
						<td><input type="text" name="marca" 
								   value="${THE_AUTO.marca}" /></td>
					</tr>

					<tr>
						<td><label>Matricula:</label></td>
						<td><input type="text" name="matricula" 
								   value="${THE_AUTO.matricula}" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Guardar" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="AutoControllerServlet">Regresar a la lista</a>
		</p>
	</div>
</body>

</html>











