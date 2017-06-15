

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class infoservlet
 */
@WebServlet("/infoservlet")
public class Infoservlet extends HttpServlet {
	 MySQLHelper dao;
	private static final long serialVersionUID = 1L;
	
   
    public Infoservlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String dbUrl = "jdbc:mysql://localhost:3306/Resume?autoReconnect=true&useSSL=false";
		 String Username = "root";
		 String Password = "password";   
		dao = new MySQLHelper(dbUrl, Username, Password);
		
			String action = request.getParameter("act");
		 HttpSession session = request.getSession();
		 
		
				try {
					switch(action){
					case "info":
						insertPerson(request, response);
						break;
						
					case "addedu":
						insertEdu(request, response);
						
					case "addexp":
						insertExp(request, response);
						
					case "addskills":
						
						insertSkills(request, response);
						
					} 
				} catch(SQLException ex){
					throw new ServletException(ex);
				}
}
	
	 private void insertPerson(HttpServletRequest request, HttpServletResponse response)
		        throws SQLException, IOException {
		        	
		        	String jfname = request.getParameter("ffname");
		        	String jlname = request.getParameter("flname");
		        	String jemail = request.getParameter("femail");
		            
		    		Person newPerson = new Person(jfname,jlname,jemail);
		    		dao.addPerson(newPerson);
		    		
		    	
		    		
		}
	 
	
	 private void getPerson(HttpServletRequest request, HttpServletResponse response)
		        throws SQLException, IOException {
		 	
		 	
		 	String jfname = request.getParameter("ffname");
     		String jlname = request.getParameter("flname");
     		String jemail = request.getParameter("femail");        
		    		
		    Person aperson = dao.getPerson(5, "jack");
			//dispatcher.forward(request, response);
		    		
		}
	 
	 
	 private void insertEdu(HttpServletRequest request, HttpServletResponse response )
			 throws SQLException, IOException {
		 
     	String juniversity = request.getParameter("funiversity");
     	String jdegree = request.getParameter("fdegree");
     	String jyear = request.getParameter("fyear");
         
 		Education newEducation = new Education(juniversity,jdegree,jyear);
 		dao.addEducation(newEducation);
 		
		 
	 }
	 
	 private void getEducation(HttpServletRequest request, HttpServletResponse response)
		        throws SQLException, IOException {
		 	
		 	
		String juniversity = request.getParameter("funiversity");
  		String jdegree = request.getParameter("fdegree");
  		String jyear = request.getParameter("fyear");        
		    		
		    Person aperson = dao.getPerson(5, "penn state");
			//dispatcher.forward(request, response);
	 
	 
	 }
	 
	 private void insertExp(HttpServletRequest request, HttpServletResponse response )
			 throws SQLException, IOException {
		 
     	String jjobtitle = request.getParameter("fjobtitle");
     	String jcompany = request.getParameter("fcompany");
     	String jstart = request.getParameter("fstart");
     	String jend = request.getParameter("fend");
     	String jduty1 = request.getParameter("fduty1");
     	String jduty2 = request.getParameter("fduty2"); 
     	
         
 		Experience newExperience = new Experience(jjobtitle,jcompany,jstart,jend,jduty1 ,jduty2  );
 		dao.addExperience(newExperience);
 		
		 
	 }
	 
	 private void insertSkills(HttpServletRequest request, HttpServletResponse response )
			 throws SQLException, IOException {
		 
     	String jskill = request.getParameter("fskill");
     	String jskilllevel = request.getParameter("fskilllevel");

         
 		Skills newSkill = new Skills(jskill,jskilllevel  );
 		dao.addSkills(newSkill);
 		
		 
	 }
	 
	 
	 
}
