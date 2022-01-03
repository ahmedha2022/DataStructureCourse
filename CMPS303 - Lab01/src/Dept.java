import java.util.ArrayList;

public class Dept {

	public ArrayList<Student> students = new ArrayList<>();
	public ArrayList<Instructor> instructors = new ArrayList<>();
	public ArrayList<SeniorProject> projects = new ArrayList<>();
	
	public void moreThanOneProject() {
		for(Instructor inst:instructors)
		{
			int counter  = 0;

			for(SeniorProject SP: projects)
				if(SP.getSuperVisor().getJobNo() == inst.getJobNo())
					counter++;

			if(counter>1)
				System.out.println(inst.getName());
		}
	}

	public void displayAllProjects() {
		for(SeniorProject project: projects)
			project.display();
		//	project.toString();

	}
	
	public int seniorStudents() {
		int counter = 0;
		
		for(SeniorProject sp: projects)
			counter+= sp.getCount();
		
		return counter;
	}
	
	public void studentsSupervisedBy(int jobNo) {
		for(SeniorProject proj: projects)
			if(true)
				for(int counter = 0 ; counter < proj.getCount() ; counter++)
					System.out.println(proj.getStudents()[counter].getName());
		
	}
	
	
	
	
	
	
	
	
	
}