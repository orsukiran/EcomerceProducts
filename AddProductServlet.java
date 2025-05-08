package ecomerce;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
//import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/add")
public class AddProductServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		//HttpSession hs=req.getSession(false);
		AddProductBean ad=new AddProductBean();
		
		ad.setPcode(req.getParameter("pcode"));
		ad.setPname(req.getParameter("name"));
		ad.setPprice(Float.parseFloat(req.getParameter("price")));
		ad.setPstock(Integer.parseInt(req.getParameter("stock")));
		
		int k=new AddProductDAO().AddProduct(ad);
		
		if(k>0)
		{
//			ServletContext sv=req.getServletContext();
//			sv.setAttribute("msg", ad);
			
			
			
			
			HttpSession hs=req.getSession();
			hs.setAttribute("bean", ad);
			req.getRequestDispatcher("AddedProduct.jsp").forward(req, res);
		}
		
	
	}

}
