/**
 * @author Jason
 * @Date 05/09/2023
 * CSCI 1116: Algorithms and Data Structures
 * Exercise 22_03
 * Write a program that prompts the user to enter two strings and tests whether the second string 
 * is a substring of the first string. Suppose the neighboring characters in the string are distinct.  
 * (Don’t use the indexOf method in the String class.) Analyze the time complexity of your algorithm. 
 * Your algorithm needs to be at least O(n) time.
 * THIS PROGRAM HAS A TIME COMPLEXITY OF O(n).
 * */

import java.util.Scanner;

public class PatternMatching {
	public static void main(String[] args) {
		
        Scanner input = new Scanner(System.in);
        
        // Prompt user to input 2 strings
        System.out.print("Enter string 1: ");
        String s1 = input.nextLine();
        System.out.print("Enter string 2: ");
        String s2 = input.nextLine();

        // Initialize index to -1 to indicate no match found
        int index = -1;
        
        // Loop through s1 from index 0 to s1.length() - s2.length()
        for (int i = 0; i <= s1.length() - s2.length(); i++) {
            boolean match = true;
            
            // Loop through s2 to compare each character with s1 starting from i
            for (int j = 0; j < s2.length(); j++) {
            	
                // If characters don't match, set match to false and break out of loop
                if (s1.charAt(i + j) != s2.charAt(j)) {
                    match = false;
                    break;
                }
            }
            
            // If match is true, set index to i and break out of loop
            if (match) {
                index = i;
                break;
            }
        }

        // Print out result based on whether index was found or not
        if (index == -1) {
            System.out.println(s2 + " is not a substring of " + s1);
        } 
        else {
            System.out.println("The match starts at index " + index);
        }
    }
}