package task2;

import java.util.Scanner;

public class StudentGradeCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of subjects: ");
		int numberOfSubjects = scanner.nextInt();

		int[] marks = new int[numberOfSubjects];
		int totalMarks = 0;

		for (int i = 0; i < numberOfSubjects; i++) {
			int mark = -1;
			while (mark < 0 || mark > 100) {
				System.out.print("Enter marks for subject " + (i + 1) + " : ");
				mark = scanner.nextInt();
				if (mark < 0 || mark > 100) {
					System.out.println("Invalid input. Marks should be between 0 and 100.");
				}
			}
			marks[i] = mark;
			totalMarks += marks[i];
		}

		double averagePercentage = totalMarks / (double) numberOfSubjects;

		char grade = calculateGrade(averagePercentage);

		System.out.println("\nResults:");
		System.out.println("Total Marks: " + totalMarks);
		System.out.println("Average Percentage: " + averagePercentage + "%");
		System.out.println("Grade: " + grade);

		scanner.close();
	}

	public static char calculateGrade(double averagePercentage) {
		if (averagePercentage >= 90) {
			return 'A';
		} else if (averagePercentage >= 80) {
			return 'B';
		} else if (averagePercentage >= 70) {
			return 'C';
		} else if (averagePercentage >= 60) {
			return 'D';
		} else {
			return 'F';
		}
	}
}
