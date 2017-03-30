import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Connect {
	
	static Connection con;

	public static void main(String[] args) {
		
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@dbhost.ugrad.cs.ubc.ca:1521:ug",
					"username",
					"password");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void endConnection(){
	
	}
}
