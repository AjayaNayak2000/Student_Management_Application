package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTestDemo1 {

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
		String query ="SELECT * FROM STUDENT";
		//Execute the query
		if(st!=null)
			    rs=st.executeQuery(query);
		if(rs!=null) {
			boolean isEmpty=true;
			while(rs.next()) {
				isEmpty=false;
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
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

	}//Main

}//Class
/*
 101  raja  hyd  80.66
102  rajesh  vizag  81.66
103  mahesh  delhi  88.66
104  yuga  hyd  77.87
109  AKBK  CTC  67.43
123  AKBK  CTC  67.43
124  AKBK  CTC  67.43
1001  raja  cuttack  70.66
2001  bikash  ctc  76.8
3001  bijay  bls  45.44
4001  bunty  kpd  76.99
Record found and displayed
 */
