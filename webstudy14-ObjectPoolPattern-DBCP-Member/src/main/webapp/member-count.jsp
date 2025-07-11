<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 
		아래 EL의 requestScope 생략 가능 (sessionScope, applicationScope 또한 생략 가능
		<%=request.getAttribute("totalMemberCount")%>
--%>
<h3>총 회원수 ${requestScope.totalMemberCount}</h3>
</body>
</html>