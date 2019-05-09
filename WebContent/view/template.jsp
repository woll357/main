<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="width: 1000px; margin-left: -500px; position: absolute; left: 50%">
<table celspacing="0" >
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
</div>
</body>
</html>