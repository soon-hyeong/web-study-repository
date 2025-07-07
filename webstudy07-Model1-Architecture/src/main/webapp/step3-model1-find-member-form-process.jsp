<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="org.kosa.member.model.*"%>

<%
MemberDao memberDao = new MemberDao();
// client가 보낸 회원 아이디를 받는다
String memberId = request.getParameter("memberId");
MemberVo findMember = memberDao.findMemberById(request.getParameter("memberId"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
	java 아이디에 대한 회원 정보
	이름 : 손흥민 주소: 런던
	or
	java7 아이디에 대한 회원 정보
	회원 정보가 존재하지 않습니다
 --%>
	<p><%=memberId%>
		아이디에 대한 회원 정보
	</p>
	<%
	if (findMember != null) {
	%>
	<p>
		이름 :
		<%=findMember.getName()%>
		주소:
		<%=findMember.getAddress()%></p>
	<%
	} else {
	%>
	<p>회원 정보가 존재하지 않습니다</p>
	<%
	}
	%>
</body>
</html>