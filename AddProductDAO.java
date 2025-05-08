package ecomerce;

import java.sql.*;

public class AddProductDAO
{
	public int k=0;
	public int AddProduct(AddProductBean cb)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into product2 values(?,?,?,?)");
			
			ps.setString(1, cb.getPcode());
			ps.setString(2, cb.getPname());
			ps.setFloat(3, cb.getPprice());
			ps.setInt(4, cb.getPstock());
			
			k=ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		return k;
		
	}

}