<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<link rel="stylesheet" href="../css/nh/tot.css" />
<br>
<table class = "ttcss" border="">
		<tr>
			<td class="wbbr">상품코드</td>
			<td class="wbbr">상품명</td>
			<td class="wbbr">시작날짜</td>
			<td class="wbbr">인원</td>
			<td class="wbbr">매출액</td>
			<td class="wbbr">이익</td>
		</tr>
		<c:forEach var="i" items="${salesList }">
		<tr>
			<td>${i.code }</td>
			<c:if test="${i.itemName=='S' }">
				<td>스탠다드</td>
			</c:if>
			<c:if test="${i.itemName=='D' }">
				<td>디럭스</td>
			</c:if>
			<td>${i.ddateStr }</td>
			<td>${i.psn }</td>
			<td>${i.totalPrice }</td>
			<td>${i.comSales }</td>
		</tr>
		</c:forEach>
		<tr>
		<td></td><td></td><td></td>
		<td>총액</td><td id="aa">${totalPrice }원</td>
		<td>${totalSalesPrice }원</td>
		</tr>
</table>