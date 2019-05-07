<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("utf-8"); %>
<script>

var today = new Date();
var todayReg = today.geFullYear()+"-"+today.getMonth()+"-"today.getDate();

</script>
	<table>
		<tr>
			<td>상품코드</td>
			<td>상품이름</td>
			<td>이륙날짜</td>
			<td>착륙날짜</td>
			<td>사람수</td>
			<td>고객id</td>
			<td>보딩</td>
		</tr>
		<c:forEach var="i" items="${reserveList }" >
		<tr>
			<td>${i.code }</td>
			<td>${i.itemName }</td>
			<td>${i.ddateStr }</td>
			<td>${i.fdateStr }</td>
			<td>${i.psn }</td>
			<td>${i.id }</td>
			<c:choose>
			<c:when test="${i.ddate }">
			
			</c:when>
			<c:when test="">
			
			</c:when>
			
			</c:choose>
			<td><a href="../airsell/BoardingReg?basketID=${i.basketID }&aotcont=in">보딩</a></td>
		</tr>
		</c:forEach>
		
	</table>