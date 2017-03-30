import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class OracleConnect {
	
	public Connection con;

	public OracleConnect(){
		/*
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@dbhost.ugrad.cs.ubc.ca:1522:ug",
					"ora_t7y9a",
					"a39455134");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Unable to connect.");
		}
		
		System.out.println("Connected");
		*/
	}
	
	//JUnit test for connecting to ugrad.
	public boolean testConnect(){
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@dbhost.ugrad.cs.ubc.ca:1522:ug",
					"ora_t7y9a@ug",
					"a39455134");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Connection getConnection(){
		return con;
	}
	
	public void endConnection() throws SQLException{
		con.close();
	}
	
	public Statement getStatement() throws SQLException{
		return con.createStatement();
	}
	
	public ResultSet selectAll(String table){
		ResultSet result = null;
		try {
			result = con.createStatement().executeQuery("SELECT * FROM " + table);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Query error.");
		}
		return result;
	}
	
}
