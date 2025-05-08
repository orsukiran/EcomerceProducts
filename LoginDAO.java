package ecomerce;

import java.sql.*;

public class LoginDAO
{
	
	public RegisterBean bb=null;
	
	public RegisterBean login(String uname,long pwd)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from register where name=? and pwd=?");
			ps.setString(1, uname);
			ps.setLong(2, pwd);
		   ResultSet rs=ps.executeQuery();
		   if(rs.next())
		   {
			   
			   bb=new RegisterBean();
			   
			   bb.setName(rs.getString(1));
			   bb.setEmail(rs.getString(2));
			   bb.setPhno(rs.getLong(3));
			   bb.setPwd(rs.getString(4));
			   bb.setCpwd(rs.getString(5));
			   
		   }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return bb;
		
	}

}