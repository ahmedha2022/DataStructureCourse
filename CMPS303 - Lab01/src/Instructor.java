
public class Instructor extends Person{
	private int jobNo;

	public Instructor(String name, int jobNo) {
		super(name);
		this.jobNo = jobNo;
	}

	public int getJobNo() {
		return jobNo;
	}

	public void setJobNo(int jobNo) {
		this.jobNo = jobNo;
	}

	@Override
	public String toString() {
		return "Instructor [jobNo=" + jobNo + "]";
	} 
	
	

}
