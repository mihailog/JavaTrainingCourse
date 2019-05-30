
public class OverviewMenu {

	private static void displayOverviewMenu() {

		System.out.println("\nUnesite opciju (a, b, c, d, e)");
		System.out.println("a. Pregled svih predmeta.");
		System.out.println("b. Pregled svih studenata.");
		System.out.println("c. Pregled svih prijava za traženog studenta");
		System.out.println("d. Prikaz svih studenata koji su polozili odredjeni predmet");
		System.out.println("e. Povratak u glavni meni \n");
	}

	public static void overviewMenu() {

		displayOverviewMenu();
		String s = UserEntry.userEntryString();
		switch (s.toLowerCase()) {
		case "a": {
			Subject.displayAllSubjects();
			overviewMenu();
			break;
		}
		case "b": {
			Student.displayAllStudents();
			overviewMenu();
			break;
		}
		case "c":
			Exam.displayAllEntriesForSelectedStudent();
			break;
		case "d":
			Exam.displayAllStudentsWhomPassedExam();
			break;
		case "e":
			MainMenu.mainMenu();
			break;
		default: {
			System.out.println("Niste uneli validnu opciju \n");
			overviewMenu();
			break;
		}
		}
	}
}
