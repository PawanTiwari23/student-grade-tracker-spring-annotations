// This is the package for the Student logic class.
package com.student.grade.logicclass;

import java.util.ArrayList;  // Import ArrayList to store students.

//This annotation tells Spring to make this class a bean.
import org.springframework.stereotype.Component;

//Import the Student pojo class.
import com.student.grade.pojoclass.Student;
//This is the StudentLogic class. It has all the logic to manage students.
@Component

public class StudentLogic {
	 // This list stores all the students.
	
	private ArrayList<Student> students = new ArrayList<>();
	  // This method adds a new student to the list.
    public void addStudent(Student s) {
        students.add(s);
    }
    // This method calculates the average marks.
    public double calculateAverage() {
        double total = 0;
     // Add all students' marks.
        for (Student s : students) {
            total += s.getMarks();
        }
        return students.size() > 0 ? total / students.size() : 0;  // If list is not empty, return average.
    }
    // This method finds the highest marks.
    public double findHighestMarks() {
        double highest = Double.MIN_VALUE;
        // Check each student's marks.
        for (Student s : students) {
            if (s.getMarks() > highest) {
                highest = s.getMarks();
            }
        }
        return highest;
    }
    // This method finds the lowest marks.
    public double findLowestMarks() {
        double lowest = Double.MAX_VALUE;
        // Check each student's marks.
        for (Student s : students) {
            if (s.getMarks() < lowest) {
                lowest = s.getMarks();
            }
        }
        return lowest;
    }
    // This method shows a summary of all students and the stats.
    public void displaySummary() {
        System.out.println("\n----- Student Summary Report -----");
        
        // Print each student's details.
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("----------------------------------");
        System.out.println("Average Marks: " + calculateAverage());
        System.out.println("Highest Marks: " + findHighestMarks());
        System.out.println("Lowest Marks : " + findLowestMarks());
    }

    

}
