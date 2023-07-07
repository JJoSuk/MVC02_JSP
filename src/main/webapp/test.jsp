<%--
  Created by IntelliJ IDEA.
  User: joseoghwan
  Date: 2023/07/07
  Time: 4:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int sum = 0;
    for (int i = 0; i < 11; i++) {
        sum += i;
    }
%>
<%=sum%>
</body>
</html>
