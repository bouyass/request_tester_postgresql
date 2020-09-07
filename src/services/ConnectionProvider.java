package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	private Connection connection;
	
	public ConnectionProvider(String url, String user, String password) throws SQLException {
		if(this.connection == null) {
			this.connection = DriverManager.getConnection(url,user,password);
					
		}
	}
	
	public Connection getConnectionInstance() {
		return this.connection;
	}
	
	
}
