import java.sql.ResultSet;
import java.sql.SQLException;

public class Manager {
	
	OracleConnect oracleConnect;
	
	public Manager(){
		oracleConnect = new OracleConnect();
	}
	
	public ResultSet deliveryQuery(){
		return oracleConnect.selectTable("delivery");
	}
	
	public ResultSet dineInQuery(){
		return oracleConnect.selectTable("dinein");
	}
	
	public ResultSet takeOutQuery(){
		return oracleConnect.selectTable("takeout");
	}
	
	public ResultSet orderQuery(){
		return oracleConnect.selectTable("order");
	}
	
	public ResultSet employeeQuery(){
		return oracleConnect.selectTable("employee");
	}
	
	public ResultSet inventoryQuery(){
		return oracleConnect.selectTable("inventory");
	}
	
	public ResultSet customerQuery(){
		return oracleConnect.selectTable("customer");
	}
	
	public ResultSet menuQuery(){
		return oracleConnect.selectTable("menu");
	}
	
	public ResultSet accountQuery(){
		return oracleConnect.selectTable("account");
	}
	
	public ResultSet kitchenQuery(){
		return oracleConnect.selectTable("kitchen");
	}
	
	public ResultSet frontEndQuery(){
		return oracleConnect.selectTable("frontend");
	}
	
	public ResultSet delivererQuery(){
		return oracleConnect.selectTable("deliverer");
	}
}
