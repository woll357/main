<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="" width = 1500px >
	<tr>
		<td  height="50px"><jsp:include page="${topUrl }" /></td> 
	</tr>
	<tr>
		<td height="150px"><jsp:include page="inc/logo.jsp" /></td>
	</tr>
	<tr>
		<td height="50px"><jsp:include page="${subUrl }" /></td>
	</tr>
	<tr>
		<td height="500px"><jsp:include page="${mainUrl }" /></td>
	</tr>
		<tr>
		<td height="50px"><jsp:include page="inc/bottom.jsp" /></td>
	</tr>
</table>
</body>
</html>