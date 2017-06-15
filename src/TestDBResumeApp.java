import java.sql.SQLException;

public class TestDBResumeApp {
	
	public static void main(String[] args) throws SQLException {
		
		 String dbUrl = "jdbc:mysql://localhost:3306/Resume?autoReconnect=true&useSSL=false";
		 String Username = "root";
		 String Password = "password";
		 
		 
		 MySQLHelper dao = new MySQLHelper(dbUrl, Username, Password);
		 
		 Person p1 = new Person("kevin", "jack", "kj@gmail.com");
		 
		 Person p2 = new Person("sadiq", "kabir", "sk@gmail.com");
		 
		 System.out.println("Add person p1 to database");
		 
		 boolean p1added = dao.addPerson(p1);
		 boolean p2added = dao.addPerson(p2);
	
		 
		Person getp1 = dao.getPerson(5,"jack");
		
		String hisname = getp1.getFirstname();
		
		System.out.println(hisname);
		
	}

}
