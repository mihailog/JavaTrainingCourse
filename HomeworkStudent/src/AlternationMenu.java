import java.util.Scanner;

public class AlternationMenu {

	public static void displayAlternationMenu() {
		
		System.out.println("\nUnesite opciju (a,b)");
		System.out.println("a. Izmena podataka o studentu");
		System.out.println("b. Povratak u glavni meni \n");

	}
	
	public static void alternationMenu() {
		
		displayAlternationMenu();
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();		
		switch (x.toLowerCase()) {
		case "a": {
			Student.alternateStudentInfo(); break;
		}
		case "b": {
			MainMenu.mainMenu(); break;
		}
		default: {
			System.out.println("Niste uneli validnu opciju");
			alternationMenu();
			break;
		}
	}
}
	
	public static void displayStudentAlternationMenu() {
		System.out.println("\nUnesite opciju (a, b, c, d, e, f)");
		System.out.println("a. Izmeni ime studenta");
		System.out.println("b. Izmeni prezime studena");
		System.out.println("c. Izmeni broj indexa studenta");
		System.out.println("d. Izmeni godinu upisa studenta");
		System.out.println("e. Izmeni datum rodjenja");
		System.out.println("f. Povratak u glavni meni \n");
	}
	
	public static void alternateStudent(Student student) {
	
		AlternationMenu.displayStudentAlternationMenu();
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();
		switch (x) {
		case "a": {
				System.out.println("Unesite novo ime studenta \n");
				String newName = UserEntry.userEntryString();
				student.setStudentName(newName);
				alternateStudent(student);
				break;
		}
		case "b": {
			System.out.println("Unesite novo prezime studenta \n");
			String newSurname = UserEntry.userEntryString();
			student.setStudentName(newSurname);
			alternateStudent(student);
			break;
		}
		case "c": {
			System.out.println("Unesite novi broj indexa studenta \n");
			String newNoOfStudent = UserEntry.userEntryString();
			student.setNoOfStudent(newNoOfStudent);
			alternateStudent(student);
			break;
		}
		case "d": {
			System.out.println("Unesite novu godinu upisa za trazenog studenta \n");
			int newYearOfEnrollment = UserEntry.userEntryInt();
			student.setYearOfEnrollment(newYearOfEnrollment);
			alternateStudent(student);
			break;
		}
		case "e": {
//			System.out.println("Unesite novi datum rodjenja za trazenog studenta - format (dd.mm.gggg) \n");
			CalendarDate studentDateOfBirth = new CalendarDate();
			System.out.println("Unesite dan rodjenja");
			studentDateOfBirth.setDate(UserEntry.userEntryInt());
			System.out.println("Unesite mesec rodjenja");
			studentDateOfBirth.setMonth(UserEntry.userEntryInt());
			System.out.println("Unesite godinu rodjenja");
			studentDateOfBirth.setYear(UserEntry.userEntryInt());
			if (studentDateOfBirth.isDateValid(studentDateOfBirth)) {
			student.setStudentDateOfBirth(studentDateOfBirth);
			alternateStudent(student);
			break;
			}
			else {
				System.out.println("Pogresan format datuma \n");
				alternateStudent(student);
			}
		}
		
		case "f": {
			MainMenu.mainMenu();
			break;
		}
		default: {
			System.out.println("Pogresan unos \n");
			alternateStudent(student);
		}
	}
	}
	
	

	
}