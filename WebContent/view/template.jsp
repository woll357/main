<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table celspacing="0" width = 1000px >
	<tr>
		<td  height="50px"><jsp:include page="inc/top.jsp" /></td> 
	</tr>
	<tr>
		<td height="150px"><jsp:include page="inc/logo.jsp" /></td>
	</tr>
	<tr>
		<td height="50px"><jsp:include page="inc/subMenu.jsp" /></td>
	</tr>
	<tr>
		<td height="800px"><jsp:include page="${mainUrl }" /></td>
	</tr>
		<tr>
		<td height="50px"><jsp:include page="inc/bottom.jsp" /></td>
	</tr>
</table>
</body>
</html>