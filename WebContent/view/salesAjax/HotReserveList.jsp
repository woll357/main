<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("utf-8"); %>

	<table>
		<tr>
			<td>방이름</td>
			<td>체크인날짜</td>
			<td>체크아웃날짜</td>
			<td>사람수</td>
			<td>고객id</td>
			<td>체크인</td>
		</tr>
		<c:forEach var="i" items="${reserveList }" >
		<tr>
			<td>${i.itemName }</td>
			<td>${i.ddateStr }</td>
			<td>${i.fdateStr }</td>
			<td>${i.psn }</td>
			<td>${i.id }</td>
			<td><a href="../hotelsell/CheckInReg?basketID=${i.basketID }&hotcont=in">체크인</a></td>
		</tr>
		</c:forEach>
		
	</table>