<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Insert title here</title>
</head>
<body>
<h2>회원 인증 Page</h2>

<form method="post" action="${pageContext.request.contextPath}/login">
  ID : <input type="text" name="userId" /><br/>
  PWD : <input type="password" name="userPwd" /><br/>
  NAME : <input type="text" name="userName" /><br/>

  <input type="submit" value="로그인" />
</form>

</body>
</html>
