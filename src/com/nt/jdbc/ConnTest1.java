package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnTest1 {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","SYSTEM");
		System.out.println("Con Obj class:"+con.getClass());
		if(con==null)
		System.out.println("Established");
		else
			System.out.println("Established");
	}

}
