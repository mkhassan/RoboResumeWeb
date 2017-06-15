import java.sql.SQLException;

public class TestDBResumeApp {
	
	public static void main(String[] args) throws SQLException {
		
		 String dbUrl = "jdbc:mysql://localhost:3306/Resume?autoReconnect=true&useSSL=false";
		 String Username = "root";
		 String Password = "password";
		 
		 
		 MySQLHelper dao = new MySQLHelper(dbUrl, Username, Password);
		 
		 Person p1 = new Person("kevin", "jack", "kj@gmail.com");
		 
		 System.out.println("Add person p1 to database");
		 
		 boolean personadded = dao.addPerson(p1);
		 
		 if(personadded) {
			 System.out.println("success");
		 }
		 
		boolean persondeleted = dao.deletePerson(p1);
		
		System.out.println(persondeleted);
	}

}
