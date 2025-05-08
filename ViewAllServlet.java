package ecomerce;

import java.io.*;
import java.util.ArrayList;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewAllServlet extends HttpServlet
{
	@SuppressWarnings("rawtypes")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		ArrayList al=new ViewAllDAO().ViewAll();
		
		
		if(al==null)
		{
			req.setAttribute("msg", "No Data Found...");
			req.getRequestDispatcher("ViewEmpty.jsp").forward(req, resp);
			
		}
		else
		{
			req.setAttribute("ram", al);
			req.getRequestDispatcher("ViewAll.jsp").forward(req, resp);
		}
		
		
		
	}

}
