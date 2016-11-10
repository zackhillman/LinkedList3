import javax.swing.*;
import BreezySwing.*;

public class ListGUI extends GBFrame {

	private JTextArea output;
	private JButton previous;
	private JButton next;
	private JButton add;
	private JButton edit;
	private JButton delete;
	private JButton toggle;
	private JButton save;

	private JTextField sort;
	private DoubleLinkedList<Student> list; // Holds info for list of students

	private final String HEADER = String.format("%-25s", "Name:") + String.format("%-10s", "YOG:")
			+ String.format("%-10s", "GPA:") + "\n";
	/**
	 * This is the constructor method, the instance variables of the GUI are instantiated
	 */
	public ListGUI() {
		output = addTextArea("", 1, 1, 5, 4);
		previous = addButton("Previous", 5, 1, 1, 1);
		next = addButton("Next", 5, 5, 1, 1);
		add = addButton("Add", 5, 2, 1, 1);
		edit = addButton("Edit", 5, 3, 1, 1);
		delete = addButton("Delete", 5, 4, 1, 1);
		toggle = addButton("Toggle", 6, 3, 1, 1);
		save = addButton("Save", 6, 4, 1, 1);
		sort = addTextField("Last Name", 6, 2, 1, 1);

		list = new DoubleLinkedList<Student>();

		try {
			list = (DoubleLinkedList<Student>) FileIO.getFile();
			reAdd();
		} catch (Exception e) {
			System.out.println(e);
		}

		sort.setEditable(false);
		checkButtons(list.getHead());

		if (list.getHead() == null) {
			next.setEnabled(false);
			delete.setEnabled(false);
			output.setText("No Students");
			edit.setEnabled(false);
		} else {
			output.setText(HEADER + list.toString());
		}
	}

	/**
	 * This method is called when a button is clicked
	 * @param- the button object being pressed
	 */
	public void buttonClicked(JButton buttonObj) {
		try {
			if (buttonObj == add) {

				DoubleListNode<Student> dummyNode = new DoubleListNode<Student>(new Student("", "", 0, 0), null, null);
				editDialog eDialog = new editDialog(this, dummyNode);
				eDialog.setSize(500, 200);
				eDialog.setVisible(true);
				if (!dummyNode.getValue().getLastName().equals("")) {
					list.add(dummyNode.getValue());
					edit.setEnabled(true);
					delete.setEnabled(true);
				}

			} else if (buttonObj == edit) {
				DoubleListNode<Student> dummyNode = list.getCurrent();
				editDialog eDialog = new editDialog(this, dummyNode);
				eDialog.setSize(500, 200);
				eDialog.setVisible(true);
				list.delete();
				if (!dummyNode.getValue().getLastName().equals(""))
					list.add(dummyNode.getValue());
			} else if (buttonObj == delete) {
				list.delete();
			} else if (buttonObj == next) {
				list.doNext();
			} else if (buttonObj == previous) {
				list.doPrevious();
			} else if (buttonObj == save) {
				FileIO.write(list);
			} else if (buttonObj == toggle) {
				sort.setText(Student.toggleSort());
				if (list.getHead() != null)
					reAdd();
			}
			checkButtons(list.getCurrent());
			checkEmpty();

			if (list.getHead() != null)
				output.setText(HEADER + list.toString());

		} catch (Exception e) {
			messageBox(e, 600, 200);
		}

	}
	/**
	 * This method checks if the list is empty and properly displays a message
	 */
	private void checkEmpty() {
		if (list.getHead() == null) {
			delete.setEnabled(false);
			edit.setEnabled(false);
			output.setText("No Students");
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
	/**
	 * This method sorts the list according to the new compareTo
	 */
	private void reAdd() {
		DoubleListNode<Student> dummyNode = list.getHead();
		DoubleLinkedList<Student> newList = new DoubleLinkedList<Student>();
		while (dummyNode != null) {
			newList.add(dummyNode.getValue());
			dummyNode = dummyNode.getNext();
		}
		list = newList;
	}
	/**
	 * This method enables and disables the next and previous buttons
	 * according the the node passed in
	 * @param n- the node to check previous and next
	 */
	private void checkButtons(DoubleListNode<Student> n) {
		if (n != null) {
			previous.setEnabled(n.getPrevious() != null);
			next.setEnabled(n.getNext() != null);
		} else {
			previous.setEnabled(false);
			edit.setEnabled(false);

		}
	}
}
