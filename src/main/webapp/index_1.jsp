<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Demonstrates Multi User Log In</title>
</head>
<body>
	<h3> Enter detaisl : </h3>
	
		<form method="POST" action="login">
            <input name="username" type="text" placeholder="Username"/> <br/> <br/>
            <input name="password" type="password" placeholder="Password"/> <br/> <br/>
            
            <input type="submit" value="Log In">
    	</form>
	
		<!-- <form action="/session-mvc/login" method="post">
			Username : <input type="text" name="username" > <br/> <br/>
			Password : <input type="password" name="password"> <br/> <br/>
			<input type="submit" value = "Submit"/>
		</form> -->
</body>
</html>