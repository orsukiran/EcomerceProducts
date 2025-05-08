package ecomerce;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection 
{

	public static Connection con=null;
	static
	{
		try
		{
			Class.forName(DBInfo.dbDriver);
			 con=DriverManager.getConnection
					(DBInfo.dbUrl,DBInfo.duname,DBInfo.dpas);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
	public static Connection getCon()
	{
		return con;
	}

}
