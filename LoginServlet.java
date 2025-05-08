package ecomerce;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nam=req.getParameter("uname");
		long pa=Long.parseLong(req.getParameter("pwd"));
		
		RegisterBean cb=new LoginDAO().login(nam, pa);
		
		if(cb==null)
		{
			req.setAttribute("msg", "login Invalid");
			req.getRequestDispatcher("LoginPass.jsp").forward(req, resp);
		
		}
		else
		{
			
			
			
			
			HttpSession hs=req.getSession();
			hs.setAttribute("bean", cb);
			req.getRequestDispatcher("LoginPass.jsp").forward(req, resp);
			
			
//			ServletContext sc = req.getServletContext();
//			sc.setAttribute("bean",cb );
//			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}

}
