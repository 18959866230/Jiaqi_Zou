// CS 1410 Assignment 2: Problem solving practice by Jiaqi Zou (January 25, 2023).
package assign02;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemSolvingPractice {
	// The isPalindrome method is aim to check if the message we enter reads the same forwards as backwards, and if not
	// it will return false, if yes it will return true. 
	public static boolean isPalindrome(String inputWord) {
		int index = inputWord.length();
		boolean result = false;
		for (int x = 0; x < index - 1; x++) {
			if (inputWord.charAt(x) == inputWord.charAt(index - 1 - x))
				result = true;
			else {
				return result;
			}
		}
		return result;
	}

	// The countIntTokens method is aim to count how many integers in the message we enter, and return the times of integers showing up. 
	public static int countIntTokens(String inputSentence) {
		int counter = 0;
		Scanner tokens = new Scanner(inputSentence);
		while (tokens.hasNext()) {
			if (tokens.hasNextInt()) {
				counter++;
			}
			tokens.next();
		}
		tokens.close();
		return counter;

	}

	//The moreOddThanEven method is aim to check if the message we enter has integer and if there are more odd integers than 
	//even integers, it will return true, otherwise it will return false. 
	public static boolean moreOddThanEven(String inputMessage) {
		int oddCounter = 0;
		int evenCounter = 0;
		Scanner tokens = new Scanner(inputMessage);
		while (tokens.hasNext()) {
			if (tokens.hasNextInt()) {
				int variable = tokens.nextInt();
				if (variable % 2 == 0) {
					evenCounter++;
				} else {
					oddCounter++;
				}
			}else {
				tokens.next();
			}
		}
		tokens.close();
		return oddCounter > evenCounter;
	}
	
		
    //The camelCase method is aim to make a change on the message user enters, making all first lower case letter in each word 
	//to an upper case letter, except the first word. And also remove all white spaces between words. Return the changed result 
	//we get. 
	public static String camelCase(String lowerCaseWord) {
		String finalResult = "";
		Scanner tokens = new Scanner(lowerCaseWord);
		boolean firstWord = true;
		while(tokens.hasNext()) {
			String selectedWord = tokens.next();
			if(firstWord) {
				finalResult += selectedWord;
				firstWord = false;
			}else {
				finalResult += Character.toUpperCase(selectedWord.charAt(0));
				finalResult += selectedWord.substring(1);
			}
			
		}
		tokens.close();
		return finalResult;
	}
	
	//The positiveAverage method is aim to calculate all the positive integers' average value from an integer type array, 
	//make it as double type and return it. 
	public static double positiveAverage(int[] targetArray) {
		double total = 0;
		int count = 0;
		for(int index = 0; index < targetArray.length; index ++ ) {
			if( targetArray[index] > 0) {
				total += targetArray[index];
				count ++;
			}
		}
		return total / count;
	}
	
	//The frequencyCount method is aim to count the frequency of numbers(from 1 to 10) showing up in the parameter array,
	//the first value in the returned array is the number of times 1 appears in the parameter array, the second value is the number times 2 appears, and so on
	// and finally return the integer type array that showing that frequency. 
	public static int[] frequencyCount(int[] inputArray) {
		int[] frequencyArray = new int[10];
		for(int i = 0; i < inputArray.length; i++ ) {
			if(inputArray[i] >= 1 && inputArray[i] <= 10) {
				frequencyArray[inputArray[i] - 1]++;
			}
		}
		return frequencyArray;
	}

	public static void main(String[] args) {
		System.out.println("Checking isPalindrome(\"abba\"). Expecting a result of true. The actual result is "
				+ isPalindrome("abba") + ".");
		System.out.println("Checking isPalindrome(\"cddddc\"). Expecting a result of true. The actual result is "
				+ isPalindrome("cddddc") + ".");
		System.out.println("Checking isPalindrome(\"bad\"). Expecting a result of false. The actual result is "
				+ isPalindrome("bad") + ".");
		System.out.println("Checking isPalindrome(\"\"). Expecting a result of false. The actual result is "
				+ isPalindrome("") + ".");

		
		System.out.println("Checking countIntTokens(\"there are 3 exams in 1410\"). Expecting a result of 2. The actual result is "
						+ countIntTokens("there are 3 exams in 1410") + ".");
		System.out.println("Checking countIntTokens(\"hello\"). Expecting a result of 0. The actual result is "+ countIntTokens("hello") + ".");
		System.out.println("Checking countIntTokens(\"hello, there is 12 and 3 in 2 sentence\"). Expecting a result of 3. The actual result is "
				+ countIntTokens("hello, there is 12 and 3 in 2 sentence") + ".");
		System.out.println("Checking countIntTokens(\"\"). Expecting a result of 0. The actual result is "+ countIntTokens("") + ".");
		
		
		System.out.println("Checking moreOddThanEven(\"1 3 4 6 Hello -8\"). Expecting a result of false. The actual result is "
				+ moreOddThanEven("1 3 4 6 Hello -8") + ".");
		System.out.println("Checking moreOddThanEven(\"1 3 5 9 Hello -8\"). Expecting a result of true. The actual result is "
				+ moreOddThanEven("1 3 5 9 Hello -8") + ".");
		System.out.println("Checking moreOddThanEven(\"2 4 6 8 Hello -8\"). Expecting a result of false. The actual result is "
				+ moreOddThanEven("2 4 6 8 Hello -8") + ".");
		System.out.println("Checking moreOddThanEven(\"\"). Expecting a result of false. The actual result is "
				+ moreOddThanEven("") + ".");
		
		
		System.out.println("Checking camelCase(\"first letter in word\"). Expecting a result of firstLetterInWord. The actual result is "
				+ camelCase("first letter in word") + ".");
		System.out.println("Checking camelCase(\"there is one sentence\"). Expecting a result of thereIsOneSentence. The actual result is "
				+ camelCase("there is one sentence") + ".");
		System.out.println("Checking camelCase(\"he is too tall for me\"). Expecting a result of heIsTooTallForMe. The actual result is "
				+ camelCase("he is too tall for me") + ".");
		System.out.println("Checking camelCase(\"\"). Expecting a result of . The actual result is "
				+ camelCase("") + ".");
		
		System.out.println("Checking positiveAverage(\"new int[]{2, 3, 4}\"). Expecting a result of 3.0. The actual result is "
				+ positiveAverage(new int[]{2, 3, 4}) + ".");
		System.out.println("Checking positiveAverage(\"new int[]{6, 7, 8}\"). Expecting a result of 7.0. The actual result is "
				+ positiveAverage(new int[]{6, 7, 8}) + ".");
		System.out.println("Checking positiveAverage(\"new int[]{-1, 6, 6}\"). Expecting a result of 6.0. The actual result is "
				+ positiveAverage(new int[]{-1, 6, 6}) + ".");
		System.out.println("Checking positiveAverage(\"new int[]{-1, -2, 6}\"). Expecting a result of 6.0. The actual result is "
				+ positiveAverage(new int[]{-1, -2, 6}) + ".");
		
		System.out.println("Checking frequencyCount({1, 2, 2, 3, 3, 3, 4, 4, 4, 4}). Expecting a result of [1, 2, 3, 4, 0, 0, 0, 0, 0, 0]. "
		 		+ "The actual result is " + Arrays.toString(frequencyCount(new int []{1, 2, 2, 3, 3, 3, 4, 4, 4, 4})) + ".");
		System.out.println("Checking frequencyCount({ 5, 3, 4, 6, 5, 5, 4, 3, 10, 2 }). Expecting a result of [0, 1, 2, 2, 3, 1, 0, 0, 0, 1]. "
		 		+ "The actual result is " + Arrays.toString(frequencyCount(new int []{ 5, 3, 4, 6, 5, 5, 4, 3, 10, 2 })) + ".");
		System.out.println("Checking frequencyCount({ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }). Expecting a result of [10, 0, 0, 0, 0, 0, 0, 0, 0, 0]. "
		 		+ "The actual result is " + Arrays.toString(frequencyCount(new int []{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 })) + ".");
		System.out.println("Checking frequencyCount({ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }). Expecting a result of [0, 0, 0, 0, 0, 0, 0, 0, 0, 10]. "
		 		+ "The actual result is " + Arrays.toString(frequencyCount(new int []{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 })) + ".");
		




	}

}
