import java.util.ArrayList;

public class ResumeBuilder {
	
	private Person person;
	private ArrayList<Education> education;
	private ArrayList<Experience> experience;
	private ArrayList<Skills> skills;
	
	
	public ResumeBuilder(Person person, ArrayList<Education> education, ArrayList<Experience> experience,
			ArrayList<Skills> skills) {
		super();
		this.person = person;
		this.education = education;
		this.experience = experience;
		this.skills = skills;
	}


	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	public ArrayList<Education> getEducation() {
		return education;
	}


	public void setEducation(ArrayList<Education> education) {
		this.education = education;
	}


	public ArrayList<Experience> getExperience() {
		return experience;
	}


	public void setExperience(ArrayList<Experience> experience) {
		this.experience = experience;
	}


	public ArrayList<Skills> getSkills() {
		return skills;
	}


	public void setSkills(ArrayList<Skills> skills) {
		this.skills = skills;
	}
	

	

}
