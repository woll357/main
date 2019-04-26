<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="AirLine_ModifyFm" method="post"  enctype="multipart/form-data">
<table border="">
	<input type="hidden" name="id" value="${dto.id }">
	<tr>
		<td>이미지<input type="file"></td>
		<td>사업자등록증</td>
		<td>회사명</td>
	</tr>
	<tr>
		<td><img alt=""src="../img/${dto.img }" width="200px" height="200px"></td>
		<td><input type="text" name="crn" value="${dto.crn }"></td>
		<td><input type="text" name=air_name value="${dto.air_name }"></td>
	</tr>
	<tr align="right">
	<td colspan="3"><input type="submit" value="수정" ></td>
	</tr>

<%-- <c:if test="${dto.seq==0 }">
		<td>파일</td><td>${dto.upfile }</td>
	</tr><tr>
</c:if> --%>
	</table>
	</form>
</body>
</html>