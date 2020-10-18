<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<title>Student Confirmation</title>
	</head>
	
	<body>
		The student: ${student.firstName } ${student.lastName } is confirmed
		<br>
		Country: ${student.country }
		<br>
		Favorite Language: ${student.favoriteLanguage }
		<br>
		Operating Systems: 
		<ul>
			<c:forEach var="temp" items="${student.operatingSystems }">
				<li> ${temp } </li>
			</c:forEach>
		</ul>
		<br>
	</body>
	
</html>