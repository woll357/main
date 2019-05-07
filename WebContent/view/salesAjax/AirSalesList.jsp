<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("utf-8"); %>
<table>
		<tr>
			<td>상품코드</td>
			<td>상품명</td>
			<td>출발도시</td>
			<td>도착도시</td>
			<td>시작날짜</td>
			<td>인원</td>
			<td>매출액</td>
			<td>이익</td>
		</tr>
		<c:forEach var="i" items="${salesList }">
		<tr>
			<td>${i.code }</td>
			<td>${i.itemName }</td>
			<td>${i.location1 }</td>
			<td>${i.location2 }</td>
			<td>${i.ddateStr }</td>
			<td>${i.psn }</td>
			<td>${i.totalPrice }</td>
			<td>${i.comSales }</td>
		</tr>
		</c:forEach>
		<tr>
		<td>총 매출액</td><td>${totalPrice }</td>
		<td>총 이익</td><td>${totalSalesPrice }</td>
		</tr>
</table>