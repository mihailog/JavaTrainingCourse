import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Student {

	private String noOfStudent;
	private int yearOfEnrollment;
	private String studentName;
	private String studentSurname;
	private CalendarDate studentDateOfBirth;
	
	
	static ArrayList<Student> students = new ArrayList<Student>();
	
	public Student() {
		
	}
	
	public Student(String noOfStudent, int yearOfEnrollment, String studentName, String studentSurname,
			CalendarDate studentDateOfBirth) {
		super();
		this.noOfStudent = noOfStudent;
		this.yearOfEnrollment = yearOfEnrollment;
		this.studentName = studentName;
		this.studentSurname = studentSurname;
		this.studentDateOfBirth = studentDateOfBirth;
	}
	
	


	public Student(String noOfStudent, int yearOfEnrollment, String studentName, String studentSurname) {
		super();
		this.noOfStudent = noOfStudent;
		this.yearOfEnrollment = yearOfEnrollment;
		this.studentName = studentName;
		this.studentSurname = studentSurname;
	}

	public static ArrayList<Student> createStudentDatabase() {
		
		students.add(new Student("01", 10, "Pero", "Peric",new CalendarDate(26,4,1991)));
		students.add(new Student("02", 10, "Jovo", "Jovic",new CalendarDate(15,8,1990)));
		students.add(new Student("03", 10, "Rajo", "Rajic",new CalendarDate(23,6,1989)));
		students.add(new Student("04", 8, "Lazo", "Lazic",new CalendarDate(10,4,1985)));
		students.add(new Student("05", 9, "Boro", "Boric",new CalendarDate(1,1,1993)));
		students.add(new Student("01", 8, "Rajo", "Rajic",new CalendarDate(3,3,1990)));
		
		return students;
		}
	
	public static void displayAllStudents() {
		
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	public static void alternateStudentInfo() {
		System.out.println("Unesite broj indeksa");	
		String numberOfStudent = UserEntry.userEntryString();
		System.out.println("Unesite godinu upisa");
		int yearOfEnrollment = UserEntry.userEntryInt();
		int indexStudent = Exam.studentExists(numberOfStudent, yearOfEnrollment);
		if (indexStudent == -1) {
			System.out.println("Ne postoji trazeni student \n");
			MainMenu.mainMenu();
		} else {
			Student student = Student.students.get(indexStudent);
			AlternationMenu.alternateStudent(student);
		}
		
		
		
	}
	
	public void printDate(CalendarDate cd) {
		String months[] = { "Jan", "Feb", "Mar", "Apr", "Maj", "Jun", "Jul", "Avg", "Sep", "Okt", "Nov", "Dec" };
		GregorianCalendar gcalendar = new GregorianCalendar();
		gcalendar.set(cd.getYear(), cd.getMonth()-1, cd.getDate());
		System.out.println((gcalendar.get(gcalendar.DATE)) + " " + (months[gcalendar.get(gcalendar.MONTH)]) + " "
				+ (gcalendar.get(gcalendar.YEAR)));
	}
	
	
	
	@Override
	public String toString() {
		return noOfStudent + "/" + yearOfEnrollment + " "
				+ studentName + " " + studentSurname + " (datum rodjenja: " + studentDateOfBirth + ")";
	}
	
	public String getNoOfStudent() {
		return noOfStudent;
	}


	public void setNoOfStudent(String noOfStudent) {
		this.noOfStudent = noOfStudent;
	}


	public int getYearOfEnrollment() {
		return yearOfEnrollment;
	}


	public void setYearOfEnrollment(int yearOfEnrollment) {
		this.yearOfEnrollment = yearOfEnrollment;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getStudentSurname() {
		return studentSurname;
	}


	public void setStudentSurname(String studentSurname) {
		this.studentSurname = studentSurname;
	}


	public CalendarDate getStudentDateOfBirth() {
					
		return studentDateOfBirth;
	}


	public void setStudentDateOfBirth(CalendarDate studentDateOfBirth) {
			
		this.studentDateOfBirth = studentDateOfBirth;
	}
	
}
