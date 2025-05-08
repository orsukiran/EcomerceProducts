package ecomerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddCartDAO {

	public int k=0;
	
	AddCartBean pb=null;

	public AddCartBean getProduct(String pcode)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from product2 where pcode=?");
			ps.setString(1, pcode);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				pb=new AddCartBean();
				pb.setPcode(pcode);
				pb.setPname(rs.getString(2));
				pb.setPprice(rs.getFloat(3));
				pb.setPstock(rs.getInt(4));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		} 
		finally 
		{
		}
		
		return pb;
	}

	
	
	public int AddCartProduct(AddCartBean pb)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into cart values(?,?,?,?)");
			
			ps.setString(1, pb.getPcode());
			ps.setString(2, pb.getPname());
			ps.setFloat(3, pb.getPprice());
			ps.setInt(4, pb.getPstock());
			
			k=ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		return k;
		
	}

	
}
