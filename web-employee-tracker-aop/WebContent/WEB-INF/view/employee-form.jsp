<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

	<head>

		<title>Add Employee Form</title>

		<link type="text/css"
				rel="stylesheet"
				href="${pageContext.request.contextPath}/resources/css/style.css" />
				
		<link type="text/css"
				rel="stylesheet"
				href="${pageContext.request.contextPath}/resources/css/add-employee-style.css" />
		
	</head>
	
	<body>
	
		<div id="wrapper">
			<div id="header">
				<h2>Employee Tracker</h2>
			</div>
		</div>
		
		<div id="container">
			<h3>Add Employee</h3>
			
				<form:form action="addEmployee" modelAttribute="employee" method="POST">
				
					<form:hidden path="id" />
				
					<table>
						<tbody>
							
							<tr>
								<td><label>ID:</label></td>
								<td><form:input path="id" /></td>
							</tr>
							
							<tr>
								<td><label>First Name:</label></td>
								<td><form:input path="firstName" /></td>
							</tr>
							
							<tr>
								<td><label>Last Name:</label></td>
								<td><form:input path="lastName" /></td>
							</tr>
							
							<tr>
								<td><label>Email:</label></td>
								<td><form:input path="email" /></td>
							</tr>
							
							<tr>
								<td><label></label></td>
								<td><input type="submit" value="Add" class="save"/></td>
							</tr>
							
						</tbody>
					</table>
				
				</form:form>
	
				<div style="clear; both;"></div>
				
				<p>
					<a href="${pageContext.request.contextPath}/employee/list">Back</a>
				</p>
				
		</div>
	
	</body>
	
</html>