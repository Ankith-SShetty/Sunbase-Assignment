package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.DbConnection;
import com.dao.StudentDAO;
import com.entity.Student;

@WebServlet("/add")
public class AddServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		int age = Integer.parseInt(req.getParameter("age"));
		Student student = new Student(id,name,email,age);
		
		StudentDAO dao = new StudentDAO(DbConnection.getConnection());
		
		HttpSession session = req.getSession();
		
		boolean f = dao.addStudent(student);
		if(f) {
			session.setAttribute("succMsg","Student Details Submitted..!");
			resp.sendRedirect("add.jsp");
			
		}else {
			session.setAttribute("errMsg","Something went wrong...");
			resp.sendRedirect("add.jsp");
		}
	}
	
}
