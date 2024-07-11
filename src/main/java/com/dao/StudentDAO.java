package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Student;

public class StudentDAO {
private Connection con;

public StudentDAO(Connection con) {
	super();
	this.con = con;
}

public boolean addStudent(Student student) {
	boolean f = false;
	try {
		String query = "INSERT INTO students(id,name,email,age)VALUES(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, student.getId());
		ps.setString(2, student.getName());
		ps.setString(3, student.getEmail());
		ps.setInt(4, student.getAge());
		int i = ps.executeUpdate();
		if(i == 1) {
			f = true;
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return f;
}


public List<Student> selectStudentAll() {
	List<Student> student = new ArrayList<Student>();
	try {
		String query = "SELECT * FROM students";
		PreparedStatement prepareStatement = con.prepareStatement(query);
		
		ResultSet rs = prepareStatement.executeQuery();
		
		while(rs.next()){
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String email = rs.getString("email");
			int age = rs.getInt("age");
			
			student.add(new Student(id,name,email,age));
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return student;
}

public Student getStudentById(int id) {
	Student s = null;
	try {
		String query = "SELECT * FROM students where id = ?";
		PreparedStatement prepareStatement = con.prepareStatement(query);
		prepareStatement.setInt(1, id);
		ResultSet rs = prepareStatement.executeQuery();
		
		while(rs.next()){
			
			String name = rs.getString("name");
			String email = rs.getString("email");
			int age = rs.getInt("age");
			
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return s;
	
}
public boolean updateStudent(Student student) {
	boolean updated = false ;
	try {
		String query = "UPDATE students SET name = ?, emali = ?, age = ? WHERE id = ?";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, student.getName());
		preparedStatement.setString(2, student.getEmail());
		preparedStatement.setInt(3,student.getAge());
		preparedStatement.setInt(4, student.getId());
		updated = preparedStatement.executeUpdate() > 0;
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return updated;
}

public boolean deleteStudent(int id) {
	boolean f = false;
	try {
		String query = "DELETE FROM students WHERE id=?";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setInt(1,id);
		int i = preparedStatement.executeUpdate();
		if(i == 1) {
			f = true;
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return f;
	
}
}





































