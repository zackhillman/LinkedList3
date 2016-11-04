import java.io.Serializable;

public class DoubleLinkedList <T extends Comparable<T>> implements Serializable{

	//Instance Variables
		private DoubleListNode<T> head; //Singular instance variable, holds reference to first node
		private DoubleListNode<T> currentNode;
		/**
		 * Constructor method, instantiates all instance variables to null
		 */
		public DoubleLinkedList(){
			head = null;
			currentNode = null;
		}
		
		/**
		 * This method adds an element to the linked list in alphabetical order
		 * @param element- the new element to add to the list
		 * @return- used to stop the adding process
		 */
		public void add(T element){
			DoubleListNode<T> tempNode = head;

			if (head == null||(element).compareTo(head.getValue())<0){
				DoubleListNode<T> newNode = new DoubleListNode<T>(element,head,null);
				if(head !=null)
					head.setPrevious(newNode);
				head = newNode;
				currentNode = newNode;
			
			}else{
								
				while(tempNode.getNext() != null){
					tempNode = currentNode.getNext();
					if((element).compareTo(tempNode.getValue())<=0){
						DoubleListNode<T> newNode = new DoubleListNode<T>(element,tempNode,tempNode.getPrevious());
						tempNode.getPrevious().setNext(newNode);
						tempNode.setPrevious(newNode);
						currentNode = newNode;
					}
				}
				if((element).compareTo(tempNode.getValue())>0){
					DoubleListNode<T> newNode = new DoubleListNode<T>(element,null,tempNode);
					tempNode.setNext(newNode);
					currentNode = newNode;
				}
				
			}
		}
		
		/**
		 * This method does not use an iterator to delete an element from the array.
		 */
		public void delete(){
			
			if (currentNode.getPrevious() != null){
				currentNode.getPrevious().setNext(currentNode.getNext());
				currentNode = currentNode.getPrevious();
			}else{
				head = currentNode.getNext();
				currentNode = head;
			}
		
		}	
		
		public void getNext(){
			if(currentNode.getNext()!=null)
				currentNode = currentNode.getNext();
		}
		
		public DoubleListNode<T> getCurrent(){
			return currentNode;
		}
		
		
		public void getPrevious(){
			if(currentNode.getPrevious()!=null)
				currentNode = currentNode.getPrevious();
		}
		
		public DoubleListNode<T> getHead(){
			return head;
		}
	
}
