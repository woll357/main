<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제 신청 목록</title>
</head>
<body>
<table border="">
	<tr>
		<td>code</td>
		<td>아아디</td>
		<td>요청날짜</td>
		<td>종류</td>
		<td colspan="2">요청내용</td>
	</tr>
	<c:forEach var="dto" items="${data }" varStatus="no">
	<tr>
		<td>${dto.code }</td>
		<td>${dto.id }</td>
		<td>${dto.requsetdate }</td>
		<td>${dto.kind }</td>
		<td>${dto.request }</td>
		<td><a href="Air_DeleteRequestDelete?code=${dto.code }"><input type="button" value="삭제"></a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>