import javax.swing.*;

import BreezySwing.*;

public class ListGUI extends GBFrame{

	private JTextArea output;
	private JButton previous;
	private JButton next;
	private JButton add;
	private JButton edit;
	private JButton delete;
	private JButton toggle;
	private JButton save;
	
	private DoubleLinkedList<Student> list; //Holds info for list of students
	
	private final String HEADER = String.format("%-25s", "Name:") + String.format("%-10s", "YOG:") + String.format("%-10s", "GPA:") + "\n";

	
	public ListGUI(){
		output = addTextArea("",1,1,5,4);
		previous = addButton("Previous",5,1,1,1);
		next = addButton("Next",5,5,1,1);
		add = addButton("Add",5,2,1,1);
		edit = addButton("Edit",5,3,1,1);
		delete = addButton("Delete",5,4,1,1);
		toggle = addButton("Toggle",6,3,1,1);
		save = addButton("Save",6,4,1,1);
		
		list = new DoubleLinkedList<Student>();
		
		try {
			list = (DoubleLinkedList<Student>) FileIO.getFile();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	/**
	 * This method is called when a button is clicked
	 */
	public void buttonClicked(JButton buttonObj){
		try{
			if(buttonObj == add){
				
				DoubleListNode<Student> dummyNode = new DoubleListNode<Student>(new Student("","",0,0),null,null); 
				editDialog eDialog = new editDialog(this,dummyNode);
				eDialog.setVisible(true);
				list.add(dummyNode.getValue());
			}
			else if(buttonObj == edit){
				DoubleListNode<Student> dummyNode = list.getCurrent();
				editDialog eDialog = new editDialog(this,dummyNode);
				eDialog.setVisible(true);
				list.delete();
				list.add(dummyNode.getValue());
			
			}else if(buttonObj == delete){
				list.delete();
			}else if(buttonObj == next){
				list.getNext();
			}else if(buttonObj == previous){
				list.getPrevious();
			}else if(buttonObj == save){
				FileIO.write(list);
			}else if(buttonObj == toggle){
				Student.toggleSort();
				reAdd();
			}
			
			output.setText(list.getCurrent().getValue().toString());
		}catch (Exception e){
			messageBox(e,600,200);
		}
		
	}
	
	
	/**
	 * This is the main method it creates the actual GUI
	 * @param args
	 */
	public static void main(String[] args) {
		ListGUI theGUI = new ListGUI();
		theGUI.setSize(750, 500);
		theGUI.setVisible(true);
		theGUI.setTitle("Linked List Program");
	}
	
	private void reAdd(){
		DoubleListNode<Student> dummyNode = list.getHead();
		DoubleLinkedList<Student> newList = new DoubleLinkedList<Student>();
		while(dummyNode!=null){
			newList.add(dummyNode.getValue());
			dummyNode = dummyNode.getNext();
		}
		list = newList;
	}
	
}
