/**
 * @author Jason Beach
 * Date: April 20, 2023
 * CSCI 1116: Exercise 20_21
 * This program uses a comparator to sort a generic list of objects. The bulk of the code was provided. As per the assignment,
 * I have added the code for the selectionSort method and sorted the GeometricObject list and the Circle list. Both lists are
 * sorted and the values are output to the console.
 * 
 * */
import java.util.Comparator;

public class Exercise20_21 {
  public static void main(String[] args) {
	  
    GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
        new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5), 
        new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
        new Circle(6.5), new Rectangle(4, 5)};

    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
      new Circle(5), new Circle(6), new Circle(1), new Circle(2),
      new Circle(3), new Circle(14), new Circle(12)};
    
    
    System.out.println("List of sorted Geometric Objects:");
    selectionSort(list, new GeometricObjectComparator());
    
    for (int i = 0; i < list.length; i++)
      System.out.println(list[i].getArea() + " ");
    
    
    System.out.println("\nList of sorted Circle Objects:");
    selectionSort(list1, new GeometricObjectComparator());
    
    for (int i = 0; i < list1.length; i++)
      System.out.println(list1[i].getArea() + " ");
    
  }
  
  public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {
	  
	    for (int i = 0; i < list.length - 1; i++) {
	        int minIndex = i;
	        for (int j = i + 1; j < list.length; j++) {
	            if (comparator.compare(list[j], list[minIndex]) < 0) {
	                minIndex = j;
	            }
	        }
	        if (minIndex != i) {
	            E temp = list[i];
	            list[i] = list[minIndex];
	            list[minIndex] = temp;
	        }
	    }
	}

}