/*
 * Author: Jason Beach
 * Date: May 1, 2023
 * CSCI 1116: Algorithms and Data Structures
 * Exercise 24 - 3: This program is an example of an implementation of a doubly linked list.
 **/
class Exercise24_03 {
	public static void main(String[] args) {
		TwoWayLinkedList<Integer> list = new TwoWayLinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);

		java.util.ListIterator<Integer> iterator = list.iterator();
		iterator.next();
		iterator.next();
		iterator.next();

		// System.out.print(iterator.next() + " ");

		System.out.println();
		while (iterator.hasPrevious())
		  System.out.print(iterator.previous() + " ");
	}
}