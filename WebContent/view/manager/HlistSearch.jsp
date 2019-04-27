<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="dto" items="${data }" varStatus="no">	
<table border="">
	<tr>
		<td>호텔코드</td>
		<td colspan="2">${dto.hcode }</td>
	</tr>
	<tr>
		<td rowspan="3"><img src="../img/${dto.himg }" alt="" /></td>
		<td>${dto.country }</td>
		<td>${dto.city }</td>
	</tr>
	<tr>
	<td colspan="2">${dto.hname }</td>
	</tr>
	<tr>
	<td colspan="2">${dto.hinfo }</td>
	</tr>
	<tr>
	<td align="left" colspan="3"><a href="Hdetail?hcode=${dto.hcode }">관리자상세조회</a></td>
	</tr>

</table>
</c:forEach>