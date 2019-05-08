<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("utf-8"); %>
<table width="100%" style="text-align: center; border: 10px #dcefef solid;" cellspacing="0">
		<tr>
			<td style="border-bottom: 10px #dcefef solid;">상품코드</td>
			<td style="border-bottom: 10px #dcefef solid;">상품명</td>
			<td style="border-bottom: 10px #dcefef solid;">출발도시</td>
			<td style="border-bottom: 10px #dcefef solid;">도착도시</td>
			<td style="border-bottom: 10px #dcefef solid;">시작날짜</td>
			<td style="border-bottom: 10px #dcefef solid;">인원</td>
			<td style="border-bottom: 10px #dcefef solid;">매출액</td>
			<td style="border-bottom: 10px #dcefef solid;">이익</td>
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
		<td></td><td></td><td></td><td></td><td></td>
		<td>총액</td><td>${totalPrice }</td>
		<td>${totalSalesPrice }</td>
		</tr>
</table>