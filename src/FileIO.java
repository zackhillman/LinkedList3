import java.io.*;

public class FileIO {

	private final static String FILENAME = "LL3.dat";
	
	/**
	 * This method writes an object to file
	 * @param o - the object to write onto the file
	 */
	public static void write(Object o) {
		try {
			FileOutputStream file = new FileOutputStream(FILENAME);
			ObjectOutputStream output = new ObjectOutputStream(file);

			output.writeObject(o);
			file.close();
			output.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	/**
	 * This method deletes the file from the system
	 * @param f - the String name of the file to delete
	 */
	public static void delete(String f) {
		(new File(f)).delete();
	}
	/**
	 * This method gets the object from a file
	 */
	public static Object getFile() {
		Object output = new Object();
		try {
			FileInputStream file2 = new FileInputStream(FILENAME);
			ObjectInputStream input = new ObjectInputStream(file2);
			output = input.readObject();
			file2.close();
			input.close();
		} catch (IOException e) {
			System.err.println(e);
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		}
		return output;
	}
}