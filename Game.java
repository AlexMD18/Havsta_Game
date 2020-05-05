package Game;

import java.util.Scanner;
import java.util.Random;

public class Game {
	public static void main(String args[]) {
		Scanner kbd = new Scanner(System.in);
		char choice = 'Y';
		int rounds = 0;
		int humanWins = 0;
		int computerWins = 0;
		int humanMoves, computerMoves, game;
		
		//do while loop that is the brain of the program. It runs what the user sees and connects all the methods together.
		do {
			rules();
			System.out.println("\nWould you like to play a round? Type Y for yes and N for no.");
			
			choice = kbd.next().charAt(0);
			
			if(choice == 'Y'|| choice == 'y') {
				rounds++;
				humanMoves = getMove();
				computerMoves = getComputerMove();
				game = checkWinner(humanMoves, computerMoves);
				System.out.println("Your Move: " + assignNum(humanMoves));
			    System.out.println("Computer Move: " + assignNum(computerMoves));
				
				if(game == 1) {
					System.out.println("The Computer Won\n");
					computerWins++;
				}
				else {
					System.out.println("You win!\n");
					humanWins++;
				}
			}
			else if (choice == 'N'|| choice == 'n'){
				printScore(rounds, humanWins, computerWins);
				System.exit(0);
			}
			else {
				System.out.println("Invald choice, please enter a Y or an N\n");
			}	
		}while(true);
	}
	
	//Method to print the rules of the game so the user knows what move wins in each situation
	public static void rules() {
		System.out.println("Rules: \nApplaro beats Svartra and Tunholmen.\n" + "Svartra beats Tunholmen\n"
				+ "Tunholmen beats Godafton\n" + "Godafton beats Applaro and Svartrå\n"
				+ "The computer wins in the event of a tie.");
	}

	//Method to get the move that the user selects. Prints error if the choice is outside the range of 1-4.
	public static int getMove() {
		Scanner kbd = new Scanner(System.in);
		int input;

		do {

			System.out.println("\nPlease Choose a Move");
			System.out.print("1: Applaro \t2: Svarta \t3: Tunholmen \t4: Godafton\n");
			System.out.println("Enter Move Here: ");
			input = kbd.nextInt();

			if (input > 0 && input <= 4) {
				return input;
			} else {
				System.out.println(
						"\nError, you did not select one of the provided moves. Please enter a number between 1 and 4.");
			}

		} while (true);
	}

	//Method to have computer randomly select a move.
	public static int getComputerMove() {
		final int MIN = 1;
		final int MAX = 4;

		Random rnd = new Random();
		int compMove = rnd.nextInt(MAX) + MIN;

		return compMove;
	}
	
	//Method to assign a move each of the numbers 1-4. 
		public static String assignNum(int i) {
			String assignment = "";

			switch (i) {
			case 1:
				assignment = "Applaro";
				break;
			case 2:
				assignment = "Svarta";
				break;
			case 3:
				assignment = "Tunholmen";
				break;
			case 4:
				assignment = "Godafton";
				break;
			}
			return assignment;
		}

	//Method that compares the moves to each other using the numbers from the assignNum method. 
	public static int checkWinner(int human, int computer) {
		int win = 1;
		if (human == 1) {
			if ((computer == 2 || computer == 3))
				win = 2;
		} 
		else if (human == 2 && computer == 3) {
			win = 2;
		} 
		else if (computer == 3 && computer == 4) {
			win = 2;
		} 
		else if (human == 4)
			if ((computer == 1) || (computer == 2)) {
				win = 2;
			}
		// In the case of a tie
		if (human == computer)
			win = 1;
		return win;
	}

	//Method to print the final scores, the rounds played and the number of wins for the user and the computer.
	public static void printScore(int rounds, int playerWins, int computerWins) {
		System.out.println("Final Scores:");
		System.out.println("Rounds Played:" + rounds);
		System.out.println("Player Wins:" + playerWins);
		System.out.println("Computer Wins:" + computerWins);
	}
}
