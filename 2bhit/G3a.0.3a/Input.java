import java.util.Scanner;

/**
 * Provides utility Methods for reading from the system input.
 * @author Lisa Vittori
 * @version 2020-08-18
 */
public class Input {
	private static Scanner sc = new Scanner(System.in);
	/**
	 * Fetches input from the system input device.
	 * @return the input from the system device
	 */
	public static String readLine() {
		String in ="";
		in = sc.nextLine();
		return in;
	}
	
	/**
	 * Fetches input from the system input device after the message is displayed. 
	 * @param message the message displayed before the input prompt is given
	 * @return the input from the system device
	 */
	public static String readLine(String message) {
		if(message != null)
			System.out.print(message);
		return Input.readLine();
	}
	
	/**
	 * Fetches input from the system input device after the message and the
	 * given space is displayed. 
	 * @param message the message displayed before the input prompt is given
	 * @param space the amount of spacing between the message and the input prompt.
	 * @return the input from the system device
	 */
	public static String readLine(String message, int space) {
		StringBuilder sb;
		if(message != null) {
			if(space <= 0) {
				return Input.readLine();
			} else {
				sb = new StringBuilder(message);
			}
		} else {
			sb = new StringBuilder();
		}
		for(int i = 0; i < space; i++) {
			sb.append(' ');
		}
		return Input.readLine(sb.toString());
	}
}
