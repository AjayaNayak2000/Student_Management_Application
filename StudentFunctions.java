package com.student.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentFunctions {
   public static boolean insertIntoStudentToDb(Student st) {

	   boolean f=false;

			try {
				//jdbc code here
				Connection con=Connecton_Provider.create();
				String q="insert into students(sname,sphone,scity) values(?,?,?)";
				//prepared statement
				PreparedStatement pstmt =con.prepareStatement(q);
				pstmt.setString(1, st.getStudentName());
				pstmt.setString(2, st.getStudentPhone());
				pstmt.setString(3, st.getStudentCity());
				//Execute the query
				pstmt.executeUpdate();
				f=true;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	   return f;
   }

public static boolean deleteStudent(int userId) {
	boolean f=false;
	try {
		Connection con =Connecton_Provider.create();
		String q="delete from students where sid=?";
		//Prepared statement
		PreparedStatement pstmt =con.prepareStatement(q);
		//Set the value of parameter
		pstmt.setInt(1, userId);
		//Execute the query
		pstmt.executeUpdate();
		f=true;
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return f;
}
public static void showAllStudent() {
	try {
		Connection con =Connecton_Provider.create();
		String q="select * from students ";
		Statement stmt =con.createStatement();

		//Execute the query
		ResultSet rs=stmt.executeQuery(q);
		while(rs.next()) {
			int id=rs.getInt(1);
			String name=rs.getString(2);
			String phone=rs.getString(3);
			String city=rs.getString(4);
			System.out.println("ID :"+id);
			System.out.println("NAME :"+name);
			System.out.println("Phone :"+phone);
			System.out.println("city :"+city);
			System.out.println("-----------------");		
		}	
	} catch (Exception e) {
		e.printStackTrace();
	}	
}
}
