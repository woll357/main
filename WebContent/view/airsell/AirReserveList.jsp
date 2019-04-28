<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("utf-8"); %>
<form action="">
	<table>
		<tr>
			<td>항공권명</td>
			<td>출발날짜</td>
			<td>도착날짜</td>
			<td>고객id</td>
			<td>체크인</td>
		</tr>
		<c:forEach var="i" items="${reserveList }" >
		<tr>
			<td>${i.itemName }</td>
			<td>${i.ddate }</td>
			<td>${i.fdate }</td>
			<td>${i.id }</td>
			<td><a href="BoardingReg?basketID=${i.basketID }&aotcont=in">탑승수속</a></td>
		</tr>
		</c:forEach>
		
	</table>
</form>