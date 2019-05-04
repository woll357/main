<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제요청 </title>
</head>
<body>
<form action="AirLine_DeleteRequestReg">
<input type="hidden" name="code" value="${code }">

	<table width=100% border="">
		<tr>
			<td>id</td><td><input type="text" name="id"></input>
		</tr>
		<tr>
			<td>사유</td><td><textarea name="request" rows="20" cols="22"></textarea></td>
		</tr>                           
		<input type="hidden" name="kind" value="항공사"></input>
		<tr>
		<td colspan="2" align="right"><input type="submit" value="요청"></td>
		</tr>
	</table>
</form>
</body>
</html>