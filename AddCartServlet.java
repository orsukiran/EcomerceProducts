
package ecomerce;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/Add")
public class AddCartServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		AddCartBean ad=new AddCartDAO().getProduct(req.getParameter("pcode"));
		
		int k=new AddCartDAO().AddCartProduct(ad);
		
		if(k>0)
		{
//			HttpSession hs=req.getSession();
//			hs.setAttribute("bean", ad);
			//req.getRequestDispatcher("AddedProduct.jsp").forward(req, res);
			
			req.setAttribute("msg","cart added success");
			req.getRequestDispatcher("AddCartPass.jsp").forward(req, res);
		}
		
	
	}

}
