<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="../css/dk/input.css" type="text/css">
<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">

<h2>..?</h2>
<form action="AirCom_Detail" method="post">
<table>
		<tr>
			<td >항공편 코드</td>
			<td><input type="text" name="air_p"/></td>
			<input type="hidden" name="air_code" value="${air_code }">
			<input type="hidden" name="id" value="${id }">
			<td align="center"><input class="btncss2" type="submit" value="선택  " /></td>
		</tr>
	<tr>
		<td>항공편코드</td>
		<td>출발지</td>
		<td>도착지</td>
	</tr>
<c:forEach var="dto" items="${data }" varStatus="no">	
	<tr>
	<td><a href="Airp_List2?air_p=${dto.air_p }&air_code=${air_code }&aotcont=in">${dto.air_p }</a></td>	
		<td>${dto.darea }</td>
		<td>${dto.carea }</td>
		
	</tr>
	</c:forEach>
	</table>

</form>
