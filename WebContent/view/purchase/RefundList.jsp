<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("utf-8"); %>
<table border="" >
		<tr>
			<td>항공사명</td>
			<td>비행기코드</td>
			<td>출발날짜</td>
			<td>도착날짜</td>
			<td>출발도시</td>
			<td>도착도시</td>
			<td>예약인원</td>
		</tr>
		<c:forEach var="bpdto" items="${bpdtos }"   >
		<tr>
			<td>${bpdto.cName }</td>
			<td>${bpdto.itemName }</td>
			<td>${bpdto.ddateStr }</td>
			<td>${bpdto.fdateStr }</td>
			<td>${bpdto.location1 }</td>
			<td>${bpdto.location2 }</td>
			<td>${bpdto.psn }</td>
		</tr>
		</c:forEach>
	</table>