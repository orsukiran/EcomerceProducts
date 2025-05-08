
package ecomerce;

import java.sql.*;
import java.util.ArrayList;

public class ViewCartDAO
{
	@SuppressWarnings("rawtypes")
	
	public ArrayList al=null;
	
	public AddProductBean cb=null;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	
	public ArrayList ViewAll()
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from cart");
			
			ResultSet rs=ps.executeQuery();
			
			al=new ArrayList();
			
			while(rs.next())
			{
				cb=new AddProductBean();
				cb.setPcode(rs.getString(1));
				cb.setPname(rs.getString(2));
				cb.setPprice(rs.getFloat(3));
				cb.setPstock(rs.getInt(4));
				
				al.add(cb);
				
				
				}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	
		
		return al;
		
	}

}
