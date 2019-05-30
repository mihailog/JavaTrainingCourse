import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam {

	// Date examDate;
	Subject subject;
	Student student;
	int grade;
	CalendarDate entryDate;

	static ArrayList<Exam> exams = new ArrayList<Exam>();

	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Exam(Subject subject, Student student, int grade) {
		super();
		this.subject = subject;
		this.student = student;
		this.grade = grade;
	}

	public Exam(Subject subject, Student student, int grade, CalendarDate examDate) {
		super();
		this.subject = subject;
		this.student = student;
		this.grade = grade;
		this.entryDate = examDate;
	}

	
	public static int studentExists(String numberOfStudent, int yearOfEnrollment) {
		// provera da li postoji student sa brojem indeksa i godinom upisa u listi studenata
		for (Student student : Student.students) {
			if ((numberOfStudent.equals(student.getNoOfStudent()))
					&& (yearOfEnrollment == student.getYearOfEnrollment())) {
				return Student.students.indexOf(student);
			}

		}
		return -1;
	}

	
	public static int subjectExists(int noOfSubject) {
		// provera da li postoji predmet sa brojem predmeta u listi predmeta
		for (Subject subject : Subject.subjects) {
			if (noOfSubject == subject.getNoOfSubject()) {
				return Subject.subjects.indexOf(subject);
			}
		}
		return -1;
	}

	public static void addNewEntry() {

		int indexStudent = -1;
		int indexSubject = -1;
		String numberOfStudent = null;
		int yearOfEnrollment = 0;
		int noOfSubject = 0;
		int grade = 0;
		System.out.println("Unesite broj indeksa studenta");
		numberOfStudent = UserEntry.userEntryString();
		System.out.println("Unesite godinu upisa studenta");
		yearOfEnrollment = UserEntry.userEntryInt();
		System.out.println("Unesite sifru predmeta");
		noOfSubject = UserEntry.userEntryInt();
		System.out.println("Unesite ocenu");
		grade = UserEntry.userEntryInt();
		if (grade < 5 || grade > 10) {
			System.out.println("Ocena nije validna -  mora biti 5, 6, 7, 8, 9 ili 10! \n");
			MainMenu.mainMenu();
		}

		CalendarDate entryDate = new CalendarDate();
		System.out.println("Unesite dan polaganja ispita");
		entryDate.setDate(UserEntry.userEntryInt());
		System.out.println("Unesite mesec polaganja ispita");
		entryDate.setMonth(UserEntry.userEntryInt());
		System.out.println("Unesite godinu polaganja ispita");
		entryDate.setYear(UserEntry.userEntryInt());

		indexStudent = studentExists(numberOfStudent, yearOfEnrollment);
		indexSubject = subjectExists(noOfSubject);

		if ((indexStudent != -1) && (indexSubject != -1)) {
			isStudentInDatabase(Student.students.get(indexStudent), Subject.subjects.get(indexSubject), grade,
					entryDate);
			/*
			 * Exam e = new Exam(); e.setStudent(Student.students.get(indexStudent));
			 * e.setSubject(Subject.subjects.get(indexSubject)); e.setGrade(grade);
			 * exams.add(e); System.out.println("Uspesno uneta nova prijava.");
			 */ // (OVAJ DEO KODA RESEN U METODI isStudentInDatabase!!
			MainMenu.mainMenu();
		} else {
			System.out.println("Ne postoji student/predmet! \n");
			MainMenu.mainMenu();
		}
	}

	public static void displayAllEntriesForSelectedStudent() {
		boolean entryExists = false;
		String numberOfStudent = null;
		int yearOfEnrollment = -1;
		System.out.println("Unesite broj indeksa studenta");
		numberOfStudent = UserEntry.userEntryString();
		System.out.println("Unesite godinu upisa studenta");
		yearOfEnrollment = UserEntry.userEntryInt();

		int indexStudent = studentExists(numberOfStudent, yearOfEnrollment);
		if (indexStudent == -1) {
			System.out.println("Ne postoji trazeni student \n");
			MainMenu.mainMenu();
		}
		System.out.println("Prijave za studenta: " + Student.students.get(indexStudent) + "\n");
		for (Exam exam : exams) {
			if (exam.getStudent().getNoOfStudent().equals(numberOfStudent)
					&& exam.getStudent().getYearOfEnrollment() == yearOfEnrollment) {
				System.out.println(exam);
				entryExists = true;
				continue;
			}
		}
		if (!entryExists) {
			System.out.println("Trazeni student nema prijava");
		}
		System.out.println("");
		MainMenu.mainMenu();
	}

	public static void displayAllStudentsWhomPassedExam() {
		boolean anyonePassed = false;
		System.out.println("Unesite sifru predmeta");
		int noOfSubject = 0;
		int indexSubject = -1;
		noOfSubject = UserEntry.userEntryInt();
		indexSubject = subjectExists(noOfSubject);
		if (indexSubject == -1) {
			System.out.println("Ne postoji ispit sa trazenom sifrom \n");
			MainMenu.mainMenu();
		} else {
			System.out.println("Studenti koji su polozili ispit: " + Subject.subjects.get(indexSubject) + "\n");
			for (Exam exam : exams) {
				if ((exam.getSubject().getNoOfSubject() == noOfSubject) && (exam.getGrade()>=6)) {
					System.out.println(exam.getStudent() + " Ocena: "+ exam.getGrade() + " - Datum polaganja: " + exam.getEntryDate());
					anyonePassed = true;
				}
			}
			if (!anyonePassed) {
				System.out.println("Niko nije polozio ovaj ispit.");
			}
			System.out.println("");
			MainMenu.mainMenu();
		}
	}

	
	public static void isStudentInDatabase(Student student, Subject subject, int grade, CalendarDate entryDate) {
		// metoda koja provera da li student vec postoji u listi ispita, ukoliko postoji
		// i ocena mu je manja, updateovace ocenu
		// u suprotnom, napravice novu prijavu
		boolean gradeChanged = false;
		if (!entryDate.isDateValid(entryDate)) {
			System.out.println("Pogresan format datuma \n");
			MainMenu.mainMenu();
		}
		
		if (grade == 5) {
			addNewExam(student, subject, grade, entryDate);
		} else {
		for (Exam exam : exams) {
			if ((student.getNoOfStudent().equals(exam.getStudent().getNoOfStudent()))
					&& student.getYearOfEnrollment() == exam.getStudent().getYearOfEnrollment()
					&& subject.getNoOfSubject() == exam.getSubject().getNoOfSubject()
					&& grade > exam.getGrade()
					&& exam.getEntryDate().isDateValid(entryDate)) {
				
				if (grade == 5)
				exam.setGrade(grade);
				System.out.println("Uspesno promenjena ocena \n");
				gradeChanged = true;
				break;
			}
		}
			if (!gradeChanged) {
				addNewExam(student, subject, grade, entryDate);
			}
			MainMenu.mainMenu();
		}
	}
	
	public static void addNewExam(Student student, Subject subject, int grade, CalendarDate entryDate) {
		Exam e = new Exam();
		e.setStudent(student);
		e.setSubject(subject);
		e.setGrade(grade);
		e.setEntryDate(entryDate);
		exams.add(e);
		System.out.println("Uspesno uneta nova prijava. \n");
	}

	@Override
	public String toString() {
		return subject + " - ocena: " + grade + " Datum polaganja: " + entryDate;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public CalendarDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(CalendarDate examDate) {
		this.entryDate = examDate;
	}

}
