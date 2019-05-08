<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("utf-8"); %>
<div align="center">
<h1>환불내역조회</h1>
<table width="100%" style="text-align: center; border: 10px #dcefef solid;" cellspacing="0">
		<tr>
			<td style="border-bottom: 10px #dcefef solid;">회사명</td>
			<td style="border-bottom: 10px #dcefef solid;">상품종류</td>
			<td style="border-bottom: 10px #dcefef solid;">상품명</td>
			<td style="border-bottom: 10px #dcefef solid;">시작날짜</td>
			<td style="border-bottom: 10px #dcefef solid;">끝날짜</td>
			<td style="border-bottom: 10px #dcefef solid;"></td>
			<td style="border-bottom: 10px #dcefef solid;"></td>
			<td style="border-bottom: 10px #dcefef solid;">예약인원</td>
		</tr>
		<c:forEach var="bpdto" items="${bpdtos }"   >
		<tr>
			<td>${bpdto.cName }</td>
			<td>${bpdto.cType }</td>
			<td>${bpdto.itemName }</td>
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
	</div>