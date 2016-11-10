import java.io.Serializable;

public class DoubleLinkedList<T extends Comparable<T>> implements Serializable {

	// Instance Variables
	private DoubleListNode<T> head; // Holds reference to first node
	private DoubleListNode<T> currentNode;// Holds reference to the current node

	/**
	 * Constructor method, instantiates all instance variables to null
	 */
	public DoubleLinkedList() {
		head = null;
		currentNode = null;
	}

	/**
	 * This method adds an element to the linked list in alphabetical or in
	 * order of GPA
	 * @param element- the new element to add to the list
	 */
	public void add(T element) {
		DoubleListNode<T> tempNode = head;

		if (head == null || (element).compareTo(head.getValue()) < 0) {
			DoubleListNode<T> newNode = new DoubleListNode<T>(element, head, null);
			if (head != null)
				head.setPrevious(newNode);
			head = newNode;
			currentNode = newNode;

		} else {

			while (tempNode.getNext() != null) {
				tempNode = tempNode.getNext();
				if ((element).compareTo(tempNode.getValue()) < 0) {
					DoubleListNode<T> newNode = new DoubleListNode<T>(element, tempNode, tempNode.getPrevious());
					tempNode.getPrevious().setNext(newNode);
					tempNode.setPrevious(newNode);
					currentNode = newNode;
				}
			}
			if ((element).compareTo(tempNode.getValue()) >= 0) {
				DoubleListNode<T> newNode = new DoubleListNode<T>(element, null, tempNode);
				tempNode.setNext(newNode);
				currentNode = newNode;
			}
		}
	}

	/**
	 * This method deletes the currentNode from the list.
	 */
	public void delete() {

		if (currentNode.getPrevious() != null) {
			currentNode.getPrevious().setNext(currentNode.getNext());
			if (currentNode.getNext() != null)
				currentNode.getNext().setPrevious(currentNode.getPrevious());
			currentNode = currentNode.getPrevious();
		} else if (currentNode.getNext() != null) {
			head = currentNode.getNext();
			head.setPrevious(null);
			currentNode = head;
		} else {
			head = null;
		}
	}

	/**
	 * This method moves the currentNode onto the next node if there is one
	 */
	public void doNext() {
		if (currentNode.getNext() != null)
			currentNode = currentNode.getNext();
	}

	/**
	 * This method gets the currentNode
	 * @return- the CurrentNode being showed on the GUI
	 */
	public DoubleListNode<T> getCurrent() {
		return currentNode;
	}

	/**
	 * This method moves the currentNode onto the previous node if there is one
	 */
	public void doPrevious() {
		if (currentNode.getPrevious() != null)
			currentNode = currentNode.getPrevious();
	}

	/**
	 * This method gets the head
	 * @return- the head of the entire list
	 */
	public DoubleListNode<T> getHead() {
		return head;
	}
	
	/**
	 * Gets string representation of all of the nodes in the list
	 * @return - the String with all the students
	 */
	public String toString() {
		return currentNode.getValue().toString();
	}
}
