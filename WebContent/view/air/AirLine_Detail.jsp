<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>

<form action="AirLine_Modify?id=${mem.id }" method="post" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${mem.id }">
	<table  width=100%  >
		<tr>
			<td style="background: #D4F4FA">이미지</td>
			<td style="background: #D4F4FA">사업자등록증</td>
			<td style="background: #D4F4FA">회사명</td>
		</tr>
		<tr>
			<td><img alt=""src="../img/${dto.img }" ></td>
			<td>${dto.crn }</td>
			<td>${dto.air_name }</td>
		</tr>
		<tr align="right" >
		<td colspan="3"><input type="submit" value="수정">
		<a href="AirLine_Delete?air_code=${mem.air_code }&id=${mem.id }&aotcont=in"><input type="button" value="삭제"></a></td>
		</tr>
	</table>
</form>
</body>
</html>