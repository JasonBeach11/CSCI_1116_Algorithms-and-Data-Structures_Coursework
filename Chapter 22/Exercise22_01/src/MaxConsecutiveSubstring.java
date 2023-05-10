/**
 * @author Jason
 * @Date 05/09/2023
 * 
 * CSCI 1116: Algorithms and Data Structures
 * Exercise 22_01: (Maximum consecutive increasingly ordered substring) 
 * Write a program that prompts the user to enter a string and displays the maximum consecutive 
 * increasingly ordered substring. Analyze the time complexity of your program.
 * THE TIME COMPLEXITY OF THIS PROGRAM IS O(n).
 * */

import java.util.Scanner;

public class MaxConsecutiveSubstring {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// Prompt use to input a string
		System.out.print("Enter a string: ");
		String str = scanner.nextLine();
		
		// Initialize variables for the maximum and current substrings
		String maxSubstring = "";
		String currentSubstring = "";
		
		// Loop over each character in the string
		for (int i = 0; i < str.length() -1; i++) {
			// Get the current character and the next character in the string
			char currentChar = str.charAt(i);
			char nextChar = str.charAt(i + 1);
			
			// If the next character is greater than the current character, add the current character to the current substring
			if(nextChar > currentChar) {
				currentSubstring += currentChar;
			}
			
			// Else add the current character to the current substring, check if it is longer than the maximum
			// substring found so far and reset the current substring
			else {
				currentSubstring += currentChar;
				if(currentSubstring.length() > maxSubstring.length()) {
					maxSubstring = currentSubstring;
				}
				currentSubstring = "";
			}
		}
		
		// Add the last character to the current substring and check if it is larger than the maximum substring found so far
		currentSubstring += str.charAt(str.length()-1);
		
			if(currentSubstring.length() > maxSubstring.length()) {
				maxSubstring = currentSubstring;
			}
			
			// Output maximum consecutive substring to console
			System.out.println("Maximum consecutive substring: " + maxSubstring);
	}
}