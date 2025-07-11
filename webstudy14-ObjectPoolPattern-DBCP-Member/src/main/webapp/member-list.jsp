<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
<style>
table {
	width: 100%;
	border-collapse: collapse; /* 테두리 겹치게 설정  */
}

th {
	background-color: rgb(195, 229, 229);
}

th, td {
	border: 1px solid black;
	padding: 8px;
	text-align: center;
}
</style>
</head>
<body>

	<h4>${param.address}에 사는 회원명단</h4>
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="member">
				<tr>
					<td>${member	.name}</td>
					<td>${member.address}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>