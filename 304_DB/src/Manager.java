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
	
	public ResultSet inventoryQuery(){
		return oracleConnect.selectTable("inventory");
	}
	
	public ResultSet customerQuery(){
		return oracleConnect.selectTable("customer");
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
	
	public ResultSet findEmployee(String id) throws SQLException{
		if (id.isEmpty()) {
			return oracleConnect.selectAll("employee");
			}
		else return oracleConnect.getStatement().executeQuery("SELECT FROM employee WHERE id = " + id );
	}
	
	public ResultSet findInventory(String id) throws SQLException{
		if (id.isEmpty()) {
			return oracleConnect.selectAll("inventory");
			}
		else return oracleConnect.getStatement().executeQuery("SELECT FROM inventory WHERE id = " + id );
	}
	
	public ResultSet findMenu(String id) throws SQLException{
		if (id.isEmpty()) {
			return oracleConnect.selectAll("menu");
			}
		else return oracleConnect.getStatement().executeQuery("SELECT FROM menu WHERE id = " + id );
	}
	
	public ResultSet findOrder(String id) throws SQLException{
		if (id.isEmpty()) {
			return oracleConnect.selectAll("order");
			}
		else return oracleConnect.getStatement().executeQuery("SELECT FROM order WHERE id = " + id );
	}
}
