
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
 * Servlet implementation class Eduservlet
 */
@WebServlet("/eduservlet")
public class Eduservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Eduservlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	 String dbUrl = "jdbc:mysql://localhost:3306/Resume?autoReconnect=true&useSSL=false";
	 String Username = "root";
	 String Password = "password"; 
	 MySQLHelper dao = new MySQLHelper(dbUrl, Username, Password);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	

		 
		 
			HttpSession session = request.getSession();
			
			Person eduperson =(Person) session.getAttribute("myperson");
			//MySQLHelper dao = (MySQLHelper)session.getAttribute("dao");

			String nextURL = "/resume.jsp";
			String action = request.getParameter("act");
			
			
			
			
			try {
				switch(action){

					
				case "addedu":
					
					// insert education to database method 
					eduperson.addEdu(insertEdu(request, response));
					
					
					// set attribute and dispatch to resume form
			     	String juniversity = request.getParameter("funiversity");
			     	String jdegree = request.getParameter("fdegree");
			     	String jyear = request.getParameter("fyear");
			     	
					session.setAttribute("suniv", juniversity);
					session.setAttribute("sdegree", jdegree);
					session.setAttribute("syear", jyear);
					session.setAttribute("myperson", eduperson);
					getServletContext().getRequestDispatcher(nextURL).forward(request, response);
			     	
			     
					
					
				
			     	
			
				} 
			} catch(SQLException ex){
				throw new ServletException(ex);
			}

	}		
			
	private Education insertEdu(HttpServletRequest request, HttpServletResponse response )
			 throws SQLException, IOException {
		 
    	String juniversity = request.getParameter("funiversity");
    	String jdegree = request.getParameter("fdegree");
    	String jyear = request.getParameter("fyear");
        
		Education newEducation = new Education(juniversity,jdegree,jyear);
		
		// add to the database here 
		dao.addEducation(newEducation);
		
		 return newEducation;
	 }
	

			
			
			
			
			
	}	
	
	
	

 	
		
	

