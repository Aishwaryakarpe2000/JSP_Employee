package jsp_employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/edit")
public class EditController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		long phone = Long.parseLong(req.getParameter("phone"));
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Employee e = new Employee();
		e.setId(id);
		e.setName(name);
		e.setPhone(phone);
		e.setAddress(address);
		e.setEmail(email);
		e.setPassword(password);

		EmployeeCrud crud = new EmployeeCrud();
		try {
			int result = crud.update(e);
			if (result != 0) {

				Cookie[] cookies=req.getCookies();
				String value=null;
				for(Cookie c:cookies)
				{
					if(c.getName().equals("Emp"))
					{
						value=c.getValue();
					}
				}
				req.setAttribute("c", value);
				List<Employee> es=crud.display();
				req.setAttribute("list", es);
				
				RequestDispatcher rd=req.getRequestDispatcher("display.jsp");
				rd.forward(req, res);
				// pw.print("Data inserted..!");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
}
