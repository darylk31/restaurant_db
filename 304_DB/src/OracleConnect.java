import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class OracleConnect {
	
	Connection con = null;

	public OracleConnect(){
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1522:ug",
					"ora_v5f0b",
					"a38894135");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Unable to connect.");
		}
	
	}
	
	public Connection getConnection(){
		return con;
	}
	
	public boolean endConnection(){
		try{
			con.close();}
		catch (SQLException e){
			return false;
		}
		return true;
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
