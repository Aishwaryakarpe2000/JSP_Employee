package jsp_employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class EmployeeCrud {

	public Connection getConnection() throws Exception {
		//1.
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2.
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdb", "root", "root");
		return con;
	}

	public int signUp(Employee e) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?,?,?)");
		ps.setInt(1, e.getId());
		ps.setString(2, e.getName());
		ps.setLong(3, e.getPhone());
		ps.setString(4, e.getAddress());
		ps.setString(5, e.getEmail());
		ps.setString(6, e.getPassword());

		int count = ps.executeUpdate();
		con.close();
		return count;
	}

	public String login(String email) throws Exception {

		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement("select password from employee where email=?");
		ps.setString(1, email);

		ResultSet rs = ps.executeQuery();
		String password = null;
		while (rs.next()) {
			password = rs.getString("password");
		}
		con.close();
		return password;
	}
	
	public List<Employee> display() throws Exception {

		Connection con = getConnection();
		// 3.
		PreparedStatement prst = con.prepareStatement("Select * from employee");

		List<Employee> list = new ArrayList<Employee>();

		// 4.
		ResultSet resultSet = prst.executeQuery();

		while (resultSet.next()) {

			Employee e = new Employee();
			e.setId(resultSet.getInt("id"));
			e.setName(resultSet.getString("name"));
			e.setPhone(resultSet.getLong("phone"));
			e.setAddress(resultSet.getString("address"));
			e.setEmail(resultSet.getString("email"));
			e.setPassword(resultSet.getString("password"));

			list.add(e);

		}
		// 5.
		con.close();
		return list;
	}

	public int delete(int id) throws Exception {
		
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("delete from employee where id=?");
		ps.setInt(1, id);

		int count = ps.executeUpdate();
		con.close();
		return count;
	}
	
	

	public Employee find(int id) throws Exception {
		
		Connection con = getConnection();
		// 3.
		PreparedStatement prst = con.prepareStatement("Select * from employee where id=?");
		prst.setInt(1,id);
		List<Employee> list = new ArrayList<Employee>();

		//4.
		ResultSet resultSet = prst.executeQuery();

		Employee e = new Employee();
		while (resultSet.next()) {
			e.setId(resultSet.getInt("id"));
			e.setName(resultSet.getString("name"));
			e.setPhone(resultSet.getLong("phone"));
			e.setAddress(resultSet.getString("address"));
			e.setEmail(resultSet.getString("email"));
			e.setPassword(resultSet.getString("password"));

			list.add(e);

		}
		// 5.
		con.close();
		return e;
		
	}

	public int update(Employee e) throws Exception {
		
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("Update employee set name=?,phone=?,address=?,email=?,password=? where id=?");
		ps.setInt(6, e.getId());
		ps.setString(1, e.getName());
		ps.setLong(2, e.getPhone());
		ps.setString(3, e.getAddress());
		ps.setString(4, e.getEmail());
		ps.setString(5, e.getPassword());

		int count = ps.executeUpdate();
		con.close();
		return count;
		
	}

}
