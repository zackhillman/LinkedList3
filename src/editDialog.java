import javax.swing.*;
import BreezySwing.*;

public class editDialog extends GBDialog{

	private JLabel nameL;
	private JLabel lastNameL;
	private JLabel yogL;
	private JLabel gpaL;
	
	private JTextField nameF; //User inputs first name
	private JTextField lastNameF; //User inputs last name
	private IntegerField yogF; //User inputs year of graduation
	private DoubleField gpaF; //User inputs GPA
	
	private JButton ok; //Confirms edit
	private JButton cancel; //Cancels edit
	
	private DoubleListNode<Student> node; //The node that is being edited
	/**
	 * This is the constructor method. It constructs the super and instantiates node
	 * @param f- the Parent JFrame
	 * @param n- the Node to be edited
	 */
	public editDialog(JFrame f, DoubleListNode<Student> n){
		super(f);
		node = n;
		setDlgCloseIndicator("Cancel");
		
		nameL = addLabel("First Name:",1,1,1,1);
		lastNameL = addLabel("Last Name:",1,2,1,1);
		yogL = addLabel("Year of Graduation:",1,3,1,1);
		gpaL = addLabel("GPA:",1,4,1,1);
		if(node!=null){
			nameF = addTextField(( n.getValue()).getFirstName(),2,1,1,1);
			lastNameF = addTextField( (n.getValue()).getLastName(),2,2,1,1);
			yogF = addIntegerField((n.getValue()).getYOG(),2,3,1,1);
			gpaF = addDoubleField((n.getValue()).getGPA(),2,4,1,1);
		}else{
			nameF = addTextField("",2,1,1,1);
			lastNameF = addTextField("",2,2,1,1);
			yogF = addIntegerField(0,2,3,1,1);
			gpaF = addDoubleField(0,2,4,1,1);

		}
		ok = addButton("Ok",3,2,1,1);
		cancel = addButton("Cancel",3,3,1,1);
	}
	/**
	 * This method is called when a button is clicked on the GUI
	 * @param- the button being clicked
	 */
	public void buttonClicked (JButton buttonObj){
		
		if(buttonObj == cancel){
			dispose();
		
		}else{
			if(gpaF.getNumber()<0||gpaF.getNumber()>5)
				throw new IllegalArgumentException("Invalid GPA");
			(node.getValue()).setName(nameF.getText());
			(node.getValue()).setLastName(lastNameF.getText());
			(node.getValue()).setYog(yogF.getNumber());
			(node.getValue()).setGpa(gpaF.getNumber());

			
			setDlgCloseIndicator("Ok");
			dispose();
		}
	}
	
	
}