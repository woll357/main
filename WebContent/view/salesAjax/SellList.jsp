<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<br>
<table class = "ttcss" border="">
		<tr>
			<td class="wbbr">회사명</td>
			<td class="wbbr">상품종류</td>
			<td class="wbbr">상품명</td>
			<td class="wbbr">시작날짜</td>
			<td class="wbbr">인원</td>
			<td class="wbbr">매출액</td>
			<td class="wbbr">이익</td>
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
		<td colspan="4" align="right">총 매출액</td><td>${totalPrice }</td>
		<td>총 이익</td><td>${totalSalesPrice }</td>
		</tr>
</table>