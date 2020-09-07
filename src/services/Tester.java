package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Tester {

	private ConnectionProvider cp;
	private Connection connection;
	private Statement state;
	private ResultSet resultSet;
	private ResultSetMetaData  resultSetMetaData;
	private String error = "";
	
	/**
	 * 
	 * @param url
	 * @param user
	 * @param password
	 * @throws SQLException
	 * create the connection & statement objects
	 */
	public Tester(String url, String user, String password) throws SQLException {
		cp = new ConnectionProvider("jdbc:postgresql://localhost:5432/postgres","postgres","admin");
		this.connection = cp.getConnectionInstance();
		this.state = this.connection.createStatement();
	}
	
	/**
	 * Execute the query and stores the result inside the resultset object
	 * @param query
	 * @throws SQLException 
	 */
	public void queryHandler(String query){
		 try {
			resultSet = state.executeQuery(query);
			resultSetMetaData = resultSet.getMetaData();
		} catch (SQLException e) {
			error = e.getMessage();
		}
	}
	
	/**
	 * @return the results of the last executed query
	 */
	public ResultSet getResults() {
		if(error.equals("")) {
			return resultSet;
		}
		return null;
	}
	
	/**
	 * @return the meta data of the last executed query
	 */
	public ResultSetMetaData getMetaData() {
		return resultSetMetaData; 
	}
	
	/**
	 * @return if the query fails, then the method will return an error 
	 */
	public String getError() {
		return this.error;
	}
	
	
	
}
