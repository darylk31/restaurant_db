import java.sql.ResultSet;
import java.sql.SQLException;

public class Manager {
	
	OracleConnect oracleConnect;
	
	public Manager(){
		oracleConnect = new OracleConnect();
	}
	
	public ResultSet query(String arg){
		ResultSet result = null;
		try {
			result = oracleConnect.getStatement().executeQuery(arg);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Manager: query error.");
		}
		return result;
	}	
}
