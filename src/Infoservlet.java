

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
	// MySQLHelper dao;
	private static final long serialVersionUID = 1L;
	
	 
	//public static final HttpSession session = request.getSession();
   
    public Infoservlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	 String dbUrl = "jdbc:mysql://localhost:3306/Resume?autoReconnect=true&useSSL=false";
	 String Username = "root";
	 String Password = "password"; 
	 MySQLHelper dao = new MySQLHelper(dbUrl, Username, Password);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 HttpSession session = request.getSession();
		 Person myperson;
		
		
		
		String nextURL = "/resume.jsp";
		
			String action = request.getParameter("act");
		
		
				try {
					switch(action){
					case "info":
						// insert to database
						 insertPerson(request, response);
						
						
					 	String jfname = request.getParameter("ffname");
			     		String jlname = request.getParameter("flname");
			     		String jemail = request.getParameter("femail");        
					    		
					  
					
						session.setAttribute("sfirst", jfname);
						session.setAttribute("slast", jlname);
						session.setAttribute("semail", jemail);
						myperson = new Person(jfname, jlname, jemail);
						session.setAttribute("myperson", myperson);
						getServletContext().getRequestDispatcher(nextURL).forward(request, response);
						
						break;
						

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
		        throws SQLException,ServletException, IOException {
		 	
		 	
	
		}
	 




	 
	 
}
