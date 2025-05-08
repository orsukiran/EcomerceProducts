<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ecomerce.AddProductBean" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      padding: 40px;
      text-align: center;
    }

    .table-container {
      max-width: 900px;
      margin: auto;
      background-color: #fff;
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
    }

    th, td {
      padding: 12px;
      text-align: left;
      border-bottom: 1px solid #ddd;
    }

    th {
      background-color: #007bff;
      color: white;
    }

    tr:hover {
      background-color: #f1f1f1;
    }

    .action-link {
      text-decoration: none;
      padding: 6px 12px;
      margin: 0 4px;
      border-radius: 4px;
      font-size: 13px;
      display: inline-block;
    }

    .edit {
      background-color: #007bff;
      color: white;
    }

    .edit:hover {
      background-color: #0056b3;
    }

    .delete {
      background-color: #dc3545;
      color: white;
    }

    .delete:hover {
      background-color: #a71d2a;
    }

    .button-container {
      margin-top: 30px;
    }

    button {
      background-color: #007bff;
      color: white;
      padding: 12px 24px;
      margin: 10px;
      border: none;
      border-radius: 6px;
      cursor: pointer;
      font-size: 16px;
    }

    button:hover {
      background-color: #0056b3;
    }
  </style>


<body>

<div class="table-container">
  <h2>Cart Items</h2>
  <table>
    <tr>
      <th>PCode</th>
      <th>Name</th>
      <th>Price</th>
      <th>Stock</th>
      <th>Actions</th>
    </tr>

    <%
      ArrayList<AddProductBean> al = (ArrayList<AddProductBean>) request.getAttribute("ram");
      for (AddProductBean i : al) {
    %>
    <tr>
      <td><%= i.getPcode() %></td>
      <td><%= i.getPname() %></td>
      <td><%= i.getPprice() %></td>
      <td><%= i.getPstock() %></td>
      <td>
        <a class="action-link delete" href="delete?pcode=<%=i.getPcode()%>">Delete</a>
        
        
      </td>
    </tr>
    <%
      }
    %>
  </table>
</div>

  <button onclick="location.href='Bill.html'">Generate Bill</button>

</body>
</html>