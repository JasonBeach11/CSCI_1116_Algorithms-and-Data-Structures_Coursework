/**
 * @author Jason Beach
 * Date: 4/26/2023 
 * CSCI 1116: Exercise 24_01
 * */
public class Exercise24_01 {

	public static void main(String[] args) {
		
		// Create list1
		MyList<String> list1 = new MyArrayList<String>();
		list1.add("Tom");
		list1.add("George");
		list1.add("Peter");
		list1.add("Jean");
		list1.add("Jane");
		
		// Create list2
		MyList<String> list2 = new MyArrayList<String>();
		list2.add("Tom");
		list2.add("George");
		list2.add("Michael");
		list2.add("Michelle");
		list2.add("Daniel");
		
		System.out.println("List1 contains: " + list1);
		System.out.println("List2 contains: " + list2);
		
		
		// AS PER THE ASSIGNEMENT, PERFORM THE FOLLOWING OPERATIONS:
		
		// PART 1: Invokes list1.addAll(list2), and displays list1 and list2.
		System.out.println("\nPart 1 of exercise...");
		System.out.println("Invoking list1.addAll(list2)...");
		list1.addAll(list2);
		System.out.println("List1 contains: " + list1);
		System.out.println("List2 contains: " + list2);
		
		// PART 2: Recreates list1 and list2 with the same initial values, invokes list1.removeAll(list2), and displays list1 and list2.
		// First empty the lists and recreate them with their initial values
		System.out.println("\nPart 2 of exercise...");
		System.out.println("Lists recreated with initial values.");
		list1.clear();
		list1.add("Tom");
		list1.add("George");
		list1.add("Peter");
		list1.add("Jean");
		list1.add("Jane");
		
		list2.clear();
		list2.add("Tom");
		list2.add("George");
		list2.add("Michael");
		list2.add("Michelle");
		list2.add("Daniel");
		
		System.out.println("List1 contains: " + list1);
		System.out.println("List2 contains: " + list2);
		
		System.out.println("Invoking list1.removeAll(list2)...");
		list1.removeAll(list2);
		System.out.println("List1 contains: " + list1);
		System.out.println("List2 contains: " + list2);
		
		// PART 3: Recreates list1 and list2 with the same initial values, invokes list1.retainAll(list2), and displays list1 and list2.
		System.out.println("\nPart 3 of exercise...");
		System.out.println("Lists recreated with initial values.");
		list1.clear();
		list1.add("Tom");
		list1.add("George");
		list1.add("Peter");
		list1.add("Jean");
		list1.add("Jane");
		
		list2.clear();
		list2.add("Tom");
		list2.add("George");
		list2.add("Michael");
		list2.add("Michelle");
		list2.add("Daniel");
		
		System.out.println("List1 contains: " + list1);
		System.out.println("List2 contains: " + list2);
		
		System.out.println("Invoking list1.retainAll(list2)...");
		list1.retainAll(list2);
		System.out.println("List1 contains: " + list1);
		System.out.println("List2 contains: " + list2);
	}
}