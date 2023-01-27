<!DOCTYPE html>
<html>

<head>
	<title>Agregar automovil</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Concesionaria Xideral</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Add Auto</h3>
		
		<form action="AutoControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Modelo:</label></td>
						<td><input type="text" name="modelo" /></td>
					</tr>

					<tr>
						<td><label>Marca:</label></td>
						<td><input type="text" name="marca" /></td>
					</tr>

					<tr>
						<td><label>Matricula:</label></td>
						<td><input type="text" name="matricula" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="AutoControllerServlet">Back to List</a>
		</p>
	</div>
</body>

</html>











