<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>항공편</title>
<h2>항공편 검색 </h2>
</head>
<body>

<form action="AirCom_Detail" method="post">
	<table border="" >	
		<tr>
			<td colspan="2">항공편 코드</td>
			<td><input type="text" name="air_p"/></td>
			<input type="hidden" name="air_code" value="${air_code }">
			<input type="hidden" name="id" value="${id }">
			<td align="center"><input type="submit" value="선택  " /></td>
		</tr>
	<tr>
		<td>항공편코드</td>
		<td>회사명</td>
		<td>출발지</td>
		<td>도착지</td>
	</tr>
<c:forEach var="dto" items="${data }" varStatus="no">	
	<tr>
	<td><%-- <a href="AirItem_Detail?ccode=${dto.ccode }">${dto.ccode }</a> --%><a href="Airp_List2?air_p=${dto.air_p }&air_code=${air_code }">${dto.air_p }</a></td>	
		<td>${dto.air_name }</td>
		<td>${dto.darea }</td>
		<td>${dto.carea }</td>
		
	</tr>
	</c:forEach>
	</table>

</form>


<%-- <form action="aircom_modify" method="post" >
<table border="">
	<input type="hidden" name="id" value="${id }">
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

<c:if test="${dto.seq==0 }">
		<td>파일</td><td>${dto.upfile }</td>
	</tr><tr>
</c:if>
	</table>
	</form> --%>
</body>
</html>