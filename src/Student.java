import java.io.Serializable;

public class Student implements Comparable<Student>, Serializable{
	/**
	 * Instance variables
	 */
	private String name; //String for student's name
	private String lastName; //String for student's last name
	private int yog; //int for student's year of graduation
	private double gpa; //double for student's GPA
	
	private static boolean sortType = true;
	 /**
	  * Constructor method, instantiates all instance variables for student
	  * @param n - student's name
	  * @param ln - student's last name
	  * @param y - student's year of graduation
	  * @param g - student's GPA
	  */
	public Student(String n, String ln, int y, double g){
		checkGPA(g);
		name = n;
		lastName = ln;
		yog = y;	
		gpa = g;
	}
	/**
	 * This method gets the Students name
	 * @return- the String name of the student
	 */
	public String getName() {
		return name;
	}
	/**
	 * This method sets the students name
	 * @param n- The new Name for the student
	 */
	public void setName(String n) {
		name = n;
	}
	/**
	 * This method sets the last name of the student
	 * @param ln- the new last name for the student
	 */
	public void setLastName(String ln) {
		lastName = ln;
	}
	/**
	 * This method sets the year of graduation
	 * @param y- the new year of graduation
	 */
	public void setYog(int y) {
		yog = y;
	}
	/**
	 * This method sets the GPA for the student
	 * @param g- the new GPA
	 */
	public void setGpa(double g) {
		gpa = g;
	}
	/**
	 * This method gets the first name
	 * @return- the student's first name
	 */
	public String getFirstName(){
		return name;
	}
	
	/**
	 * This method gets the last name
	 * @return- the student's last name
	 */
	public String getLastName(){
		return lastName;
	}
	
	/**
	 * This method gets the year of graduation
	 * @return- the student's year of graduation
	 */
	public int getYOG(){
		return yog;
	}
	/**
	 * This method gets the GPA
	 * @return- the Student's GPA
	 */
	public double getGPA(){
		return gpa;
	}
	/**
	 * This method checks the student's GPA
	 * Must be between 0 and 5 inclusive
	 * @param g- the GPA to check
	 */
	private void checkGPA(double g) {
		if(g<0||g>5)
			throw new IllegalArgumentException("Invalid GPA");
	}
	/**
	 * Gets string representation of student
	 * @return- String for student
	 */
	public String toString(){	
		return 	  String.format("%-25s", lastName+", "+name)
			
				+ String.format("%-10d", yog) 
				+ String.format("%-,10.2f", gpa);
	}
	/**
	 * This method compares two student by last and first name or GPA
	 * @param- the student to compare to
	 * @return- negative if it comes before
	 * 			0 if it is equal
	 * 			positive if it comes after
	 */
	public int compareTo(Student o) {
		if(!(o instanceof Student))
			throw new IllegalArgumentException("Not a student");
		
			if(sortType){
				if(lastName.compareTo((o).getLastName()) == 0){
					return name.compareTo((o).getFirstName());
				}else{
					return lastName.compareTo((o).getLastName());
				}
			}else{
				
				return Double.compare(gpa, o.getGPA());
				
			}
		
	}
	/**
	 * This method toggles the boolean between GPA and last name for adding
	 * @return the String to display the type of sorting being used
	 */
	public static String toggleSort(){
		sortType = !sortType;
		if(sortType)
			return "Last Name";
		else
			return "GPA";
	}
}