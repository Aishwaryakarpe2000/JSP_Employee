package jsp_employee;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login")

public class LoginController extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException{
			
			String email=req.getParameter("email"); 
			String password=req.getParameter("password");
			
			Employee e=new Employee();
			
			e.setEmail(email);
			e.setPassword(password);
			
			EmployeeCrud crud=new EmployeeCrud();
			try
			{
				String dbpassword=crud.login(email);
				PrintWriter pw=res.getWriter();
				if(password.equals(dbpassword))
				{
					//pw.print("login success");
					HttpSession httpSession=req.getSession();
					httpSession.setAttribute("Employee", email);
					System.out.println(httpSession);
					
					Cookie c= new Cookie("Emp",email);
					res.addCookie(c);
					
					List<Employee> es=crud.display();
					req.setAttribute("list", es);
					
					RequestDispatcher rd=req.getRequestDispatcher("display.jsp");
					rd.forward(req, res);	//sends the request
					
					//res.sendRedirect("https://www.facebook.com/");
				}
				else
				{
					//pw.print("login failed");
					req.setAttribute("message", "Invalid credentials");
					RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
					rd.include(req, res);	//sends back response
				}
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}

}


