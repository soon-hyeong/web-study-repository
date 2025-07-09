<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 검색 결과 화면</title>
</head>
<body>
<h3>고객 정보 검색 결과</h3>
<%--
	클라이언트 폼에서 전달한 정보
	<input type="text" name="customerId" required="required" placeholder="고객아이디">
	
	아래는 request.getParameter("");를 간단하게 EL로 표현
 --%>
고객 아이디 ${param.id}<br>
<%--
	FrontControllerServlet에서 request.setAttribute("customer", customerVo); 로 공유한 정보를
	<% CustomerVo customer = (CustomerVo)request.getAttribute("customer");
	<%=customer.getName()%>
	
	${customer.name}은 상세히 기술하면  ${requestScope.customer.name} 으로 표현할 수 있는데 scope는 생략 가능
 --%>
고객명 ${customer.name}<br> <%-- attribute는 requestScope와 applicationContext 부분으로 나뉘는데, requestScope는 생략이 가능하다 --%>
주소 ${customer.address}
</body>
</html>