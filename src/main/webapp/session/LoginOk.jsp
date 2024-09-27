<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.1.min.js"></script>

    <script type="text/javascript">
        $(function(){
            $("a").click(function(){
                if(confirm("로그아웃할래?")){
                    location.href = "${pageContext.request.contextPath}/logout";
                }
            });
        });
    </script>
</head>
<body>

<h3>
    ${sessionScope.sessionName} (${sessionScope.sessionId})님 로그인 중
    [접속시간 : ${sessionScope.creationTime}]
</h3>
<img src="images/bin.jpg" alt="Logout">
<p>
    <a href="#">로그아웃</a>
</p>

</body>
</html>
