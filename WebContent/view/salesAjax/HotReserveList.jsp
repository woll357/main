<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("utf-8"); %>

	<table width="100%" style="text-align: center; border: 10px #dcefef solid;" cellspacing="0">
		<tr>
			<td style="border-bottom: 10px #dcefef solid;">방종류</td>
			<td style="border-bottom: 10px #dcefef solid;">체크인날짜</td>
			<td style="border-bottom: 10px #dcefef solid;">체크아웃날짜</td>
			<td style="border-bottom: 10px #dcefef solid;">사람수</td>
			<td style="border-bottom: 10px #dcefef solid;">고객id</td>
			<td style="border-bottom: 10px #dcefef solid;">체크인</td>
		</tr>
		<c:forEach var="i" items="${reserveList }" >
		<tr>
			<c:if test="${i.itemName=='S' }">
			<td>스탠다드</td>
			</c:if>
			<c:if test="${i.itemName=='D' }">
			<td>디럭스</td>
			</c:if>
			<td>${i.ddateStr }</td>
			<td>${i.fdateStr }</td>
			<td>${i.psn }</td>
			<td>${i.id }</td>
			<td><a href="../hotelsell/CheckInReg?basketID=${i.basketID }&hotcont=in">체크인</a></td>
		</tr>
		</c:forEach>
		
	</table>