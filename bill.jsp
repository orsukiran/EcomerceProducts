<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ecomerce.AddCartBean" import="java.util.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Generated Bill</title>
    <style>
        table {
            width: 50%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        .total-row {
            font-weight: bold;
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>

<h2 style="text-align: center;">Generated Bill</h2>

<table>
    <tr>
        <th>PCode</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Subtotal</th>
    </tr>

    <% 
        // Fetch cart items from request attributes
        List<AddCartBean> cartItems = (List<AddCartBean>) request.getAttribute("cartItems");
        double totalAmount = (Double) request.getAttribute("totalAmount");

        // Loop through cart items and display them
        for (AddCartBean item : cartItems) {
    %>
        <tr>
            <td><%= item.getPcode() %></td>
            <td><%= item.getPname() %></td>
            <td><%= item.getPprice() %></td>
            <td><%= item.getPstock() %></td>
            <td><%= item.getPprice() * item.getPstock() %></td>
        </tr>
    <% } %>

    <tr class="total-row">
        <td colspan="4">Total</td>
        <td><%= totalAmount %></td>
    </tr>
</table>

</body>
</html>
