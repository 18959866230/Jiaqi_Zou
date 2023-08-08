package assign06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents a book (read from file), specifically all words in a book.
 * The instance methods provide various book stats, such as number of words.
 * 
 * Note that a word is considered to be any sequence of symbols separated by whitespace. 
 * For example, a book file containing "Hello, world." has two words: "Hello," and "world."
 *
 * @author Prof. Martin and ?
 * @version ?
 */
public class Book {

	// DO NOT ADD OR REMOVE ANY INSTANCE VARIABLES
	private DynamicArray words;
	private int characterCount;
	private String shortestWord;
	private String longestWord;

	/**
	 * Creates a Book object, given a filename for the book file to read.
	 * If no file with the given name exists, creates an empty book.
	 * 
	 * @param filename - the name of the file containing the book
	 * 
	 * DO NOT MODIFY THIS METHOD
	 */
	public Book(String filename) {
		words = new DynamicArray();
		
		// This try-with-resources block automatically closes the Scanner when the try block 
		// finishes or if an exception is handled.  
		// Notice the omission of an explicit call to close.
		try(Scanner fileInput = new Scanner(new File(filename))) {  
			while(fileInput.hasNext())
				words.append(fileInput.next());				
		}
		catch(FileNotFoundException e) {
			// Do nothing -- words dynamic array contains 0 elements.
		}
		
		// Initialize to "dummy" values to indicate that this internal data has not yet 
		// been collected.
		characterCount = -1;
		shortestWord = null;
		longestWord = null;
	}
	
	public int getWordCount() {
		// Fill in and add Javadoc.
		return words.size();  // Replace 0 with the appropriate expression.
	}
			
	/**
	 * Gets the number of characters in this book.
	 * 
	 * @return the number of characters in this book
	 */
	public int getCharacterCount() {		
		// If the characters have not yet been counted, collect and save as internal data.
		// This calculation is done only once, the first time this method is called.
		if(characterCount == -1) {
			characterCount = 0;
			for(int index = 0; index < words.size(); index++)
				characterCount += words.getElement(index).length();
		}
		
		// When this method is called for a second (or a third or ...) time, skip the calculation.
		return characterCount;
	}
		
	public double getAverageWordLength() { 
		// Fill in and add Javadoc. 
		// No need to handle divide by 0, simply let it happen.
		return (double)getCharacterCount()/words.size();  // Replace 0 with the appropriate expression.
	}
	
	public String getShortestWord() {
		// Fill in and add Javadoc.
		
		// Using getCharacterCount as a guide, do the work of finding the shortest word 
		// only the first time this method is called.
		
		// In the event of a tie for the shortest word, use the shortest word that occurs 
		// first in the book.
		
		// If there are no words in the book, return null.
		if (words.size() == 0) {
	        return null;
	    }
	    
	    // Using getCharacterCount as a guide, do the work of finding the longest word 
	    // only the first time this method is called.
	    if (shortestWord == null) {
	    	shortestWord = words.getElement(0);
	        for (int i = 0; i < words.size(); i++) {
	            String word = words.getElement(i);
	            if (word.length() < shortestWord.length()) {
	            	shortestWord = word;
	            }
	        }
	    }

	    return shortestWord;
	} // Replace null with the appropriate expression.
	
	public String getLongestWord() {
		
		// Fill in and add Javadoc.
		
		// Using getCharacterCount as a guide, do the work of finding the longest word 
		// only the first time this method is called.
		
		// In the event of a tie for the longest word, use the longest word that occurs 
		// first in the book.

		// If there are no words in the book, return null.
		if (words.size() == 0) {
	        return null;
	    }
	    
	    // Using getCharacterCount as a guide, do the work of finding the longest word 
	    // only the first time this method is called.
	    if (longestWord == null) {
	        longestWord = words.getElement(0);
	        for (int i = 0; i < words.size(); i++) {
	            String word = words.getElement(i);
	            if (word.length() > longestWord.length()) {
	                longestWord = word;
	            }
	        }
	    }

	    return longestWord;
	}  // Replace null with the appropriate expression.
	
	public int getTargetWordCount(String targetWord) {
		// Fill in and add Javadoc.
		int count = 0; 
		for(int i = 0; i < words.size(); i++) {
			if(words.getElement(i).equals(targetWord)) {
				count ++;
			}
		}
		
		return count;  // Replace 0 with the appropriate expression.
	}
	
	/**
	 * Determines the word that would come immediately before the given target word if 
	 * all the distinct words in this book were arranged in lexicographic order. 
	 * If there is no such word, returns the target word.
	 * 
	 * Note: This method does not actually put the words into lexicographic order.
	 * 
	 * @param targetWord - the given target word
	 * @return the word that comes immediately before the target word, lexicographically
	 */
	public String getWordLexicographicallyBefore(String targetWord) {
		// Fill in with code you wrote in Lab 7.
		 if (targetWord == null || targetWord.isEmpty()) {
		        return null;
		    }
		String previousWord = null;
		for(int i = 0; i< words.size(); i++) {
			String word = words.getElement(i);
			if(word.compareTo(targetWord) < 0) {
				if(previousWord == null) {
					previousWord = word;
				}else {
					int comparisonResult = word.compareTo(previousWord);
					if(comparisonResult > 0) {
						previousWord = word;
					}
				}
			}
		}
		return previousWord;
	}
		  // Replace null with the appropriate expression.
	
	public String getWordLexicographicallyAfter(String targetWord) {
		// Fill in and add Javadoc. Use getWordLexicographicallyBefore as a guide.
		// Replace null with the appropriate expression.	
		 if (targetWord == null) {
		        return null;
		    }
		String nextWord = null;
		for(int i = 0; i< words.size(); i++) {
			String word = words.getElement(i);
			if(word.compareTo(targetWord) > 0) {
				if(nextWord == null) {
					nextWord = word;
				}else {
					int comparisonResult = word.compareTo(nextWord);
					if(comparisonResult < 0) {
						nextWord = word;
					}
				}
			}
		
		}
		return nextWord;
	}

	/**
	 * Writes the words of this book to file, in reverse order.
	 * 
	 * @param filename - the name of the file to write
	 */
	public void saveReversedBook(String filename) { 
		// This try-with-resources block automatically closes the FileWriter when the try block 
		// finishes or if an exception is handled.  
		try(FileWriter fileOutput = new FileWriter(filename)) {
			// Fill in. Separate each word with one blank space, regardless of the whitespace 
			// used to separate words in the original book file.
	        for (int i = words.size()-1; i >= 1; i--) {
	            fileOutput.write(words.getElement(i) + " "); 
	        }
	        fileOutput.write(words.getElement(0));
			// fileOutput.write(...); works same as System.out.println

		}
		catch(IOException e) {
			// Do nothing.
		}
	}
}