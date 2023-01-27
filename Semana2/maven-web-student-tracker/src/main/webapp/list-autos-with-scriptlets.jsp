<%@ page import="java.util.*, com.luv2code.web.jdbc.*" %>
<!DOCTYPE html>
<html>

<head>
	<title>Consecionaria Xideral</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<%
	// get the students from the request object (sent by servlet)
	List<Auto> theAuto = 
					(List<Auto>) request.getAttribute("AUTO_LIST");
%>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Consecionaria Xideral</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<table>
			
				<tr>
					<th>Modelo</th>
					<th>Marca</th>
					<th>Matrícula</th>
				</tr>
				
				<% for (Auto tempAuto : theAutos) { %>
				
					<tr>
						<td> <%= tempAuto.getModelo() %> </td>
						<td> <%= tempAuto.getMarca() %> </td>
						<td> <%= tempAuto.getMatricula() %> </td>
					</tr>
				
				<% } %>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








