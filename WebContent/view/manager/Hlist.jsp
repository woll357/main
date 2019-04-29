<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>관리자호텔리스트보기</h2>

<form action="HlistSearch">
	<table border="">
		<tr>
			<td>호텔코드로검색</td>
			<td><input type="text" name="hcode" /></td>
			<td><input type="submit" value="검색" /></td>
		</tr>
	</table>

</form>
<c:forEach var="dto" items="${data }" varStatus="no">	
<table border="">
	<tr>
		<td>호텔코드</td>
		<td colspan="2" width="200">${dto.hcode }</td>
	</tr>
	<tr>
		<td rowspan="3" width="220"><img src="../img/${dto.himg }" alt="" /></td>
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
		<td colspan="3">${dto.addDetail }</td>
	</tr>
	<tr>
	<td align="left" colspan="3"><a href="Hdetail?hcode=${dto.hcode }&partner=in">관리자상세조회</a></td>
	</tr>


</table>
</c:forEach>