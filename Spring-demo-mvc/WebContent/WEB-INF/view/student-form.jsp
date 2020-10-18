<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

	<head>
		<title>Student Registration Form</title>
	</head>
	
	<body>
		<form:form action="processForm" modelAttribute="student" >
		
			First Name: <form:input path="firstName" />
			<br>
			
			Last Name: <form:input path="lastName"/>
			<br>
			
			Country: 
			<form:select path="country">
				<form:options items="${student.countryOptions }" />
		<!-- 	<form:option value="USA" label="USA" />
				<form:option value="France" label="France" />
				<form:option value="UAE" label="UAE" />
				<form:option value="Germany" label="Germany" />		 -->
			</form:select>
			<br>
			
			Favorite Language:
			Java <form:radiobutton path="favoriteLang" value="Java" />
			C# <form:radiobutton path="favoriteLang" value="C#" />
			Python <form:radiobutton path="favoriteLang" value="Python" />
			Ruby <form:radiobutton path="favoriteLang" value="Ruby" />
			<br>
			
			Operating Systems: 
			Windows <form:checkbox path="operatingSystems" value="Windows" />
			Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
			Linux <form:checkbox path="operatingSystems" value="Linux" />
			<br>
			
			<input type="submit" value="Submit" />
			
		</form:form>
	</body>
	
</html>