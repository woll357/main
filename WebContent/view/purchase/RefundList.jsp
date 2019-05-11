<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<link rel="stylesheet" href="../css/nh/tot.css" />
<h2>환불내역조회</h2>
<table class="ttcss" border="">
		<tr>
			<td class="wbbr">회사명</td>
			<td class="wbbr">상품종류</td>
			<td class="wbbr">상품코드</td>
			<td class="wbbr">시작날짜</td>
			<td class="wbbr">끝날짜</td>
			<td class="wbbr"></td>
			<td class="wbbr"></td>
			<td class="wbbr">예약인원</td>
		</tr>
		<c:forEach var="bpdto" items="${bpdtos }"   >
		<tr>
			<td>${bpdto.cName }</td>
			<c:choose>
				<c:when test="${bpdto.cType=='A' }">
				<td>항공권</td>
				</c:when>
				<c:when test="${bpdto.cType=='H' }">
				<td>호텔</td>
				</c:when>
			</c:choose>
			<td>${bpdto.code }</td>
			<td>${bpdto.ddateStr }</td>
			<td>${bpdto.fdateStr }</td>
			<td>${bpdto.location1 }</td>
			<td>${bpdto.location2 }</td>
			<td>${bpdto.psn }</td>
		</tr>
		</c:forEach>
	</table>
	 <c:choose>
		<c:when test="${bpdtos.size()==0 }">
			<h2>조회된 결과가 없습니다.</h2>
		</c:when>
		</c:choose>