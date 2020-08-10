<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup Here!</title>
<link rel="stylesheet" href="/DemoApp/style.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/javasc.js"></script>
</head>
<body>
<div class="login-page">
  <div class="form">
    <form action="signmeup" class="login-form" >
      <input type="text" name="suname" placeholder="Enter Username"/>
      <input type="password" name= "spass" placeholder="Enter password"/>
      <button>create</button>
      <p class="message">Already registered? <a href="login.jsp">Sign In</a></p>
    </form>
    <%
    if(null!=request.getAttribute("error"))
    {
        out.println(request.getAttribute("error"));
    }
	%>
    </div>
 </div>
 ${Error}
</body>
</html>