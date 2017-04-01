<select id="classSelect" onchange="location = this.value;">
	<option value="Manager.php">Manager</option>
	<option value="Employee.php">Employee</option>
	<option value="Customer.php">Customer</option>
</select>	
<p><font size ="2"> Find employee:</font></p>
<form method="POST" action="Manager.php">
<!--refresh page when submit-->
	eId:<input type="text" name="eId" size ="4"> Table:<input type="text" name ="table" size="18">
	<!--define one variable to pass the value-->
	<input type="submit" value="submit" name="doStuff">
	
</form></p>
<p><font size="2"> Grab menu:</font></p>
<form method="POST" action="Manager.php">
	<p><input type="number" size="4">
	<button type="managerButton"
			onclick="popup()">
			Submit</button>
</form>
<p><font size="2"> Grab inventory:</font></p>
<form method="POST" action="Manager.php">
	<p><input type="number" size="4">
	<button type="managerButton"
			onclick="popup()">
			Submit</button>
</form>
<p><font size="2"> Grab orders:</font></p>
<form method="POST" action="Manager.php">
	<p><input type="number" size="4">
	<button type="managerButton"
			onclick="popup()">
			Submit</button>
</form>
<p><font size="2"> Grab account:</font></p>
<form method="POST" action="Manager.php">
	<p><input type="number" size="4">
	<button type="managerButton"
			onclick="popup()">
			Submit</button>
</form>

<?php

$error = False;
$db = "(DESCRIPTION=(ADDRESS_LIST = (ADDRESS = (PROTOCOL = TCP)(HOST = dbhost.ugrad.cs.ubc.ca)(PORT = 1522)))(CONNECT_DATA=(SID=ug)))";
$db_conn = OCILogon("ora_v5f0b", "a38894135", "$db");

function findEmployee($cmdstr) {
    global $db_conn, $error;
    $statement = OCIParse($db_conn, "select * from employee where id = 1");

    if (!$statement) {
    		echo "<br>Cannot parse the following command: " . $cmdstr . "<br>";
    		$e = OCI_Error($db_conn); // For OCIParse errors pass the
    		// connection handle
    		echo htmlentities($e['message']);
    		$error = True;
    	}

    	$r = OCIExecute($statement, OCI_DEFAULT);
    	if (!$r) {
    		echo "<br>Cannot execute the following command: " . $cmdstr . "<br>";
    		$e = oci_error($statement); // For OCIExecute errors pass the statementhandle
    		echo htmlentities($e['message']);
    		$error = True;
    	} else {

    	}
    	return $statement;
}

function executePlainSQL($cmdstr) { //takes a plain (no bound variables) SQL command and executes it
	//echo "<br>running ".$cmdstr."<br>";
	global $db_conn, $error;
	$statement = OCIParse($db_conn, $cmdstr); //There is a set of comments at the end of the file that describe some of the OCI specific functions and how they work

	if (!$statement) {
		echo "<br>Cannot parse the following command: " . $cmdstr . "<br>";
		$e = OCI_Error($db_conn); // For OCIParse errors pass the       
		// connection handle
		echo htmlentities($e['message']);
		$error = True;
	}

	$r = OCIExecute($statement, OCI_DEFAULT);
	if (!$r) {
		echo "<br>Cannot execute the following command: " . $cmdstr . "<br>";
		$e = oci_error($statement); // For OCIExecute errors pass the statementhandle
		echo htmlentities($e['message']);
		$error = True;
	} else {

	}
	return $statement;

}

function printResult($result) { //prints results from a select statement
	echo "<br>Got data from table employee:<br>";
	echo "<table>";
	echo "<tr><th>ID</th><th>Name</th></tr>";

	while ($row = OCI_Fetch_Array($result, OCI_BOTH)) {
		echo "<tr><td>" . $row["ID"] . "</td><td>" . $row["NAME"] . "</td></tr>"; //or just use "echo $row[0]"
	}
	echo "</table>";

}

if ($db_conn) {

	if (array_key_exists('doStuff', $_POST) {
		$tuple = array(
				":bind1" => $_POST['eId'],
				":bind2" => $_POST('table']
		);
		$result = executeBoundSQL("select * from :bind2 where id = :bind1", $tuple);
		printResult($result);
	}

echo "<br>Started Connection<br>";
	if ($_POST && !$error) {
		//POST-REDIRECT-GET -- See http://en.wikipedia.org/wiki/Post/Redirect/Get
		header("location: Manager.php");
	} else {
	// Select data...
		$result = findEmployee($cmdstr);
		printResult($result);
	}

	//Commit to save changes...
	OCILogoff($db_conn);
} else {
	echo "cannot connect";
	$e = OCI_Error(); // For OCILogon errors pass no handle
	echo htmlentities($e['message']);
}


?>



