import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserEntry {

	static Scanner scanner = new Scanner(System.in);

	public static String userEntryString() {

		String choice = scanner.nextLine();
		// scanner.close(); // iz nekog razloga kad jednom zatvorim scanner, javlja error (proveriti!)
		return choice;

	}

	// bolja opcija da stavim kod menu-ja da su 1,2,3,4 stringovi , onda sa
	// defaultom rešavam input exception
	public static int userEntryInt() {

// 			try {
// 			int choice = scanner.nextInt();
//			scanner.close();
//			} catch (InputMismatchException pe) {
//			System.out.println("Pogresan unos, unesite ponovo: ");
//			MainMenu.mainMenu();
//			}
		int choice = Integer.parseInt(scanner.nextLine());
		return choice;
	}

}
