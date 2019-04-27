<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="AirLine_Modify?id=${dto.id }" method="post" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${dto.id }">
	<table border="">
		<tr>
			<td>이미지</td>
			<td>사업자등록증</td>
			<td>회사명</td>
		</tr>
		<tr>
			<td><img alt=""src="../img/${dto.img }" width="200px" height="200px"></td>
			<td>${dto.crn }</td>
			<td>${dto.air_name }</td>
		</tr>
		<tr align="right" >
		<td colspan="3"><input type="submit" value="수정">
		<a href="AirLine_DeleteRequest?code=${dto.air_code }"><input type="button" value="삭제신청"></a></td>
		</tr>
	</table>
</form>
</body>
</html>