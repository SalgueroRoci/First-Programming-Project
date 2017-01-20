//*******************************************************************
// File Name: NameDisplay.java
//  Programmer(s): Rocio Salguero 
//  Class: CPSC Java  223J - Section 02
// Project 1 
// 	Due date: 08/30/2016
//	Description: Displays a greeting card for a person   
//  
//*******************************************************************


import java.util.*; // header stuff MUST go above the first class

// our main class becomes a file but the main method is still found
public class NameDisplay
{ 
  public static String firstName, middleName, lastName; 
	  
	public static void get_name() {
	    Scanner input = new Scanner(System.in); 
	   	System.out.print("What is your first name?"); 
	   	firstName = input.nextLine(); 
	   	System.out.print("What is your middle name?"); 
        middleName = input.nextLine(); 
		System.out.print("What is your last name?"); 
		lastName = input.nextLine(); 
	  }
	  
	public static void display_card() {
	 	System.out.print("<<<<<<<Happy Birthday " + firstName + " " + middleName + " " + lastName + " >>>>>>>\n"); 
	}
	                         
	public static void main(String[] args)
	{
	  	System.out.print("Give me your name, I will send you a birthday card\n");
	   	get_name();
	   	display_card(); 
	}
}

