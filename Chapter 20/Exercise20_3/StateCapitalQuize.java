/**
 * @author Jason Beach
 * Date: April 19, 2023
 * CSCI 1116: Algorithms and Data Structures
 * This program is an example of a US States/Capitals quiz. The bulk of the code was provided. As per the assingment instrucitons,
 * I have modified the code to ask the user the capitals of states in a random order.
 * */

import java.util.*;

public class StateCapitalQuiz {
  public static void main(String[] args) {
	  
	  // Create matrix to hold States and Capitals
    String[][] stateCapital = {
      {"Alabama", "Montgomery"},
      {"Alaska", "Juneau"},
      {"Arizona", "Phoenix"},
      {"Arkansas", "Little Rock"},
      {"California", "Sacramento"},
      {"Colorado", "Denver"},
      {"Connecticut", "Hartford"},
      {"Delaware", "Dover"},
      {"Florida", "Tallahassee"},
      {"Georgia", "Atlanta"},
      {"Hawaii", "Honolulu"},
      {"Idaho", "Boise"},
      {"Illinois", "Springfield"},
      {"Indiana", "Indianapolis"},
      {"Iowa", "Des Moines"},
      {"Kansas", "Topeka"},
      {"Kentucky", "Frankfort"},
      {"Louisiana", "Baton Rouge"},
      {"Maine", "Augusta"},
      {"Maryland", "Annapolis"},
      {"Massachusettes", "Boston"},
      {"Michigan", "Lansing"},
      {"Minnesota", "Saint Paul"},
      {"Mississippi", "Jackson"},
      {"Missouri", "Jefferson City"},
      {"Montana", "Helena"},
      {"Nebraska", "Lincoln"},
      {"Nevada", "Carson City"},
      {"New Hampshire", "Concord"},
      {"New Jersey", "Trenton"},
      {"New York", "Albany"},
      {"New Mexico", "Santa Fe"},
      {"North Carolina", "Raleigh"},
      {"North Dakota", "Bismarck"},
      {"Ohio", "Columbus"},
      {"Oklahoma", "Oklahoma City"},
      {"Oregon", "Salem"},
      {"Pennsylvania", "Harrisburg"},
      {"Rhode Island", "Providence"},
      {"South Carolina", "Columbia"},
      {"South Dakota", "Pierre"},
      {"Tennessee", "Nashville"},
      {"Texas", "Austin"},
      {"Utah", "Salt Lake City"},
      {"Vermont", "Montpelier"},
      {"Virginia", "Richmond"},
      {"Washington", "Olympia"},
      {"West Virginia", "Charleston"},
      {"Wisconsin", "Madison"},
      {"Wyoming", "Cheyenne"}
    };

    // Create Scanner
    Scanner input = new Scanner(System.in);
    
    int correctCount = 0;

    // Create random number
	Random random = new Random();
	int randomNumber;
	
	// Iterate through array and prompt user to answer question (Code modified for assignment to randomize prompt to user)
    for (int i = 0; i < stateCapital.length; i++) {
    
    	randomNumber = random.nextInt(50);
    	
      // Prompt the user with a question
      System.out.print("What is the capital of " + stateCapital[randomNumber][0] + "? ");
      String capital = input.nextLine().trim().toLowerCase();
      
      if (capital.toLowerCase().equals(stateCapital[randomNumber][1].toLowerCase())) {
        System.out.println("Your answer is correct");
        correctCount++;
      }
      else
        System.out.println("The correct answer should be " + stateCapital[randomNumber][1]);
    }

    System.out.println("The correct count is " + correctCount);
  }
}
