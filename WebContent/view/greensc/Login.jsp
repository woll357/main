<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="LoginReg" method="post">

<table border="">
	<tr>
		<td colspan="2">로그인 하세요</td>
	</tr>
	<tr>
		<td>ID</td>
		<td><input type="text" name="id"/></td>
	</tr>
	<tr>
		<td>PW</td>
		<td><input type="text" name="pw"/></td>
	</tr>
	<tr>
		<td colspan="2">
		
		<input type="submit" value="로그인"/>
		<a href="SignUp"><input type="button" value="회원가입"/></a>
		<a href="FindMySign"><input type="button" value="ID/PW찾기"/></a>
		
		</td>
	</tr>
</table>


</form>



</body>
</html>