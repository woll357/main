<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="">
	<tr>
		<td></td>
		<td>항공사 코드</td>
		<td>아아디</td>
		<td>사업자등록번호</td>
		<td colspan="2">회사이름</td>
	</tr>
	<c:forEach var="dto" items="${data }" varStatus="no">
	<tr>
		<td><img src="../img/${dto.img }" width="100px" height="100px"></td>
		<td>${dto.air_code }</td>
		<td>${dto.id }</td>
		<td>${dto.crn }</td>
		<td>${dto.air_name }</td>
		<td><a href="AirLine_Modify?id=${dto.id }"><input type="button" value="수정"></a><br>
		<a href="AirLine_Delete?id=${dto.id }"><input type="button" value="삭제"></a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>