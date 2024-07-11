
<%@page import="com.entity.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.StudentDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.connection.DbConnection"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored = "false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@include file = "allCss.jsp"%>
<body class = "bg-light">
<%@include file="navbar.jsp" %>

 <%--... <% 
 Connection con = DbConnection.getConnection();
out.print(con);
--%> 


<div class = "container p-5">
<div class="card">
<div class="card-body">


<p class="text-center fs-1.5">Student Details</p>
<c:if test = "${not empty succMsg }">
				<p class = "text-center text-success">${succMsg }</p>
				<c:remove var="succMsg"/>
				</c:if>
				
				<c:if test = "${not empty errMsg }">
				<p class = "text-center text-success">${errMsg }</p>
				<c:remove var="errMsg"/>
				</c:if>
	<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Email</th>
      <th scope="col">Age</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  
  <%
  StudentDAO dao = new StudentDAO(DbConnection.getConnection());
  List<Student> list = dao.selectStudentAll();
  for(Student s : list){	  
  %>
  <tr>
      <th scope="row"><%= s.getId() %></th>
      <td><%= s.getName() %></td>
      <td><%= s.getEmail() %></td>
      <td><%= s.getAge() %></td>
      <td><a href = "update.jsp?id=<%= s.getId() %>" class="btn btn-sm btn-primary">Edit</a>
      <a href = "delete?id=<%= s.getId() %>" class = "btn btn-sm btn-danger ms-1">Delete</a>
      </td>
    </tr>
  <%
  }
  %>
  
    
    
    
  </tbody>
</table>
</div>

</div>
</div>
	
</body>
</html>