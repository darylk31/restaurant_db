import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class OracleConnect {
	
	public Connection con;
	public Statement stm;

	public static void main(String[] args) {
	}
	
	
	public void connect(){
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@dbhost.ugrad.cs.ubc.ca:1522:ug",
					"ora_v5f0b",
					"a38894135");
			
			stm = con.createStatement();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		return con;
	}
	
	public void endConnection() throws SQLException{
		con.close();
	}
	
}
