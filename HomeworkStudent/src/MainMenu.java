import java.util.Scanner;

public class MainMenu {

	public static void mainMenu() {
		displayMainMenu();
		try {
		int x = UserEntry.userEntryInt();
		
	
			switch (x) {
			case 1: {
				OverviewMenu.overviewMenu();
				break;
			}
			case 2: {
				Exam.addNewEntry();
				break;
			}
			case 3: {
				AlternationMenu.alternationMenu();
				break;
			}
			
			case 4: {
				System.out.println("Kraj programa.");
				break; 
				}	
			default: {
				System.out.println("Niste uneli validnu opciju \n");
				mainMenu();
				break;
			}
			}
		} catch (NumberFormatException nfe) {
			System.out.println("Niste uneli validnu opciju \n");
			mainMenu();
		}

	}

	public static void displayMainMenu() {
		System.out.println("\nUnesite opciju (1, 2, 3, 4)");
		System.out.println("1. Pregled");
		System.out.println("2. Unos nove prijave");
		System.out.println("3. Izmena");
		System.out.println("4. Kraj programa \n");
	}

}
