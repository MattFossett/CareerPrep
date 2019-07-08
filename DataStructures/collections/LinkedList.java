package collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Doubly LinkedList data structure implementation
 * @MattFossett
 * Complexity Analysis:
 *   searching/indexing: O(N)
 *   inserting: O(1)
 *   removing:  O(1)
 */
public class LinkedList<E> implements Iterable<E>, Cloneable {
	private ListNode<E> header;
	private int size;
	
	/**
	 * Default Constructor: Makes LinkedList with 0 elements
	 */
	public LinkedList(){
		header = new ListNode<E>();
		this.header.next = header;
		this.header.prev = header;
		size = 0;
	}
	
	/**
	 * Adds element data to the end of the list
	 * @param data
	 */
	public void add( E data ){
		ListNode<E> temp = new ListNode<E>(data, header, header.prev);
		temp.prev.next = temp;
		header.prev = temp;
		size++;
	}
	
	/**
	 * adds element data to specified index
	 * @throws IndexOutOfBoundsException
	 * @param index
	 * @param data
	 */
	public void add( int index, E data){
		ListNode<E> found = getNode(index);
		ListNode<E> newNode = new ListNode<E>(data, found, found.prev);
		newNode.next.prev = newNode;
		newNode.prev.next = newNode;
		size++;
	}
	
	/**
	 * Adds iterable collection to end of this LinkedList
	 * @param c
	 * @return
	 */
	public boolean addAll(Collection<? extends E> c){
		for(E i : c)
			add(i);
		return true;
	}
	
	/**
	 * Adds iterable collection starting at index 
	 * @param index
	 * @param c 
	 * @return true if success
	 */
	public boolean addAll(int index, Collection<? extends E> c){
		for(E i : c){
			add(index, i);
			index++;
		}
		return true;
	}
	
	/**
	 * gets value of element at front of list
	 * @return data at first list element
	 * @throws NoSuchElementException if empty list
	 */
	public E front(){
		if (size <= 0){
			throw new NoSuchElementException("List is empty");
		}
		return header.next.data;
	}

	/**
	 * gets value of element at back of list
	 * @return data at last list element
	 * @throws NoSuchElementException if empty list
	 */
	public E back(){
		if (size <= 0){
			throw new NoSuchElementException("List is empty");
		}
		return header.prev.data;
	}


	/**
	 * Add element to beginning of list
	 * @param data
	 */
	public void addFirst(E data){
		add(0, data);
	}
	
	/**
	 * Add element to end of List
	 * @param data
	 */
	public void addLast(E data){
		add(data);
	}
	
	/**
	 * Removes all elements from LinkedList
	 */
	public void clear(){
		header.next = header;
		header.prev = header;
		size = 0;
	}
	
	/**
	 * Current number of elements in list
	 * @return
	 */
	public int size(){
		return size;
	}
	
	/**
	 * Returns shallow copy of LinkedList object
	 */
	public Object clone(){
		LinkedList<E> clone = new LinkedList<E>();
		for (E i : this){
			clone.add(i);
		}
		return clone;
	}
	
	/**
	 * Finds node at specified index
	 * @param index
	 * @return
	 */
	private ListNode<E> getNode(int index){
		if (index < 0 || index > size){
			throw new IndexOutOfBoundsException();
		}
		ListNode<E> temp = header.next;
		for (; index > 0; index--){
			temp = temp.next;
		}
		return temp;
	}
	
	/**
	 * Get data located at index
	 * @param index
	 * @return data
	 */
	public E get(int index){
		return getNode(index).data;
	}
	
	/**
	 * change a nodes element at specified index
	 * @param index
	 * @param element
	 * @return element
	 */
	public E set(int index, E element){
		ListNode<E> temp = getNode(index);
		temp.data = element;
		return temp.data;
	}
	
	/**
	 * Remove the node stored at index
	 * @param index
	 * @return data from that node
	 */
	public E remove(int index){
		ListNode<E> temp = getNode(index);
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		temp.next = null;
		temp.prev = null;
		size--;
		return temp.data;
	}
	/**
	 * Removes the first element in the list
	 * @return
	 */
	public E remove(){
		return remove(0);
	}
	/**
	 * Finds object matching o and removes. 
	 * @param o
	 * @return true if objects exists else false
	 */
	public boolean remove (Object o){
		ListNode<E> temp = header;
		for (int i=0; i<size; i++){
			temp = temp.next;
			if (temp.data == o){
				remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * Removes last element in list
	 * @throws NoSuchElementException if list is empty
	 * @return data in removed node
	 */
	public E removeBack(){
		if (size <= 0){
			throw new NoSuchElementException("List is empty");
		}
		ListNode<E> temp = header.prev;
		header.prev = temp.prev;
		temp.prev.next = header;
		temp.next = null;
		temp.prev = null;
		size--;
		return temp.data;
	}
	
	/**
	 * get dummy header located before first element and after last element
	 * @return
	 */
	public ListNode<E> getHead(){
		return header;
	}
	
	public String toString(){
		StringBuilder values = new StringBuilder();
		if (this.size()==0){
			return "{ }";
		}
		values.append("{ ");
		for (E i : this){
			values.append(i + ", ");
		}

		values.delete(values.length()-2, values.length());
		values.append(" }");
		return values.toString();
	}
	
	@Override
	public Iterator<E> iterator() {
		ListIterator<E> it = new ListIterator<E>(this);
		return it;
	}
}

/**
 * This is the implementation for the custom list iterator.
 */
class ListIterator<E> implements Iterator<E> {
	ListNode<E> current;
	ListNode<E> header;
	
	/**
	 * Start iterator at index 0
	 *   if list empty then iterator is at end (header)
	 */
	public ListIterator(LinkedList<E> list){
		current = list.getHead();
		header = current;	
	}

	@Override
	public boolean hasNext() {
		if (current==null){
			return false;
		}
		return current.next != null && current.next != header;
	}
    
	public boolean hasPrevious(){
		if (current==null){
			return false;
		}
		return current.prev != null && current.prev != header;
	}

	@Override
	public E next() {
		if (!hasNext()){
			throw new NoSuchElementException();
		}
		current = current.next;
		return current.data;
	}

	public E previous(){
		if (!hasPrevious()){
			throw new NoSuchElementException();
		}
		current = current.prev;
		return current.data;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString(){
		return current.data + "";
	}
}

/**
 * Implementation of a node for Doubly LinkedList.
 */
class ListNode<E> {
	E data;
	ListNode<E> next;
	ListNode<E> prev;
	
	public ListNode(){
		next = this;
		prev = this;
	}
	
	public ListNode(E d, ListNode<E> n, ListNode<E> p){
		data = d;
		prev = p;
		next = n;	
	}
	
	public ListNode(E d){
		data = d;
		next = this;
		prev = this;
	}
	
}