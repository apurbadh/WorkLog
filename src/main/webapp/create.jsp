<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
<title>Create Log</title>
</head>
<body>
<!-- Default form contact -->
<form class="text-center border border-light p-5" action="" method="post">

    <p class="h4 mb-4">Create Log</p>
    <p style="color: red">${createMes}</p>

    <!-- Name -->
    <input type="text" id="defaultContactFormName" class="form-control mb-4" placeholder="Name" name="name">

    <!-- Subject -->
    <label>Users</label>
    <select class="selectpicker form-control-lg" multiple data-live-search="true" name="users">
        <option value="" disabled>Choose users</option>
        <c:forEach items="${users}" var="user">
        	<option value="${user}">${user}</option>
        </c:forEach>
    </select>


    <!-- Send button -->
    <button class="btn btn-info btn-block" type="submit">Create</button>

</form>
<!-- Default form contact -->

</body>
</html>