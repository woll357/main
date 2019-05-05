<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("utf-8"); %>
<form action="">
	<table>
		<tr>
			<td>회사명</td>
			<td>상품종류</td>
			<td>상품명</td>
			<td>시작날짜</td>
			<td>끝날짜</td>
			<td>고객id</td>
			<td>가격</td>
			<td>가격</td>
		</tr>
		<c:forEach var="i" items="${managerSellList }" >
		<tr>	
			<td>${i.cName }</td>
			<td>${i.cType }</td>
			<td>${i.itemName }</td>
			<td>${i.ddate }</td>
			<td>${i.fdate }</td>
			<td>${i.id }</td>
			<td>${i.totalPrice }</td>
			<td>${i.totalPrice }</td>
		</tr>
		</c:forEach>
		<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		</tr>
	</table>
</form>