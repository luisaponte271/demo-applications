import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class Principal {
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost/";
		String db = "test_db";
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(url + db, "root","mysql");
			PreparedStatement ps =null;
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery("select * from employees");
			while(rs.next()) { 
				System.out.println(rs.getString("first_name") + " " + 
								   rs.getString("email_address"));
			}
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
