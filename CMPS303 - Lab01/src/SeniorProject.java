import java.util.Arrays;

public class SeniorProject {
	private Instructor superVisor;
	private Student students[] = new Student[3];
	private int count = 0;
	
	public void addStudent(Student std) {
		if(count == 3)
			System.out.println("This project already has three students.");
		else if (std.getCredits() < 80)
			System.out.println("The students did not finish 80 credit hours.");
		else
			students[count++] = std;		
	}
	
	public void display() {
		System.out.println("Instructor name: " + superVisor.getName());
		System.out.println("Students name: ");
		for(int counter = 0 ; counter < count ; counter++)
			System.out.println(students[counter].getName());		
	}
	
	public Instructor getSuperVisor() {
		return superVisor;
	}
	public void setSuperVisor(Instructor superVisor) {
		this.superVisor = superVisor;
	}
	public Student[] getStudents() {
		return students;
	}
	public void setStudents(Student[] students) {
		this.students = students;
	}
	public int getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "SeniorProject [superVisor=" + superVisor + ", students=" + Arrays.toString(students) + "]";
	}

}