/**
 * @author Jason Beach
 * Date: May 2, 2023
 * CSCI 1116: Algorithms and Data Structures
 * Exercise 24_5 Create a new GenericQueue class that uses inheritance. Create a test method that uses 
 * both the enqueue and dequeue methods and prints how the queue is affected
 * */
import java.util.LinkedList;

public class GenericQueue<E> extends LinkedList<E>{		// Create GenericQueue class that inherits LinkedList

	public static void main(String[] args) {
		
		GenericQueue<String> queue = new GenericQueue<>();		// Create GenericQueue object, queue
		
		// enqueue elements into the queue
		queue.enqueue("FIRST");
		queue.enqueue("SECOND");
		queue.enqueue("THIRD");
		queue.enqueue("FORTH");
		queue.enqueue("FIFTH");
		
		// Check how the queue is affected
		System.out.println("Queue after enqueing elements: " + queue);
		
		// Dequeue elements from the queue
		String firstElement = queue.dequeue();
		String secondElement = queue.dequeue();
		
		// Check how the queue is affected
		System.out.println("Dequeued elements: " + firstElement + " and " + secondElement);
		System.out.println("Queue after dequeueing elements: " + queue);
	}
	
	/** Add element to the queue by using addLast(), inherited from LinkedList */
	public void enqueue(E element) {
		this.addLast(element);
	}
	
	/** Remove element from queue by using removeFirst(), inherited from LinkedList */
	public E dequeue() {
		return this.removeFirst();
	}

}
