package assign06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class contains tests for the Book class. 
 * 
 * @author Prof. Parker and ?
 * @version ?
 */
public class BookTest {
	
	private static Book smallBook;
	private static Book largeBook;
	private static Book specialCaseBook;
	
	// This code executes before all tests.
	// You can reference smallBook in your tests without having to create it.
	@BeforeAll
	public static void setup(){
		smallBook = new Book("small_book.txt");
		largeBook = new Book("largeBook.txt");
		specialCaseBook = new Book("specialCaseBook.txt");
	}
	
	

	@Test
	public void testGetWordCount() {
		assertEquals(32, smallBook.getWordCount());
	}
	
	@Test
	public void testGetCharacterCount() {
		assertEquals(137, smallBook.getCharacterCount());
	}

	@Test
	public void testGetAverageWordLength() {
		assertEquals(4.28125, smallBook.getAverageWordLength(), 0.00001);
	}
	
	@Test
	public void testGetShortestWord() {
		assertEquals("a", smallBook.getShortestWord());
	}
	
	@Test
	public void testGetLongestWord() {
		assertEquals("checking", smallBook.getLongestWord());
	}
	
	@Test
	public void testGetTargetWordCount() {
		assertEquals(2, smallBook.getTargetWordCount("do"));
	}
	
	@Test
	public void testGetWordLexicographicallyBefore() {
		assertEquals("Use", smallBook.getWordLexicographicallyBefore("a"));
	}	

	@Test
	public void testGetWordLexicographicallyAfter() {
		assertEquals("the", smallBook.getWordLexicographicallyAfter("testing"));
	}
	
	@Test
	public void testSaveReversedBook() {
		String expected = "files. book large using testing thorough do also to sure be However, class. Book the of checking initial simple, some do to it Use book. small very a of example an This";
		String filename = "reverse_test.txt";
		smallBook.saveReversedBook(filename);
		try {//update to close w/ resources
			Scanner fileInput = new Scanner(new File(filename));
			String actual = fileInput.nextLine();
			assertEquals(expected, actual);
			fileInput.close();
		}
		catch(FileNotFoundException e) {
			fail("File not written or written using incorrect path.");
		}
	}
	
	// Step 1: Add more tests for smallBook that check the edge cases of getTargetWordCount, getWordLexicographicallyBefore, getWordLexicographicallyAfter.
	@Test
	public void testGetTargetWordCount2() {
		assertEquals(1, smallBook.getTargetWordCount("This"));
		assertEquals(0, smallBook.getTargetWordCount("However"));
		assertEquals(0, smallBook.getTargetWordCount(null));
		
	}
	
	@Test
	public void testGetWordLexicographicallyBefore2() {
		assertEquals("Use", smallBook.getWordLexicographicallyBefore("a"));
		
	}
	@Test
    public void testGetWordLexicographicallyBefore_firstWord() {
        String actualResult = smallBook.getWordLexicographicallyBefore("An");
        assertNull(actualResult);
    }
	
	 @Test
	    public void testGetWordLexicographicallyBefore_lastWord() {
	        String actualResult = smallBook.getWordLexicographicallyBefore("zoo");
	        assertEquals("very", actualResult);
	    }
	 
	 @Test
	 public void testGetWordLexicographicallyBefore_nonexistentWord() {
	     String actualResult = smallBook.getWordLexicographicallyBefore("apple");
	     assertEquals("an", actualResult);
	 }
	 
	 @Test
	 public void testGetWordLexicographicallyAfter_nonexistentWord() {
	     String actualResult = smallBook.getWordLexicographicallyAfter("zebra");
	     assertNull(actualResult);
	 }
	 
	 
	// Step 2: Add more tests for another book.
	 
	 @Test
	 public void testGetWordCount_largeBook() {
	     int expectedResult = 102;
	     int actualResult = largeBook.getWordCount();
	     assertEquals(expectedResult, actualResult);
	 }
	 
	 @Test
	 public void testGetTargetWordCount_largeBook() {
	     int expectedResult = 4;
	     int actualResult = largeBook.getTargetWordCount("Lorem");
	     assertEquals(expectedResult, actualResult);
	 }
	 
	 @Test
	 public void testGetWordLexicographicallyBefore_largeBook() {
	     String expectedResult = "Latin";
	     String actualResult = largeBook.getWordLexicographicallyBefore("Lorem");
	     assertEquals(expectedResult, actualResult);
	 }
	 
	 @Test
	 public void testGetWordLexicographicallyBefore_largeBook2() {
	     String expectedResult = "have";
	     String actualResult = largeBook.getWordLexicographicallyBefore("hello");
	     assertEquals(expectedResult, actualResult);
	 }
	 
	 @Test
	 public void testGetWordLexicographicallyAfter_largeBook() {
	     String expectedResult = "The";
	     String actualResult = largeBook.getWordLexicographicallyAfter("Lorem");
	     assertEquals(expectedResult, actualResult);
	 }
	 
	 @Test
	 public void testGetWordLexicographicallyAfter_nonExistingWord_largeBook() {
	     String expectedResult = "how";
	     String actualResult = largeBook.getWordLexicographicallyAfter("hello");
	     assertEquals(expectedResult, actualResult);
	 }
	 
	 
	 @Test
	 public void testGetWordCount2() {
	     assertEquals(2, specialCaseBook.getWordCount());
	 }

	 @Test
	 public void testGetCharacterCount2() {
	     assertEquals(8, specialCaseBook.getCharacterCount());
	 }

	 @Test
	 public void testGetAverageWordLength2() {
	     assertEquals(4.0, specialCaseBook.getAverageWordLength(), 0.00001);
	 }

	 @Test
	 public void testGetShortestWord2() {
	     assertEquals("you", specialCaseBook.getShortestWord());
	 }


	 @Test
	 public void testGetTargetWordCount3() {
	     assertEquals(0, specialCaseBook.getTargetWordCount("hello"));
	 }

	 @Test
	 public void testGetWordLexicographicallyBefore3() {
	     assertNull(specialCaseBook.getWordLexicographicallyBefore("Hello"));
	     assertEquals("Hello", specialCaseBook.getWordLexicographicallyBefore("Jello"));
	 }
	 
	 @Test
		public void testSaveReversedBook3() {
			String expected = "you Hello";
			String filename = "specialCaseBook.txt";
			specialCaseBook.saveReversedBook(filename);
			try {//update to close w/ resources
				Scanner fileInput = new Scanner(new File(filename));
				String actual = fileInput.nextLine();
				assertEquals(expected, actual);
				fileInput.close();
			}
			catch(FileNotFoundException e) {
				fail("File not written or written using incorrect path.");
			}

}
}


	
	// Step 3: Create an "edge case" book file and test.


	