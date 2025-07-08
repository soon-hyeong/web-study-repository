<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step2-jstl-if</title>
</head>
<body>
<h2>step2-jstl-if</h2>
<%--
	$ : EL의 표현 기호
	${param} 은 request.getParameter("nick")의 줄임말
	
	<%>
	<%
	MemberVO member = (MemberVo)request.getAttribute("member");
	%>
	<%=member.getAddress() %>
	위 코드를 아래와 같이 EL을 적용하면 다음과 같이 표현 할 수 있다.
	아래 EL 표현식은 다음과 같다
	${member.address} 
						
--%>
<strong>${param.nick} ${param.age}}</strong>
<br><br>
<c:if test="${param.nick=='아이유'}">
	<h3>사용자 닉네임 : ${param.nick}</h3>
</c:if>
<hr>
<c:if test="${param.nick=='아이유' && param.age<30 }">
	<h3>두번쨰 if 실행</h3>
</c:if>
</body>
</html>