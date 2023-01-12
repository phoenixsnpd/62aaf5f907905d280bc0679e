<%@ page import="ua.ithillel.homework30.OrderRepository" %>
<%@ page import="org.springframework.ui.Model" %><%--
  Created by IntelliJ IDEA.
  User: denyspolukhin
  Date: 12.01.2023
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order by ID</title>
</head>
<body>
<%= new OrderRepository().getByOrderId(Long.parseLong(request.getParameter("id")))%>
</body>
</html>

