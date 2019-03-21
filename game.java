package game;
import java.util.Scanner;

public class game {

	// Skapa variabler f�r att h�lla koll p� sv�righetsgraden och spelet i sig
	public static final int easy = 1;
	public static final int normal = 2;
	public static final int hard = 3;
	public static final int extreme = 4;

	public static int difficulty = 0;

	// Skapa en metod f�r att s�tta ett nummer i relevans till sv�righetsgraden
	private static int High(int difficulty) {
		int result = 100;

		switch (difficulty) {
		case easy: {
			result = 25;
		}
			break;

		case normal: {
			result = 100;
		}
			break;

		case hard: {
			result = 250;
		}
			break;

		case extreme: {
			result = 500;
		}
			break;
		// Ifall anv�ndaren skriver n�t annat �n 1 - 4
		default: {
			result = 100;
		}
		}

		return result;
	}

	private static int Random(int difficulty) {
		int high = High(difficulty);
		int result = (int) (Math.random() * high);

		return result;
	}

	// Skapa metoden som �ndrar sv�righetsgraden ifall spelaren vill spela igen
	private static int CorrectAnswer(Scanner scanner, boolean newDifficulty) {
		if (newDifficulty) {
			System.out.println("Choose your difficulty (Default is normal): ");
			System.out.printf("\tEasy: %d\n", easy);
			System.out.printf("\tNormal: %d\n", normal);
			System.out.printf("\tHard: %d\n", hard);
			System.out.printf("\tExtreme: %d\n", extreme);

			difficulty = scanner.nextInt();
		}

		int correctGuess = Random(difficulty);

		return correctGuess;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Skapa en variabel som tar ett slumpm�ssigt tal fr�n CorrectAnswer metoden
		int correctGuess = CorrectAnswer(scanner, true);

		boolean running = true;
		while (running) {
			// Anv�ndaren gissar ett nummer
			System.out.printf("Guess a number: ");
			int guess = scanner.nextInt();
			System.out.println();
			// Ifall talet �r h�gre �n svaret
			if (guess > correctGuess) {
				System.out.println("Lower");
			} // Ifall talet �r l�gre �n svaret
			else if (guess < correctGuess) {
				System.out.println("Higher");
			} // Ifall talet �r r�tt
			else {
				System.out.println("-----------");
				System.out.println("Correct");
				System.out.println("-----------");
				// Fr�ga ifall spelaren vill spela igen, alternativt �ndra sv�righetsgrad
				System.out.println("1: Play again");
				System.out.println("2: New difficulty");
				System.out.println("3: Quit");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1: {
					correctGuess = CorrectAnswer(scanner, false);
				}
					break;

				case 2: {
					correctGuess = CorrectAnswer(scanner, true);
				}
					break;

				default: {
					running = false;
				}
					break;
				}

			}
		}

		scanner.close();
	}

}