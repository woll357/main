<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <h2 align="center">호텔검색</h2> 
    <div align="center">
<form action="HlistSearch?partner=in" method="post">
	<table border="">
		<tr>
			<td style="background: #D4F4FA">코드검색</td>
			<td><input type="text" name="hcode" /></td>
			<td><input type="submit" value="검색" /></td>
		</tr>
	</table>
</form>
</div>
<div align="center">
<form action="HlistCountrySearch?partner=in" method="post">
	<table border="">
		<tr>
			<td style="background: #D4F4FA">나라검색</td>
			<td><select name="country">
				<option value="일본">일본</option>
				<option value="중국">중국</option>
				<option value="필리핀">필리핀</option>
				<option value="태국">태국</option>
			</select></td>
			<td><input type="submit" value="검색" /></td>
		</tr>
	</table>
</form>
</div>

<c:choose>

	<c:when test="${data.size()==0 }">
		<h1 align="center">검색결과가 없습니다.</h1>
	</c:when>
</c:choose>
<br><br>
<c:forEach var="dto" items="${data }" varStatus="no">
<div align="center">	
<table border="">
	<tr>
		<td style="background: #D4F4FA">호텔코드</td>
		<td style="background: #D4F4FA" colspan="2" width="200">${dto.hcode }</td>
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
	<td align="left" colspan="3"><a href="Hdetail?hcode=${dto.hcode }&partner=in">관리자상세조회</a></td>
	</tr>

</table>
</div>
</c:forEach>