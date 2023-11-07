package jsp_employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/update")
public class UpdateController extends HttpServlet{

	//update delete doget()
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		EmployeeCrud crud=new EmployeeCrud();
		
		try
		{
			Employee e1=crud.find(id);
			HttpSession httpSession=req.getSession();
			System.out.println(httpSession);
			String sessionValue=(String) httpSession.getAttribute("Employee");
			req.setAttribute("Emp", e1);
			if(sessionValue!=null)
			{
				req.setAttribute("Emp", e1);
				
				RequestDispatcher rd=req.getRequestDispatcher("edit.jsp");
				rd.forward(req, res);
			}
			else
			{
				req.setAttribute("message", "Idiot pls login 1st");
				
				RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
				rd.forward(req, res);
			}
			
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
	}
}
