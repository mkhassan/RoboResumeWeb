
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class MySQLHelper {

	private String dbUrl;
	private String dbUsername;
	private String dbPassword;
	private Connection dbConnection;
	
	public MySQLHelper(String dbUrl, String dbUsername, String dbPassword) {
		this.dbUrl = dbUrl;
		this.dbUsername = dbUsername;
		this.dbPassword = dbPassword;
	}
	
	protected void connect() throws SQLException {
		if (dbConnection == null || dbConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			dbConnection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		}
	}
	protected void disconnect() throws SQLException {
		if (dbConnection != null && !dbConnection.isClosed()){
			dbConnection.close();
		}
	}
	
	public boolean addPerson(Person person) throws SQLException{
		String sql = " INSERT INTO Person (FirstName, LastName,"
				+ " Email) VALUES (?,?,?)";
		connect();
		
		PreparedStatement stm = dbConnection.prepareStatement(sql);
		
		stm.setString(1, person.getFirstname());
		stm.setString(2, person.getLastname());
		stm.setString(3, person.getEmail());

		boolean personAdded = stm.executeUpdate() > 0;
		stm.close();
		disconnect();
		return personAdded;
		
	}
	
	public boolean deletePerson(Person person) throws SQLException {
		String sql = "DELETE FROM Resume.Person WHERE FirstName = ? AND LastName = ?";
		
		connect();
		PreparedStatement stm = dbConnection.prepareStatement(sql);
		stm.setString(1, person.getFirstname());
		stm.setString(2,  person.getLastname());
		boolean personDeleted = stm.executeUpdate() > 0;
		stm.close();
		disconnect();
		return personDeleted;	
	}
	
	public boolean updatePerson(Person person) throws SQLException {
		String sql = "UPDATE Resume.Person SET FirstName =?, LastName=?,"
				+ "Email=? WHERE PersonID = ?";
		connect();
		
		PreparedStatement stm = dbConnection.prepareStatement(sql);
		
		stm.setString(1, person.getFirstname());
		stm.setString(2, person.getLastname());
		stm.setString(3, person.getEmail());

      
		boolean personUpdated = stm.executeUpdate() > 0;
		stm.close();
		disconnect();
		return personUpdated;
		
	}
	
	public List<Person> listPersons() throws SQLException{
		List<Person> listPerson = new ArrayList<>();
		
		String sql = "SELECT * FROM Resume.Person LIMIT 10";
		
		connect();
		Statement stm = dbConnection.createStatement();
		ResultSet resultSet = stm.executeQuery(sql);
		
		while (resultSet.next()) {
			String firstname = resultSet.getString("FirstName");
			String lastname = resultSet.getString("LastName");
			String email = resultSet.getString("Email");
			
			Person person = new Person(firstname,lastname, email);
			listPerson.add(person);
			
		}
		
		resultSet.close();
		stm.close();
		disconnect();
		
		return listPerson;
		
		
	}
	
	public Person getPerson(String personid, String lastname) throws SQLException {
		Person person = null;
		String sql = "SELECT * FROM Resume.Person WHERE PersonID= ? AND LastName = ?";
		
		
		PreparedStatement stm = dbConnection.prepareStatement(sql);
		stm.setString(1,  personid);
		stm.setString(2, lastname);
		
		ResultSet resultSet = stm.executeQuery();
		
		if (resultSet.next()) {
			String fname = resultSet.getString("FirstName");
			String lname = resultSet.getString("LastName");
			String email = resultSet.getString("Email");
			
			person = new Person(fname, lname, email);
		}
		
		resultSet.close();
		stm.close();
		
		return person;

	}
	
}
