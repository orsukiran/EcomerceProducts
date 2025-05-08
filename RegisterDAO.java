package ecomerce;

import java.io.*;
import java.sql.*;
@SuppressWarnings("unused")
public class RegisterDAO
{

	 
	// public RegisterBean rb=null;
  
	 public int register(RegisterBean rb)
	 {
		 int k=0;
		 try
		 {
			 Connection con=DBConnection.getCon();
			 
			 PreparedStatement ps=con.prepareStatement
					 ("insert into register values(?,?,?,?,?)");
			 
			 ps.setString(1, rb.getName());
			 ps.setString(2, rb.getEmail());
			 ps.setLong(3, rb.getPhno());
			 ps.setString(4, rb.getPwd());
			 ps.setString(5, rb.getCpwd());
			 
			 k=ps.executeUpdate();
			 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 
		 }
		 
		 
		 
		return k;
		 
	 }

}
