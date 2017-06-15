public class Experience {
	
	private String JobTitle;
	private String Company;
	private String StartDate;
	private String EndDate;
	private String Duty1;
	private String Duty2;
	
	
	public Experience(String jobtitle, String company, String startdate, String enddate, String duty1, String duty2) {
		
		this.JobTitle = jobtitle;
		this.Company = company;
		this.StartDate = startdate;
		this.EndDate = enddate;
		this.Duty1 = duty1;
		this.Duty2 = duty2;
	}


	public String getJobTitle() {
		return JobTitle;
	}


	public void setJobTitle(String jobTitle) {
		JobTitle = jobTitle;
	}


	public String getCompany() {
		return Company;
	}


	public void setCompany(String company) {
		Company = company;
	}


	public String getStartDate() {
		return StartDate;
	}


	public void setStartDate(String startDate) {
		StartDate = startDate;
	}


	public String getEndDate() {
		return EndDate;
	}


	public void setEndDate(String endDate) {
		EndDate = endDate;
	}


	public String getDuty1() {
		return Duty1;
	}


	public void setDuty1(String duty1) {
		Duty1 = duty1;
	}


	public String getDuty2() {
		return Duty2;
	}


	public void setDuty2(String duty2) {
		Duty2 = duty2;
	};

	
	
}
