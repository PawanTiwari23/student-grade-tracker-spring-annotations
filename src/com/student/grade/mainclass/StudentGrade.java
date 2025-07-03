// This is the package name. It helps organize your code.
package com.student.grade.mainclass;

import java.util.Scanner; // Import Scanner to take input from the user.

//Import Spring classes to use the Spring container.
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//Import the Student Pojo class and Student Logic class.
import com.student.grade.logicclass.StudentLogic;
import com.student.grade.pojoclass.Student;

@Configuration  // Tells Spring that this is a configuration class.

//Tells Spring to scan this package for components (beans).
@ComponentScan("com.student.grade.logicclass") 

public class StudentGrade {

	public static void main(String[] args)  // This is the main method. The program starts here.
	{
		 // Create a Spring container. It will manage your beans.
		 ApplicationContext context = new AnnotationConfigApplicationContext(StudentGrade.class);
		 
		// Get the StudentLogic bean from the Spring container.
		 StudentLogic service = context.getBean(StudentLogic.class);
	    

	        Scanner sc = new Scanner(System.in);  // Make a Scanner object to read user input.
	        
	        // Show a welcome message to the user.
	        System.out.println("=== Welcome to Student Grade Tracker [Spring Core] ===");
	        
	        // Ask the user how many students they want to enter.
	        System.out.print("Enter number of students: ");
	        
	        int count = sc.nextInt(); // Read the number.
	        sc.nextLine();  // Read the leftover newline character.
	        
	        // Loop to take details for each student.
	        for (int i = 0; i < count; i++) {
	            System.out.println("Enter details for Student " + (i + 1) + ":");
	            
	            // Read the student's name.
	            System.out.print("Name: ");
	            String name = sc.nextLine();
	           
	            // Read the student's Roll no.
	            System.out.print("Roll Number: ");
	            int roll = sc.nextInt();
	            sc.nextLine(); // Read the the new line
	       
	            
	         // Create an array with available subjects
	            String[] subjects = {"Java Programming", "Python Programming", "Web Development", "Data Structures", "Machine Learning"};
	            
	         // Show the subjects list with numbers
	            System.out.println("Available Subjects:");
	            for (int j = 0; j < subjects.length; j++) {
	                System.out.println((j + 1) + ". " + subjects[j]);
	            }

	         // Ask the user to pick a subject number
	            System.out.print("Choose subject number: ");
	            int choice = sc.nextInt();
	            sc.nextLine();

	            String subject = "";   // Initialize subject name
	         // If user picks a valid number, get subject name from array
	            if (choice >= 1 && choice <= subjects.length) {
	                subject = subjects[choice - 1];
	            } else {
	                subject = "Unknown";   // If number is invalid, set default as 'Unknown'
	            }
	            
	            // Read the student's Marks.
	            System.out.print("Marks: ");
	            double marks = sc.nextDouble();
	           sc.nextLine(); // Read the new line.
	            
	            // Create a new Student object with the given data.
	            Student s = new Student(name, roll, subject ,marks);
	            
	            service.addStudent(s);  // Add the student to the list using StudentService.
	        }

	        service.displaySummary(); // After adding all students, show the summary report.
	        sc.close();   // Close the Scanner.

	}

}
