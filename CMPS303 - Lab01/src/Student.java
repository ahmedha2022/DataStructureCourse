
public class Student extends Person{
	
	private int id;
	private int credits;
	
	public Student(String name, int id, int credits) {
		super(name);
		this.id = id;
		this.credits = credits;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", credits=" + credits + "]";
	}

}
