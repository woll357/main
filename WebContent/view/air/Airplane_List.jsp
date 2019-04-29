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
<form action="Airplane_Insert">
<input type="hidden" name="air_code" value="${dd }">
<table border="">
	<tr >
		<td colspan="2"> 비행기 코드</td>
	</tr>
<c:forEach var="dto" items="${data }" varStatus="no" >
	<tr>
	<td><a href="Airplaneitem_List?ap_code=${dto.ap_code }">${dto.ap_code }</a>
	<td><a href="Airplane_Delete?ap_code=${dto.ap_code }"><input type="button" value="삭제"></a></td>
	</tr>
	</c:forEach>
	<tr>
	<td colspan="2" align="right" ><input type="submit" value="등록"></td>
	</tr>
</table>
</form>
</body>
</html>
