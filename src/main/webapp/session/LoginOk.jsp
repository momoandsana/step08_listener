<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>

    <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function() {
            // 로그아웃 링크 클릭 이벤트
            $("a").click(function(event) {
                if (confirm("로그아웃할래?")) {
                    location.href = "${pageContext.request.contextPath}/logout";
                }
            });

            // 테스트 버튼 클릭 이벤트
            $("#testButton").click(function() {
                alert("jQuery가 잘 작동합니다!");
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

<!-- 테스트 버튼 추가 -->
<button id="testButton">jQuery 테스트</button>

</body>
</html>
