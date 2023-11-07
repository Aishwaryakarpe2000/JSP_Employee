package jsp_employee;

import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class DeleteController extends HttpServlet{

	protected void doGet(HttpServletRequest req,HttpServletResponse res) {
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		EmployeeCrud crud=new EmployeeCrud();
		
		try
		{
			int result=crud.delete(id);
			if(result!=0)
			{
				List<Employee> emp=crud.display();
				req.setAttribute("list", emp);
				
				RequestDispatcher rd=req.getRequestDispatcher("display.jsp");
				rd.forward(req,res);
			}
			else
			{
				RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
				rd.forward(req,res);
			}
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}
}

