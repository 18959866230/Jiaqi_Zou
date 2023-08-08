// CS 1410 Assignment 1: Generating biographies by Jiaqi Zou (January 15, 2023).

package assign01;

public class BiographyGenerator {

	// This method is mainly used as a calculator to calculate the difference 
	// between the current year and the past year. It will return a number as an result. 
	
	public static int calculateYearDifference(int currentYear, int pastYear) {
		int yearDifference = 0;
		yearDifference = currentYear-pastYear;
		return yearDifference;
	}
	
	// This method is mainly designed for create a sentence that it can inform user to know 
	// famous scientists' biography, includes name, birth year, famous achievement. It will
	// return an sentence having these informations. 
	public static String biographyMaker(String name, int currentYear, int birthYear, String famousAchievement) {
		
		String sentence = "";	
		sentence = name + " was born " + 
				calculateYearDifference(currentYear, birthYear)+ " years ago. "
				+ name + " is famous for "+ famousAchievement + ".";
		return sentence;
	}


	public static void main(String[] args) {
		// https://thebestschools.org/magazine/most-influential-computer-scientists/Links to an external site.
		System.out.println(biographyMaker("Leonard M. Adleman", 2023, 1945, "Contribution to the RSA algorithm, which was one of the first public key cryptosystems"));	
		
		//https://thebestschools.org/magazine/most-influential-computer-scientists/Links to an external site.
		System.out.println(biographyMaker("Frances E. Allen", 2023, 1932, "Provides the conceptual basis for systematic evaluation and improvement of computer programs, with innovative use of graph theory to encode program content"));
	}

}
