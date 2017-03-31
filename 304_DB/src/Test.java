import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test() {
		OracleConnect oc = new OracleConnect();
		Boolean test= oc.endConnection();
		assertTrue(test);
	}
}
