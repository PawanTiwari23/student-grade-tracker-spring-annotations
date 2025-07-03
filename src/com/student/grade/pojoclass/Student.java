// This is the package for the Student class.
package com.student.grade.pojoclass;
//This class stores information about one student.
public class Student {
	private String name;  // This is the student's Details.
    private int rollNumber;
    private String subject;
    

	private double marks;

    public Student() {} // Default constructor (no arguments).
       
 // Constructor with arguments. It sets name, rollNumber, and marks.
    public Student(String name, int rollNumber, String subject, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subject = subject;
        this.marks = marks;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getRollNumber() { return rollNumber; }
    public void setRollNumber(int rollNumber) { this.rollNumber = rollNumber; }
    public String getSubject() {return subject;}

	public void setSubject(String subject) { this.subject = subject;}

    public double getMarks() { return marks; }
    public void setMarks(double marks) { this.marks = marks; }
    
 // This method returns the student details as a text line.
    @Override
    public String toString() {
        return   "Name:" +name +", Roll No: " + rollNumber + ", Subject :" + subject + ", Marks: " + marks;
    }

}
