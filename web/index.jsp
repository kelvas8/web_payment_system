<%@ page import="by.epam.task4.java.model.entity.Client" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Osten
  Date: 14.05.2018
  Time: 1:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Main</title>
  </head>
  <body>
  <table>
    <%
      ArrayList<Client> clients = (ArrayList<Client>)request.getAttribute("clients");
      String ooo = (String) request.getAttribute("client");
      for(Client client: clients) {
        out.println("<tr><td>"+client.toString()+"</td></tr>");
      }

    %>
  </table>

  <form name="mainform" method="post" action="/">
    <input type="submit" value="Insert">
    <input type="submit" value="Edit">
    <input type="submit" value="Delete">
  </form>
  </body>
</html>
