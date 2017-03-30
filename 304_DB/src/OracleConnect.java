import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class OracleConnect {
	
	public Connection con;
	public Statement stm;

	public OracleConnect(){
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@dbhost.ugrad.cs.ubc.ca:1522:ug",
					"ora_ugrad",
					"a_stuID");
			
			stm = con.createStatement();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Unable to connect.");
		}
	}
	
	public Connection getConnection(){
		return con;
	}
	
	public void endConnection() throws SQLException{
		con.close();
	}
	
	public Statement getStatement(){
		return stm;
	}
	
}
