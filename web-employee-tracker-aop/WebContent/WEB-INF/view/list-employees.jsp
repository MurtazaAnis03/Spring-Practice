<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

	<head>

		<title>Employee List</title>
		
		<link type="text/css"
				rel="stylesheet"
				href="${pageContext.request.contextPath}/resources/css/style.css" />

	</head>

	<body>

		<div id="wrapper">
			<div id="header">
				<h2>Employee Tracker</h2>
			</div>
		</div>
		
		<div id="container">
			<div id="content">
				
				<input type="button" value="Add Employee" 
				onclick="window.location.href='showFormForAdd'; return false; " 
				class="add-button" />
				
				<table>
					<tr>
						<th>ID <a href="${pageContext.request.contextPath }/employee/orderById">^</a></th>
						<th>First Name <a href="${pageContext.request.contextPath }/employee/orderByFirstName">^</a></th>
						<th>Last Name <a href="${pageContext.request.contextPath }/employee/orderByLastName">^</a></th>
						<th>Email</th>
						<th>Action</th>
					</tr>
					
					<c:forEach var="temp" items="${employees}">
						
						<c:url var="editLink" value="/employee/showFormForEdit">
							<c:param name="employeeId" value="${temp.id}" />
						</c:url>
						
						<c:url var="deleteLink" value="/employee/delete">
							<c:param name="employeeId" value="${temp.id}" />
						</c:url>
						
						<tr>
							<td>${temp.firstName}</td>
							<td>${temp.lastName}</td>
							<td>${temp.email}</td>
							<td>
								<a href="${editLink}" >Edit</a>
								|
								<a href="${deleteLink}" 
								onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">Delete</a>
							</td>
						</tr>
					</c:forEach>
					
				</table>
				
			</div>
		</div>

	</body>

</html>