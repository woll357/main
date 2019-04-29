<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비행기 등록</title>
</head>
<h4>비행기 등록</h4>
<body>
<form action="Airplane_InsertReg">
<%-- <input type="hidden" name="air_code" value="${dto }"> --%>
	<table border="">
		<tr>
			<td>항공사 코드</td><td><input type="text" name="air_code"></td>		
			<td>비행기 코드</td><td><input type="text" name="ap_code"></td>		
		</tr>
		<tr>
		<td colspan="4" align="right"><input type="submit" value="추가"></td>
		</tr>
	</table>
</form>
</body>
</html>