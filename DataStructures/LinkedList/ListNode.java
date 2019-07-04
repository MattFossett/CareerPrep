/**
 * Implementation of a node for LinkedList.
 * Note: This code is in its own file for simple code reuse 
 *   when making future data structures that use nodes.
 */
public class ListNode<E> {
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
