package controller;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import services.Tester;

public class Controller {

	private Tester tester;
	private String error;
	
	public Controller() throws SQLException {
		tester = new Tester("","","");
	}
	
	/**
	 * @param query
	 * this method send the query to the tester service for execution, and get the result or the error 
	 */
	public void executeQuery(String query) {
		tester.queryHandler(query);
		ResultSet resultSet = tester.getResults();
		if(resultSet != null) {
			ResultSetMetaData resultSetMetaData = tester.getMetaData();
		}else {
			error = tester.getError();
		}
	}
	
	
	/**
	 * 
	 * @param url
	 * @param user
	 * @param password
	 */
	public void establishConnection(String url, String user, String password) {
		// this method will be implemented when the multi databases feature is enabled 
	}
	
	
	
}
