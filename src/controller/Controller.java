package controller;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import services.Tester;

public class Controller {

	private Tester tester;
	private String error = "";
	private ResultSet resultSet;
	private ResultSetMetaData resultSetMetaData;
	
	public Controller() throws SQLException {
		tester = new Tester("","","");
	}
	
	/**
	 * @param query
	 * this method send the query to the tester service for execution, and get the result or the error 
	 * @throws SQLException 
	 */
	public void executeQuery(String query) throws SQLException {
		tester.queryHandler(query);
		resultSet = tester.getResults();
		if(resultSet != null) {
			resultSetMetaData = tester.getMetaData();
		}else {
			error = tester.getError();
		}
	}
	
	/**
	 * 
	 * @return the error message
	 */
	public String getError() {
		String temp = error;
		error  = "";
		return temp;
	}
	
	/**
	 * 
	 * @return the result data
	 */
	public ResultSet getResult() {
		return resultSet;
	}
	
	/**
	 * 
	 * @return the metadata
	 */
	public ResultSetMetaData getMetaData() {
		return resultSetMetaData;
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
