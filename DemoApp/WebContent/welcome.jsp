<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
<style>
 	body
 	{
 		background-image:url("naruto desktop wlpr.jpg");
 		background-repeat:no-repeat;
 		background-size: 100%;
 	}
 	h1
 	 {
	  color: black;
	  margin-left: 20px;
	  text-align:center;
	  font-size:25px;
	  font-family: Fantasy;
	}
</style>
</head>
<body>


	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if(session.getAttribute("username")==null)
		{
			response.sendRedirect("login.jsp");
		}
	%>
	
	<h1>Welcome ${username}, you cannot become Hokage in a day! It is the same in building this website. Come back later in the year for some awesome content!</h1>
	<form action = "logoutServlet">
	<input type="submit" value="logout">
	</form>
	

</body>
</html>