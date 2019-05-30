import java.util.ArrayList;

public class Subject {

	
	private int noOfSubject;
	private String subjectName;
	

	public Subject(int noOfSubject, String subjectName) {
		super();
		this.noOfSubject = noOfSubject;
		this.subjectName = subjectName;
	}
	
	static ArrayList<Subject> subjects = new ArrayList<Subject>();
	
	
	
	public Subject() {
		
	}
	
	public static ArrayList<Subject> createSubjectDatabase() {
		
		
		subjects.add(new Subject(1010, "Matematika 1"));
		subjects.add(new Subject(2010, "Matematika 2"));
		subjects.add(new Subject(3010, "Matematika 3"));
		subjects.add(new Subject(1234, "Statika 1"));
		subjects.add(new Subject(1268, "Statika 2"));
		subjects.add(new Subject(9990, "Teorija ploca i Ljuski"));
		
		return subjects;
		
	}
	
	public static void displayAllSubjects() {
		for (Subject subject : subjects) {
			System.out.println(subject);
		}
	}
	
	@Override
	public String toString() {
		return "(" + getNoOfSubject() + ") " + getSubjectName();
	}

	public int getNoOfSubject() {
		return noOfSubject;
	}

	public void setNoOfSubject(int noOfSubject) {
		this.noOfSubject = noOfSubject;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	
}
