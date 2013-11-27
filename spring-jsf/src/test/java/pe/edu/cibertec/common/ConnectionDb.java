package pe.edu.cibertec.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDb {
	static Connection con;
	public ConnectionDb() {
	}

	public static Connection getConnection() {
		String url="jdbc:mysql://localhost:3306/dbwork";
		String user="root";
		String password="aep123";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
