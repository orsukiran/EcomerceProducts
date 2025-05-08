package ecomerce;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.*;
import java.util.*;

@WebServlet("/Bill")



public class BillServlet extends HttpServlet {
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Setup a connection to the database (make sure to replace with your connection details)
    	
    	
        Connection connection = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_db", "username", "password");

            BillDAO cartDAO = new BillDAO(connection);
            List<AddCartBean> cartItems = cartDAO.getCartItems();
            double totalAmount = 0;

            // Calculate subtotal for each item
            for (AddCartBean item : cartItems) {
                totalAmount += item.getPprice() * item.getPstock();
            }

            // Set the cart items and total amount as request attributes
            request.setAttribute("cartItems", cartItems);
            request.setAttribute("totalAmount", totalAmount);

            // Forward the request to the JSP page
            RequestDispatcher dispatcher = request.getRequestDispatcher("/bill.jsp");
            dispatcher.forward(request, response);

        }
        
        catch (SQLException e)
        {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error occurred");
        }
    }
}
