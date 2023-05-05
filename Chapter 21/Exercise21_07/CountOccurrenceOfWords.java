/**
 * @author Jason Beach
 * Date: May 3, 2023
 * CSCI 1116: Algorithms and Data Structures
 * Exercise 21-7: (Revise Listing 21.9) Rewrite Listing 21.9 with the map variable as a HashMap. 
 * The program should display the words in ascending order of occurrence counts.
 * */
import java.util.*;

public class CountOccurrenceOfWords {
	public static void main(String[] args) {
		
		// Set text in a string
		String text = "Good morning. Have a good class. " +
				"have a good visit. Have fun!";
		
		// Create a HashMap to hold words as key and count as value
		HashMap<String, Integer> map = new HashMap<>();
		
		String[] words = text.split("[\\s+\\p{P}]");
		
		for(int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();
			
			if(key.length() > 0) {
				if(!map.containsKey(key)) {
					map.put(key,  1);
				}
				else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}
		
		// Create an ArrayList of WordOccurence objects
		List<WordOccurrence> wordList = new ArrayList<>();
		
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			WordOccurrence WO = new WordOccurrence(entry.getKey(), entry.getValue());
			wordList.add(WO);
		}
		
		// Sort the ArrayList by occurrence count using the Collections.sort method
		Collections.sort(wordList);
		
		// Display each word and its occurrence count in ascending order
		for (WordOccurrence WO : wordList) {
			System.out.println(WO.getWord() + "\t" + WO.getCount());
		}
	}
}

/** WordOccurrence Class
 * Implements Comparable. Contains two fields, "word" and "count". The CompareTo method compares the counts*/
class WordOccurrence implements Comparable<WordOccurrence>{
	private String word;
	private int count;
	
	public WordOccurrence(String word, int count) {
		this.word = word;
		this.count = count;
	}
	
	public String getWord() {
		return word;
	}
	
	public int getCount() {
		return count;
	}
	
	@Override
	public int compareTo(WordOccurrence WO) {
		return Integer.compare(this.count, WO.getCount());
	}
}
