import java.io.Serializable;

public class DoubleListNode<T> implements Serializable {
	/**
	 * Instance Variables
	 */
	private T value; //Holds the value of the node ,Type T
	private DoubleListNode<T> next; //the node which comes after this node
	private DoubleListNode<T> previous; //the node that comes before this node

	/**
	 * Constructor method. value and next are instantiated to null
	 */
	public DoubleListNode() {
		value = null;
		next = null;
		previous = null;
	}
	/**
	 * Over loaded constructor. Instantiates value for value and next
	 * @param initValue- the initial value of the node
	 * @param initNext - the node which comes after this one
	 * @param initPrevious- the node which comes before this one
	 */
	public DoubleListNode(T initValue, DoubleListNode<T> initNext, DoubleListNode<T> initPrevious) {
		value = initValue;
		next = initNext;
		previous = initPrevious;
	}
	/**
	 * This method gets the value of the node
	 * @return- the T value of the node
	 */
	public T getValue() {
		return value;
	}
	/**
	 * THis method returns the node which comes after this one
	 * @return- the next ListNode
	 */
	public DoubleListNode<T> getNext() {
		return next;
	}
	/**
	 * THis method returns the node which comes before this one
	 * @return- the previous ListNode
	 */
	public DoubleListNode<T> getPrevious() {
		return previous;
	}
	/**
	 * This method sets the value of the node
	 * @param newValue- the new T value for the node
	 */
	public void setValue(T newValue) {
		value = newValue;
	}
	/**
	 * This method sets the next ListNode
	 * @param newNext - the next ListNode
	 */
	public void setNext(DoubleListNode<T> newNext) {
		next = newNext;
	}
	/**
	 * This method sets the previous ListNode
	 * @param newNext - the previous ListNode
	 */
	public void setPrevious(DoubleListNode<T> newPrevious) {
		previous = newPrevious;
	}
}
