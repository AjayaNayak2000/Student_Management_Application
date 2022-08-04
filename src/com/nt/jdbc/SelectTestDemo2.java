package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTestDemo2 {


	public static void main(String[] args) throws Exception {
		Connection con =null;
		Statement st =null;
		ResultSet rs =null;
		try {
		//Load JDBC driver class optional
		Class.forName("com.mysql.cj.jdbc.Driver");
		//create the connection statement
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ntaj915db","root","root");
		//Create statement object
		if(con!=null)
			    st=con.createStatement();
		//Prepare sql query
		String query ="SELECT SNO,SNAME FROM STUDENT";
		//Execute the query
		if(st!=null)
			    rs=st.executeQuery(query);
		if(rs!=null) {
			boolean isEmpty=true;
			while(rs.next()) {
				isEmpty=false;
				System.out.println(rs.getInt(1)+"  "+rs.getString(2));
			}//while
			if(isEmpty) {
				System.out.println("Record not found");
			}
			else {
				System.out.println("Record found and displayed");
			}//else
		}//if
		}//try
		catch( SQLException sqle) {
			sqle.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//close jdbc object
			try {
				if(rs!=null)
					 rs.close();
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				if(st!=null)
					st.close();
			} catch (SQLException e3) {
				e3.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			} catch (SQLException e4) {
				e4.printStackTrace();
			}
		}//finally

	//Main

}//Class
/*
 101   raja
102   rajesh
103   mahesh
104   yuga
109   AKBK
123   AKBK
124   AKBK
1001   raja
2001   bikash
3001   bijay
4001   bunty
 */
 */

