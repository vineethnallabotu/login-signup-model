<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
<link rel="stylesheet" href="/DemoApp/style.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/javasc.js"></script>
</head>
<body>

<div class="login-page">
  <div class="form">
    <form class="login-form" action ="login">
      <input type="text" name = "uname" placeholder="Username"/>
      <input type="password" name= "pass" placeholder="Password"/>
      <button>login</button>
      <p class="message">Not registered? <a href="signup.jsp">Create an account</a></p>
    </form>
    <%
    if(null!=request.getAttribute("errorMessage"))
    {
        out.println(request.getAttribute("errorMessage"));
    }
	%>
  </div>
</div>
</body>
</html>