import java.util.ArrayList;

public class Person {
	
	private String firstname;
	private String lastname;
	private String email;
	private int personid;
	
	private ArrayList<Education> education;
	private ArrayList<Experience> experience;
	private ArrayList<Skills> skills;
	
	
	
	
	
	public Person(String mfirstname, String mlastname, String memail ){
	 this.firstname = mfirstname;
	 this.lastname = mlastname;
	 this.email = memail;
	 this.education = new ArrayList<Education>(); 
	 this.experience = new ArrayList<Experience>();
	 this.skills = new ArrayList<Skills>();
	 

	 }
	
	public Person(String mfirstname, String mlastname, String memail, int mpersonid){
		this(mfirstname, mlastname, memail);
		this.personid = mpersonid;
	}
	
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstName(String mfirstname) {
		firstname = mfirstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String mlastname) {
		lastname = mlastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String memail) {
		email = memail;
	}

	public int getPersonid() {
		return personid;
	}



	public void setPersonid(int personid) {
		this.personid = personid;
	}



	@Override
	public String toString() {
		return "[FirstName=" + firstname + ", LastName=" + lastname + ", Email=" + email + "]";
	}


	public void addExp(Experience experience) {
		this.experience.add(experience);
	}

	public void addEdu(Education education) {
		this.education.add(education);
	}

	 
	public void addSki(Skills skills) {
		this.skills.add(skills);
	}

	
	
}





