<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Demonstrates Multi User Log In</title>
</head>
<body>
	<h3> Enter details : </h3>
	
		<form:form method="POST" action="login" modelAttribute="userForm">
            <form:input path="username" placeholder="Username"/> <br/> <br/>
            <form:input path="password" type="password" placeholder="Password"/> <br/> <br/>
            
            <input type="submit" value="Log In"/>
    	</form:form>
	
		<!-- <form action="/session-mvc/login" method="post">
			Username : <input type="text" name="username" > <br/> <br/>
			Password : <input type="password" name="password"> <br/> <br/>
			<input type="submit" value = "Submit"/>
		</form> -->
</body>
</html>