<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비향기 목록</title>
</head>
<body>

<h3>비행기 목록</h3>
<form action="Airplane_List2">
<input type="hidden" name="air_code" value="${dd }">
<table border="">
	<tr>
	<td>회사명</td>
	<td><input type="text" name="air_name"></td>
	<td  align="center"><input type="submit" value="검색" ></td>
	</tr>
	<tr>
	<!-- <td>비행기코드</td>
	<td><input type="text"></td> -->
	<!-- <td><input type="submit" value="검색"></td> -->
	</tr>
	
	<tr >
		<td colspan="2">회사명</td>
		<td > 비행기 코드</td>
	</tr>
<c:forEach var="dto" items="${data }" varStatus="no" >
	<tr>
	<td>${dto.air_name }</td><td>${dto.ap_code }</td><td><a href="Airplane_Delete?ap_code=${dto.ap_code }"><input type="button" value="삭제"></a></td>
	</tr>
	</c:forEach>
	
</table>
</form>
</body>
</html>