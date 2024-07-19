package task5;

import java.util.HashMap;
import java.util.Map;

public class StudentManagementSystem {
	
    private Map<String, Student> students;

    public StudentManagementSystem() {
        students = new HashMap<>();
    }

    public void addStudent(Student student) {
        if (students.containsKey(student.getRollNumber())) {
            System.out.println("Roll number " + student.getRollNumber() + " already exists.");
        } else {
            students.put(student.getRollNumber(), student);
            System.out.println("Student with roll number " + student.getRollNumber() + " added.");
        }
    }
    
  
    public void removeStudent(String rollNumber) {
        if (students.remove(rollNumber) != null) {
            System.out.println("Student with roll number " + rollNumber + " removed.");
        } else {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    }

  
    public void searchStudent(String rollNumber) {
        Student student = students.get(rollNumber);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students are present in the database.");
        } else {
            students.values().forEach(System.out::println);
        }
    }
}
