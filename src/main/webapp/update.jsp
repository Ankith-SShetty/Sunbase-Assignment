<%@page import="com.entity.Student"%>
<%@page import="com.connection.DbConnection"%>
<%@page import="com.dao.StudentDAO"%>
<%@page import="com.servlet.AddServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file = "allCss.jsp" %>
</head>
<body class = "bg-light">
<%@include file="navbar.jsp" %>
<div class = "container p-4">
	<div class ="row">
		<div class = "col-md-6 offset-md-3">
			<div class = "card">
				<div class = "card-body">
				<p class = "fs-3 text-center">Edit Student</p>
				<%
				int id = Integer.parseInt(request.getParameter("id"));
				StudentDAO dao = new StudentDAO(DbConnection.getConnection());
				Student s = dao.getStudentById(id);
				%>
<form action="update" method = "post">
		<div class="mb-3"> 
    <label class="form-label">ID</label>
    <input type="number"  name = "id" class="form-control">
  </div>		
  <div class="mb-3"> 
    <label class="form-label">Name</label>
    <input type="text"  name = "name" class="form-control">
  </div>
  <div class="mb-3">
    <label class="form-label">Email</label>
    <input type="email"  name = "email" class="form-control">
  </div>
  <div class="mb-3">
    <label class="form-label">Age</label>
    <input type="number"  name = "age" class="form-control">
  </div>
  
  <button type="submit" class="btn btn-primary col-md-12">UPDATE</button>
</form>
				
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>