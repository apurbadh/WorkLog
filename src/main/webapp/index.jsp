 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
 <mvc:resources mapping="/resources/**" location="/resources/static/" /><html>
<head>
<title>
Log Updater
</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style>
.mes{
	text-align:center;
	opacity: 70%;
}

 * {
  box-sizing: border-box;
}

body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Float four columns side by side */
.column {
  float: left;
  width: 25%;
  padding: 0 10px;
}

/* Remove extra left and right margins, due to padding in columns */
.row {margin: 0 -5px;}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Style the counter cards */
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2); /* this adds the "card" effect */
  padding: 16px;
  text-align: center;
  background-color: #f1f1f1;
}

/* Responsive columns - one column layout (vertical) on small screens */
@media screen and (max-width: 600px) {
  .column {
    width: 100%;
    display: block;
    margin-bottom: 20px;
  }
}

.container{
	align-items: center;
}


</style>
</head>
<body>
 <nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">Log Updater</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/">Logs</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <li><a href="/create"><span class="glyphicon glyphicon-plus"></span> Create</a></li>
      <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav> 

<br><br>
<br><br>
<c:if test="${empty logs}">
	<h2 class="mes">No Logs Found!</h2>
</c:if>
<div class="container">
 <div class="row">
  
<c:forEach items="${logs}" var="log">
	<div class="column">
    <div class="card">
    <h4>${log}</h4>
    <a href="/log?name=${log}"><button class="btn btn-primary">Click Here</button></a>
    </div>
    </div>
</c:forEach>
</div>
</div>
  
</body>
</html>