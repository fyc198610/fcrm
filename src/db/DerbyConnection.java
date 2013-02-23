package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DerbyConnection {
	static Connection connect = null;
	public static void f_setConnect()
	{
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			connect= DriverManager.getConnection("jdbc:derby:crm");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Connection f_getConnect()
	{
		return connect;
	}
}
