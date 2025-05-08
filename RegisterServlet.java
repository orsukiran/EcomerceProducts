package ecomerce;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/reg")

public class RegisterServlet extends HttpServlet

{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		RegisterBean cb = new RegisterBean();

		cb.setName(req.getParameter("uname"));
		cb.setPwd(req.getParameter("pwd"));
		cb.setEmail(req.getParameter("email"));
		cb.setCpwd(req.getParameter("cpwd"));
		cb.setPhno(Long.parseLong(req.getParameter("phno")));

		int k = new RegisterDAO().register(cb);
		System.out.println(k);
		if (k > 0) {
			HttpSession hs = req.getSession();
			hs.setAttribute("cust", cb);
			req.getRequestDispatcher("RegisterPass.jsp").forward(req, res);

		} else {

			req.setAttribute("msg", "UserName alredy exits...");
			req.getRequestDispatcher("RegisterFail.jsp").forward(req, res);
		}

	}

}
