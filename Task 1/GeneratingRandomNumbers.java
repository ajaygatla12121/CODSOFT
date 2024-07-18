package task1;

import java.util.Random;
import java.util.Scanner;

public class GeneratingRandomNumbers {

	static Scanner scanner = new Scanner(System.in);
	static int min;
	static int max;
	static int num;
	static int attempts;

	public static void main(String[] args) {

		boolean play = true;
		int totalRounds = 0;
		int totalAttempts = 0;

		while (play) {
			totalRounds++;
			System.out.println("Enter Range");
			System.out.print("Minimum Value: ");
			min = scanner.nextInt();

			System.out.print("Maximum Value: ");
			max = scanner.nextInt();

			if (min == max) {
				System.out.println("Minimum and Maximum Numbers cannot be the same");
			} else {
				System.out.println("\nRandom number from " + min + " to " + max + "\n");

				num = GenearteRandomNumber(min, max); 
				guessNumber();
				totalAttempts += attempts;
			}

			System.out.print("Do you want to play again? (yes/no): ");
			play = scanner.next().equalsIgnoreCase("yes");
		}

		System.out.println("Thank you for playing!");
		System.out.println("Total rounds played: " + totalRounds);
		System.out.println("Total attempts: " + totalAttempts);
		System.out.println("Average attempts per round: " + (totalAttempts / (double) totalRounds));
		scanner.close();
	}

	public static int GenearteRandomNumber(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min + 1) + min;
	}

	public static void guessNumber() {

		boolean correct = false;
		attempts = 0;

		System.out.println("Guess the Number from " + min + " to " + max);
		System.out.println("You have only 5 attempts\n");

		while (!correct && attempts < 5) {
			attempts++;
			System.out.print("Attempt " + attempts + " - Enter your guess: ");
			int guess = scanner.nextInt();

			if (guess < num) {
				System.out.println("\nToo Low");
			} else if (guess > num) {
				System.out.println("\nToo High");
			} else {
				System.out.println("\nYes, You are right");
				correct = true;
			}
		}

		if (!correct) {
			System.out.println("\nSorry, you've used all your attempts. The correct number was " + num + ".");
		}
	}
}
