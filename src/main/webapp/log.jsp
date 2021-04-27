<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Log - ${name} </title>
</head>
<body>
 <nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">Log Updater</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="/">Logs</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <li><a href="/create"><span class="glyphicon glyphicon-plus"></span> Create</a></li>
      <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav> 
<br><br><br>
<form action="" method="post">
<div class="input-group">
      <input type="text" class="form-control" placeholder="Message" name="message">
      <div class="input-group-btn">
        <button class="btn btn-default" type="submit">Update</button>
      </div>
    </div>
    </form>
    <br>
<table class="table table-dark table-hover">
    <tbody>
    <c:forEach items="${messages}" var="mes">
      <tr>
        <td>${mes[0]}</td>
        <td>${mes[1]}</td>
	  </tr>
	  </c:forEach>
    </tbody>
  </table>
</body>
</html>