

import java.sql.*;
import java.util.Collection;

import javax.swing.*;


public class SqliteConnection {

/*	This class will attach to the card DB and allow access to the data with in.
	When called From outside it will return a active DB connection. It also uses the 
	Java Database Connector external library to talk to the SQLite database. 
	**Note remove the connection good bit later...**
	*/
	
	
	
	Connection conn = null;
	public static Connection dbConnector()
	{
		
		try 
		{
			Class.forName("org.sqlite.JDBC"); 
			Connection conn = DriverManager.getConnection("jdbc:sqlite:E:\\data\\bcardDB");
			JOptionPane.showMessageDialog(null, "Connection good!");
			return conn;
		}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e);
				return null;
			}
		
		
		
		
	}
	
	
}
