public abstract class MyAbstractList<E> implements MyList<E>{
	protected int size = 0; // The size of the list
	
	/** Create a default list */
	protected MyAbstractList() {
	}
	
	/** Create a list from an array of objects */
	protected MyAbstractList(E[] objects) {
		for (int i = 0; i < objects.length; i ++)
			add(objects[i]);
	}
	
	@Override /** Add a new element at the end of this list */
	public void add(E e) {
		add(size, e);
	}
	
	@Override /** Return true if this list doesn't contain any elements */
	public boolean isEmpty() {
		if (size == 0) return true;
		else return false;
	}
	
	@Override /** Return the number of elements in this list */
	public int size() {
		return size;
	}
	
	@Override /** Remove the first occurrence of the element e
	 * from this list. Shift any subsequent elements to the left.
	 * Return true if the element is removed. */
	public boolean remove(E e) {
		if(indexOf(e) >= 0) {
			remove(indexOf(e));
			return true;
		}
		else return false;
	}
	
	
	//METHODS IMPLEMENTED FOR EXERCISE24_1
	
	@Override /** Adds the elements in otherList to this list.
	 *  Returns true if this list changed as a result of the call */
	public boolean addAll(MyList<E> otherList) {
		int originalSize = size;
		
		for (int i = 0; i < otherList.size(); i++) {
			add(otherList.get(i));
		}
		return size != originalSize;
	}
		
	@Override /** Removes all the elements in otherList from this list 
	 *  Returns true if this list changed as a result of the call */
	public boolean removeAll(MyList<E> otherList) {
		int originalSize = size;
		
		for (int i = 0; i < otherList.size(); i++) {
			
			while(contains(otherList.get(i))) {
				remove(otherList.get(i));
			}
		}
		return size != originalSize;
	}
		
	@Override /** Retains the elements in this list that are also in otherList
	 *  Returns true if this list changed as a result of the call */
	public boolean retainAll(MyList<E> otherList) {
		int originalSize = size;
		
		MyList<E> newList = new MyArrayList<>();
		
		for(int i = 0; i < size(); i++) {
			if(otherList.contains(get(i))) {
				newList.add(get(i));
			}
		}
		clear();
		addAll(newList);
		
		return size != originalSize;
	}
}