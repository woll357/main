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
<%-- <input type="hidden" name="air_code" value="${dd }"> --%>
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
		<td colspan="">회사명</td>
		<td colspan="2"> 비행기 코드</td>
	</tr>
<c:forEach var="dto" items="${ddd }" varStatus="no" >
	<tr>
	<td>${dto.air_name }항공</td>
	<td><a href="Airplaneitem_List?ap_code=${dto.ap_code }">${dto.ap_code }</a></td>
	<td><a href="Airplane_Delete?ap_code=${dto.ap_code }"><input type="button" value="삭제"></a></td>
</c:forEach>
	<tr>
	<td colspan="3" align="right" ><a href="Airplane_Insert"><input type="button" value="등록"></a></td>
	</tr>
</table>
</form>
</body>
</html> 