

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
 * Servlet implementation class ExpServlet
 */
@WebServlet("/expServlet")
public class ExpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpServlet() {
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
		
		Person expperson =(Person) session.getAttribute("myperson");
		//MySQLHelper dao = (MySQLHelper)session.getAttribute("dao");

		String nextURL = "/resume.jsp";
		String action = request.getParameter("act");
		
		try {
			switch(action){
		

				
			case "addexp":
				
				// insert into database
				insertExp(request, response);
				
				expperson.addExp(insertExp(request, response));
				// display to resume page
				
		     	String jjobtitle = request.getParameter("fjobtitle");
		     	String jcompany = request.getParameter("fcompany");
		     	String jstart = request.getParameter("fstart");
		     	String jend = request.getParameter("fend");
		     	String jduty1 = request.getParameter("fduty1");
		     	String jduty2 = request.getParameter("fduty2"); 
		     	
				session.setAttribute("sjobtitle", jjobtitle);
				session.setAttribute("scompany", jcompany);
				session.setAttribute("sstart", jstart);
		     	
				session.setAttribute("send", jend);
				session.setAttribute("sduty1", jduty1);
				session.setAttribute("sduty2", jduty2);
				session.setAttribute("myperson", expperson);
				
				getServletContext().getRequestDispatcher(nextURL).forward(request, response);
		     	
		     	

			//	getServletContext().getRequestDispatcher(nextURL).forward(request, response);
			} 
		} catch(SQLException ex){
			throw new ServletException(ex);
		}

		
			
	}
	
	
	 
	 private Experience insertExp(HttpServletRequest request, HttpServletResponse response )
			 throws SQLException, IOException {
		 
    	String jjobtitle = request.getParameter("fjobtitle");
    	String jcompany = request.getParameter("fcompany");
    	String jstart = request.getParameter("fstart");
    	String jend = request.getParameter("fend");
    	String jduty1 = request.getParameter("fduty1");
    	String jduty2 = request.getParameter("fduty2"); 
    	
        
		Experience newExperience = new Experience(jjobtitle,jcompany,jstart,jend,jduty1 ,jduty2  );
		dao.addExperience(newExperience);
		
		 return newExperience;
	 }
	 

}
