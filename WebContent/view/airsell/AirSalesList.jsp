<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("utf-8"); %>
<form action="">
	<table>
		<tr>
			<td>항공권명</td>
			<td>탑승날짜</td>
			<td>이륙날짜</td>
			<td>매출액</td>
		</tr>
		<c:forEach var="i" items="${salesList }" >
		<tr>
			<td>${i.itemName }</td>
			<td>${i.ddate }</td>
			<td>${i.fdate }</td>
			<td>${i.totalPrice }</td>
		</tr>
		</c:forEach>
		<tr>
		<td>총매출</td>
		<td>${totalSalse }</td>
		</tr>
	</table>
</form>