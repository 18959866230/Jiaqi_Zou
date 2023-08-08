package assign03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * The CS 1410 class with assignment 3: Wordle.
 * 
 * @author Jiaqi Zou
 * @version February 2,2023
 */
public class ConsoleWordle {
	
	/**
	 * The method is aim to read in data from the file named in the parameter and
	 * returns the data as an array.
	 * 
	 * @param string type parameter called words.
	 * @return array type return called data.
	 * @throws FileNotFoundException
	 */
	public static String[] readFile(String words) throws FileNotFoundException {
		File importFile = new File(words);
		Scanner tokens = new Scanner(importFile);
		int arrayLength = tokens.nextInt();
		tokens.nextLine();
		String[] data = new String[arrayLength];
		for (int i = 0; i < arrayLength; i++) {
			data[i] = tokens.nextLine();
		}
		tokens.close();
		return data;
	}
	
	/**
	 * The method is aim to with given an array of words (the parameter), select one
	 * randomly and returns it.
	 * 
	 * @param string array parameter called wordArray.
	 * @return string type return called wordArray[i].
	 */
	public static String getSecretWord(String[] wordArray) {
		Random selectedWord = new Random();
		int i = selectedWord.nextInt(wordArray.length);
		return wordArray[i];
	}

	/**
	 * This method returns true if the char (first parameter) matches one of the
	 * letters in the String (second parameter), and false otherwise.
	 * 
	 * @param char   type parameter1 called letterInWord.
	 * @param string type parameter2 called word.
	 * @return boolean type return.
	 */
	public static boolean letterContainedInWord(char letterInWord, String word) {
		for (int i = 0; i < word.length() - 1; i++) {
			if (letterInWord == word.charAt(i)) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * This method asks the user for a 5-letter word and returns the word.
	 * 
	 * @param scanner type parameter called inputMessage.
	 * @return string type return called guess.
	 */
	public static String getUserGuess(Scanner inputMessage) {
		String guess;
		do {
			System.out.print("Enter a 5-letter word: ");
			guess = inputMessage.nextLine();
		} while (guess.length() != 5);
		return guess;
	}
	
	/**
	 * This method prints to the console the results of the user's guess for one round.
	 * Letters show up in correct places, display the letter capitalized.
	 * In incorrect places but correct letter in the secret word, display the letter in its original lower case form.
	 * wrong places and wrong letters, display a dash '-'.
	 * 
	 * @param string type parameter called userGuess.
	 * @param string type parameter called secretWord.
	 */
	public static void displayResultOfRound(String userGuess, String secretWord) {
		boolean[] found = new boolean[secretWord.length()];
		for (int i = 0; i < userGuess.length(); i++) {
			char currentUserGuess = userGuess.charAt(i);
			boolean correct = false;
			for (int j = 0; j < secretWord.length(); j++) {
				if (secretWord.charAt(j) == currentUserGuess && !found[j]) {
					if (i == j) {
						System.out.print(Character.toUpperCase(currentUserGuess));
						correct = true;
						found[j] = true;
						break;
					} else {
						System.out.print(currentUserGuess);
						correct = true;
						break;
					}
				}
			}
			if (!correct) {
				System.out.print("-");
			}
		}
		System.out.println();
	}

	/** The main method is doing following things:
	 * 1. Read words from the provided file and store in an array, using the readFile method.
	 * 2. Randomly choose a word from the array to be the secret word, using the getSecretWord method.
     * 3. Create a new Scanner object with System.in.
     * 4. Ask the user for a guess from the user, using the getUserGuess method, and give feedback on that guess, using the displayResultOfRound method.  
          This step should be repeated until the user's guess completely matches the secret word or six rounds are completed.  
          Do not use System.exit to terminate the program, since this will not behave properly with the autograder.
     * 5. Print a winning message if the user guesses the secret word and a losing message if it is not guessed after six rounds.  The losing message should include the secret word.
     * 6. Wrap all code in a try-catch for the FileNotFoundException thrown by the readFile method.  Print a message about not finding the file in the catch part.
     * 7. Close the Scanner object created with System.in.
     * 
	 * @param args.
	 */
	public static void main(String[] args) {
		try {
			String[] wordsArray = readFile("words.txt");
			String theSecretWord = getSecretWord(wordsArray);
			Scanner userInputMessage = new Scanner(System.in);
			int round = 0;
			while (round < 6) {
				String guessWord = getUserGuess(userInputMessage);
				displayResultOfRound(guessWord, theSecretWord);
				if (guessWord.equals(theSecretWord)) {
					System.out.println("Congratulations! You win!!!");
					break;
				}
				round++;
			}
			if (round == 6) {
				System.out.println("Pity! You've lost 6 chances on guessing the secret word " + theSecretWord + ".");

			}
			userInputMessage.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}

	}
}