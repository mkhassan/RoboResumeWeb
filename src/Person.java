public class Person {
	
	private String firstname;
	private String lastname;
	private String email;
	
	public Person(String mfirstname, String mlastname, String memail){
	 this.firstname = mfirstname;
	 this.lastname = mlastname;
	 this.email = memail;

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

	@Override
	public String toString() {
		return "[FirstName=" + firstname + ", LastName=" + lastname + ", Email=" + email + "]";
	};
	 
	
	
	
}





