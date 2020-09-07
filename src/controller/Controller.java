package controller;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import services.Tester;

public class Controller {

	private Tester tester;
	
	public Controller() throws SQLException {
		tester = new Tester("","","");
	}
	
	public void executeQuery(String query) {
		tester.queryHandler(query);
		ResultSet resultSet = tester.getResults();
		if(resultSet != null) {
			ResultSetMetaData resultSetMetaData = tester.getMetaData();
		}else {
			// send
		}
	}
	
	
}
