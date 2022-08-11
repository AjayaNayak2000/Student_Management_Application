package com.student.management;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.PublicKey;

public class Student_Mang_System {

	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to student management system");
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Press 1 to add student :");
			System.out.println("Press 2 to delete student :");
			System.out.println("Press 3 to display student :");
			System.out.println("Press 4 to Exit from table :");
			int c=Integer.parseInt(br.readLine());
			if(c==1) {
				//Add student details into student table
				System.out.println("Enter student name :");
				String name=br.readLine();
				System.out.println("Enter student phone :");
				String phone=br.readLine();
				System.out.println("Enter student city :");
				String city=br.readLine();			
				Student st=new Student(name, phone, city);
				boolean answer=StudentFunctions.insertIntoStudentToDb( st);
				if (answer) {
					System.out.println("Student is added successfully");
				}else {
					System.out.println("Something went wrong");
				}			
				System.out.println(st);		
			}else if (c==2) {
				System.out.println("Enter student id to delete :");
				int userId=Integer.parseInt(br.readLine());
				boolean f=StudentFunctions.deleteStudent(userId);
				if (f) {
					System.out.println("Deleted successfully");
				}else {
					System.out.println("Something went wrong");
				}			
			}else if (c==3) {
				System.out.println("All the data in the table");
				StudentFunctions.showAllStudent();			
			}else if (c==4) {
				break;
				
			}else {
				
			}
		}//While
		System.out.println("This is all about The crud applocations");
		System.out.println("Thank you for using my application");	
	}//Main
}//Class
