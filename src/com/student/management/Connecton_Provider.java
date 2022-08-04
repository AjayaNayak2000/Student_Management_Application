package com.student.management;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connecton_Provider  {
	 static Connection con;
	 public static  Connection create() {
		 try {
			 //Load jdbc driver class
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 //Create the connections
			 String user="root";
			 String password="root";
			 String url="jdbc:mysql://localhost:3306/student_mang_syst";
			 con=DriverManager.getConnection(url,user,password);
			 
			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	 }

}
