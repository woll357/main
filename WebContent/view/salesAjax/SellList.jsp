<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("utf-8"); %>
<table>
		<tr>
			<td>회사명</td>
			<td>상품종류</td>
			<td>상품명</td>
			<td>시작날짜</td>
			<td>인원</td>
			<td>매출액</td>
			<td>이익</td>
		</tr>
		<c:forEach var="i" items="${salesList }">
		<tr>
			<td>${i.cName }</td>
			<td>${i.cType }</td>
			<td>${i.itemName }</td>
			<td>${i.ddateStr }</td>
			<td>${i.psn }</td>
			<td>${i.totalPrice }</td>
			<td>${i.managerSales }</td>
		</tr>
		</c:forEach>
		<tr>
		<td>총 매출액</td><td>${totalPrice }</td>
		<td>총 이익</td><td>${totalSalesPrice }</td>
		</tr>
</table>