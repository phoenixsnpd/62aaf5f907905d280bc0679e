<%@ page import="ua.ithillel.homework30.Order" %>
<%@ page import="java.util.Date" %>
<%@ page import="ua.ithillel.homework30.OrderRepository" %><%--
  Created by IntelliJ IDEA.
  User: denyspolukhin
  Date: 12.01.2023
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test JSP</title>
</head>
<body>
There are next orders:

<p><%= new OrderRepository().getAllOrders()%></p>
</body>
</html>
