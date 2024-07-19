package task5;

import java.util.Scanner;

public class StudentManagementApp {
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
            
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine().trim();
                    System.out.print("Enter roll number: ");
                    String rollNumber = scanner.nextLine().trim();
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine().trim();
                    system.addStudent(new Student(name, rollNumber, grade));
                    break;
                    
                case 2:
                    System.out.print("Enter roll number to remove: ");
                    String rollNumberToRemove = scanner.nextLine().trim();
                    system.removeStudent(rollNumberToRemove);
                    break;
                    
                case 3:
                    System.out.print("Enter roll number to search: ");
                    String rollNumberToSearch = scanner.nextLine().trim();
                    system.searchStudent(rollNumberToSearch);
                    break;
                    
                case 4:
                    system.displayAllStudents();
                    break;
                    
                case 5:
                    scanner.close();
                    System.out.println("Exited");
                    return;
                    
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

