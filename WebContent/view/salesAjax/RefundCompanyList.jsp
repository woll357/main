<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("utf-8"); %>
<table width="100%" style="text-align: center; border: 10px #dcefef solid;" cellspacing="0">
		<tr>
			<td style="border-bottom: 10px #dcefef solid;">회사명</td>
			<td style="border-bottom: 10px #dcefef solid;">상품명</td>
			<td style="border-bottom: 10px #dcefef solid;">시작날짜</td>
			<td style="border-bottom: 10px #dcefef solid;">끝날짜</td>
			<td style="border-bottom: 10px #dcefef solid;">환불날짜</td>
			<td style="border-bottom: 10px #dcefef solid;">고객id</td>
		</tr>
		<c:forEach var="i" items="${refundLists }">
		<tr>
			<td>${i.cName }</td>
			<td>${i.itemName }</td>
			<td>${i.ddateStr }</td>
			<td>${i.fdateStr }</td>
			<td>${i.bdateStr }</td>
			<td>${i.id }</td>
		</tr>
		</c:forEach>
</table>
