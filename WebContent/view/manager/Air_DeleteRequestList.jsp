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
<div align="center">
<h1>삭제신청목록</h1>

<table border="" width="100%" style="text-align: center; border: 10px #dcefef solid;" cellspacing="0">
		<c:choose>
	<c:when test="${data.size()==0 }">
		<h1 align="center">검색결과가 없습니다.</h1>
	</c:when>
	</c:choose>
	<tr>
		<td style="border-bottom: 10px #dcefef solid;">code</td>
		<td style="border-bottom: 10px #dcefef solid;">신청자아이디</td>
		<td style="border-bottom: 10px #dcefef solid;">요청날짜</td>
		<td style="border-bottom: 10px #dcefef solid;">종류</td>
		<td style="border-bottom: 10px #dcefef solid;" colspan="2">요청내용</td>
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
</div>
</body>
</html>