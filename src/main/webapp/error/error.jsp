<%--
  Created by IntelliJ IDEA.
  User: swift
  Date: 2024-09-26
  Time: 오후 2:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script>
    alert("${requestScope.errMsg}");
    location.href="${pageContext.request.contextPath}/session/LoginForm.jsp";
</script>
</body>
</html>
