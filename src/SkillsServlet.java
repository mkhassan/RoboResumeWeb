

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
 * Servlet implementation class SkillsServlet
 */
@WebServlet("/SkillsServlet")
public class SkillsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	
    public SkillsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	 String dbUrl = "jdbc:mysql://localhost:3306/Resume?autoReconnect=true&useSSL=false";
	 String Username = "root";
	 String Password = "password"; 
	 MySQLHelper dao = new MySQLHelper(dbUrl, Username, Password);
   
    
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		Person skiperson =(Person) session.getAttribute("myperson");
		//MySQLHelper dao = (MySQLHelper)session.getAttribute("dao");

		String nextURL = "/resume.jsp";
		String action = request.getParameter("act");
		
		
		
		
		
		try {
			switch(action){


		
			case "addskills":
				
				insertSkills(request, response);
				
				skiperson.addSki(insertSkills(request, response));
				
		     	String jskill = request.getParameter("fskill");
		     	String jskilllevel = request.getParameter("fskilllevel");

				session.setAttribute("sskill", jskill);
				session.setAttribute("sskilllevel", jskilllevel);
				System.out.println(jskill + " " + jskilllevel);
		     	
				getServletContext().getRequestDispatcher(nextURL).forward(request, response);
			} 
		} catch(SQLException ex){
			throw new ServletException(ex);
		}
		
	}	
		 private Skills insertSkills(HttpServletRequest request, HttpServletResponse response )
				 throws SQLException, IOException {
			 
	     	String jskill = request.getParameter("fskill");
	     	String jskilllevel = request.getParameter("fskilllevel");

	         
	 		Skills newSkill = new Skills(jskill,jskilllevel  );
	 		dao.addSkills(newSkill);
	 		
			 return newSkill;
		 }
		 
		
		
		

		
		
		
		
		
		
		
		
		
	
}
