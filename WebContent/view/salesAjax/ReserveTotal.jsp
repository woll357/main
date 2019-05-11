<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<br>
	<table class="ttcss" border="">
		<tr>
			<td class = "wbbr">회사명</td>
			<td class = "wbbr">상품종류</td>
			<td class = "wbbr">상품명</td>
			<td class = "wbbr">시작날짜</td>
			<td class = "wbbr">끝날짜</td>
			<td class = "wbbr">예약인원</td>
			<td class = "wbbr">고객id</td>
		</tr>
		<c:forEach var="i" items="${reserveTotalList }" >
		<tr>	
			<td>${i.cName }</td>
			<td>${i.cType }</td>
			<td>${i.itemName }</td>
			<td>${i.ddate }</td>
			<td>${i.fdate }</td>
			<td>${i.psn }명</td>
			<td>${i.id }</td>
		</tr>
		</c:forEach>
	</table>