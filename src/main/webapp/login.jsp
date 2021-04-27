 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
 <mvc:resources mapping="/resources/**" location="/resources/static/" />
<html>
<head>
	<title>Login</title>
	<link rel="stylesheet" href="/css/login.css">
	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="container">
    <form action="" method="post">
      <h1>Login To Your Account</h1>
     <p style="color: red; font-size: 15px;">${mes}</p>
      <h2>Username</h2>
<input type="text" name="username" autofocus required>
      <h2>Password</h2>
<input type="password" name="password" required>
      <button type="submit">Login</button>
      <br>
      <p><a href="/register">Don't have an account ?</a></p>
    </form>
</div>
</body>
</html>