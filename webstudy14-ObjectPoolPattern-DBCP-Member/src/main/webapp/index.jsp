<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Object Pool Pattern : DBCP</title>
</head>
<body>
<br><br><br>
 <a href="front?commabd=Test">web test</a><br>
<img src="front-all.png" width="50%">
 <%--

 --%>
 <br><br><br>
 <%--
 		index -- Front -- HandlerMapping --Controller
 												|
 											GetTotalMemberCountController <---> MemberDao <---> DatasourceManager(DBCP)
 												|
 												|forward
 											member-count.jsp
  --%>
<h3>회원관리</h3>
<a href="front?command=GetTotalMemberCount">총 회원수 확인</a>
<form action="front?command=FindMemberById" method="get">
	<input type="hidden" name="command" value="FindMemberById">
	<input type="text" placeholder="아이디" name="memberId" required="required">
	<button type="submit">아이디로 회원 찾기</button>
</form>
<br>
<form action="front" method="get">
	<input type="hidden" name="command" value="FindMemberListByAddress">
	<input type="text" name="address" placeholder="주소" required="required">
	<button type="submit">주소로 회원 찾</button>
</form>


</body>
</html>